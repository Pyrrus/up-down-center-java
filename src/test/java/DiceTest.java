import org.junit.*;
import static org.junit.Assert.*;

public class DiceTest {
  @Test
  public void GetNumber() {
    Integer number = (Integer) Dice.getNumber();
    assertEquals(true, number instanceof Integer);
  }
}
