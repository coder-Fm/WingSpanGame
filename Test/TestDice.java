package Test;
import src.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestDice {

  Dice die;
  public List<String> DiceRolls;
  
  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Before
  public void setUp() {
    die = new Dice();
    DiceRolls = new ArrayList<String>();
    DiceRolls.add("Invertebrate");
    DiceRolls.add("Seed");
    DiceRolls.add("Fish");
    DiceRolls.add("Fruit");
    DiceRolls.add("Rodent");
  }
  
  
  @Test
  public void testRollDice() {
	  assertEquals(DiceRolls, die.getrolls());
  }

}
