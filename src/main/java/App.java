import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import java.util.ArrayList;
import java.util.*;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/game/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int playerNum = Integer.parseInt(request.queryParams("playerNum"));
      Game game = new Game(playerNum);
      request.session().attribute("game", game);
      model.put("game", game);
      model.put("template", "templates/game.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/game", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game game = request.session().attribute("game");
      String playerRoll = "";
      int numRolls = game.getCurrentPlayer().getRoll();
      for(int i = 0; i < numRolls; i++){
        playerRoll += game.diceRoll() + " ";
      }
      if(game.winner() == -1){
        do{
          game.nextTurn();
        } while(game.getCurrentPlayer().getCoin()==0);
      } else {
        model.put("win", game.winner() + 1);
      }
      model.put("game", game);
      model.put("playerRoll", playerRoll);
      model.put("template", "templates/game.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
