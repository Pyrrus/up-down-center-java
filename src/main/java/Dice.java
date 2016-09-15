import java.util.Random;

public final class Dice {
  private static int mNumber;

  public static void roll() {
    Random randomGenerator = new Random();
    mNumber = randomGenerator.nextInt(6);
  }

  public static int getNumber() {
    roll();
    return mNumber;
  }
}
