import java.util.List;
import java.util.ArrayList;

public class Game{
  private int mPlayerNum;
  private List<Player> mPlayerList= new ArrayList<Player>();
  private int mCurrentPlayer;
  private int mPot;

  public Game(int playerNum){
    mPlayerNum = playerNum;
    for(int i =0; i < playerNum; i++){
      mPlayerList.add(new Player());
    }
    mCurrentPlayer = 0;
    mPot=0;
  }

  public int getPlayerNum(){
    return mPlayerNum;
  }

  public List<Player> getPlayerList(){
    return mPlayerList;
  }

  public int getCurrentPlayerIndex(){
    return mCurrentPlayer;
  }

  public Player getCurrentPlayer(){
    return mPlayerList.get(mCurrentPlayer);
  }

  public int getPot(){
    return mPot;
  }

  public void nextTurn(){
    mCurrentPlayer++;
    if(mCurrentPlayer == mPlayerNum){
      mCurrentPlayer = 0;
    }
  }

  public int winner(){
    int winner = -1;
    int hasCoinCounter=0;
    for(int i = 0; i < mPlayerNum; i++){
      if(mPlayerList.get(i).getCoin() > 0){
        hasCoinCounter++;
        winner = i;
      }
    }
    if(hasCoinCounter == 1){
      return winner;
    } else {
      return -1;
    }
  }

  public void coinAct(String result) {
    Player cPlayer = mPlayerList.get(mCurrentPlayer);
    if (result == "D") {
      cPlayer.removeCoin();
      if (mCurrentPlayer + 1 == mPlayerNum) {
        mPlayerList.get(0).gainCoin();
      } else {
        mPlayerList.get(mCurrentPlayer + 1).gainCoin();
      }
    } else if (result == "U") {
      cPlayer.removeCoin();
      if (mCurrentPlayer == 0) {
        mPlayerList.get(mPlayerNum - 1).gainCoin();
      } else {
        mPlayerList.get(mCurrentPlayer - 1).gainCoin();
      }
    } else if (result == "C") {
      cPlayer.removeCoin();
      mPot++;
    }
  }

  public String diceRoll(){
    int numResult = Dice.getNumber();
    String result;
    switch(numResult){
      case 0:
        result="U";
        break;
      case 1:
        result="C";
        break;
      case 2:
        result="D";
        break;
      default:
        result="N";
        break;
    }
    coinAct(result);
    return result;
  }
}
