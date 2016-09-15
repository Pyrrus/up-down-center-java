import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {
  @Test
  public void make_Game() {
    Game gameTest = new Game(2);
    assertEquals(true, gameTest instanceof Game);
  }

  public void getPlayerNum_returnsPlayerNum(){
    Game gameTest = new Game(2);
    assertEquals(2, gameTest.getPlayerNum());
  }

  public void playerList_instantiatesCorrectly(){
    Game gameTest = new Game(2);
    assertEquals(2, gameTest.getPlayerList().size());
  }

  public void getCurrentPlayerIndex_instantiatesCorrectly(){
    Game gameTest = new Game(2);
    assertEquals(0, gameTest.getCurrentPlayerIndex());
  }

  public void getCurrentPlayerIndex_incrementsAfterNextTurn(){
    Game gameTest = new Game(2);
    gameTest.nextTurn();
    assertEquals(1, gameTest.getCurrentPlayerIndex());
  }

  public void getCurrentPlayer_backtoStartPlayer(){
    Game gameTest = new Game(2);
    gameTest.nextTurn();
    gameTest.nextTurn();
    assertEquals(0, gameTest.getCurrentPlayerIndex());
  }

  public void getCurrentPlayer_returnsPlayerObject(){
    Game gameTest = new Game(2);
    assertEquals(true, gameTest.getCurrentPlayer() instanceof Player);
  }

  public void winner_checksCoinsCorrectly(){
    Game gameTest = new Game(2);
    assertEquals(-1, gameTest.winner());
  }

  public void winner_checksWinnerCorrectly(){
    Game gameTest = new Game(1);
    assertEquals(0, gameTest.winner());
  }

  public void diceRoll_returnsString(){
    Game gameTest = new Game(1);
    assertEquals(true, gameTest.diceRoll() instanceof String);
  }

  public void coinAct_doesNothingOnD(){
    Game gameTest = new Game(3);
    gameTest.coinAct("N");
    assertEquals(3, gameTest.getCurrentPlayer().getCoin());
  }

  public void coinAct_removesCoinOnC(){
    Game gameTest = new Game(3);
    gameTest.coinAct("C");
    assertEquals(2, gameTest.getCurrentPlayer().getCoin());
  }

  public void coinAct_removesCoinOnR(){
    Game gameTest = new Game(3);
    gameTest.coinAct("D");
    assertEquals(2, gameTest.getCurrentPlayer().getCoin());
    assertEquals(4, gameTest.getPlayerList().get(gameTest.getCurrentPlayerIndex()+1).getCoin());
  }

  public void coinAct_removesCoinOnRonLastPlayerCorrectly(){
    Game gameTest = new Game(3);
    gameTest.nextTurn();
    gameTest.nextTurn();
    gameTest.coinAct("D");
    assertEquals(2, gameTest.getCurrentPlayer().getCoin());
    assertEquals(4, gameTest.getPlayerList().get(0).getCoin());
  }

  public void coinAct_removesCoinOnL(){
    Game gameTest = new Game(3);
    gameTest.nextTurn();
    gameTest.coinAct("U");
    assertEquals(2, gameTest.getCurrentPlayer().getCoin());
    assertEquals(4, gameTest.getPlayerList().get(gameTest.getCurrentPlayerIndex()-1).getCoin());
  }

  public void coinAct_removesCoinOnLonfirstPlayerCorrectly(){
    Game gameTest = new Game(3);
    gameTest.coinAct("U");
    assertEquals(2, gameTest.getCurrentPlayer().getCoin());
    assertEquals(4, gameTest.getPlayerList().get(2).getCoin());
  }
}
