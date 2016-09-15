import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {
  @Test
  public void make_player() {
    Player playerTest = new Player();
    assertEquals(true, playerTest instanceof Player);
  }

  @Test
  public void getCoin() {
    Player playerTest = new Player();
    assertEquals(3, playerTest.getCoin());
  }

  @Test
  public void removeCoin() {
    Player playerTest = new Player();
    playerTest.removeCoin();
    assertEquals(2, playerTest.getCoin());
  }

  @Test
  public void gainCoin() {
    Player playerTest = new Player();
    playerTest.gainCoin();
    assertEquals(4, playerTest.getCoin());
  }

  @Test
  public void getRoll_returnsmCoinif3orLess(){
    Player playerTest = new Player();
    assertEquals(3, playerTest.getRoll());
  }

  @Test
  public void getRoll_returnsmCoinifgreaterthan3(){
    Player playerTest = new Player();
    playerTest.gainCoin();
    assertEquals(3, playerTest.getRoll());
  }
}
