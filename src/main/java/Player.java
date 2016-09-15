public class Player {
    private int mCoin;

    public Player() {
      mCoin = 3;
    }

    public int getCoin() {
      return mCoin;
    }

    public void removeCoin() {
      mCoin -= 1;
    }

    public void gainCoin() {
      mCoin += 1;
    }

    public int getRoll(){
      if(mCoin > 3){
        return 3;
      } else {
        return mCoin;
      }
    }
}
