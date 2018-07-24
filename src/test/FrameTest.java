package test;

import static org.junit.Assert.*;
import org.junit.Test;

import index.*;


//testing value analysis
public class FrameTest {
  
  public Bowling bowlingGame = new Bowling();
  
  @Test
  //tests that throw one + throw 2 equals the score
  public void frameOneScore() {
    
    int[] throwsOne = bowlingGame.throwOne.bothThrows; 
    int score = bowlingGame.throwOne.score;
    
    int result = throwsOne[0] + throwsOne[1];
    
    String message = "Test if throw one + throw two is equal to score";
    
    assertEquals(message, score, result);
  }
  
  @Test
  public void validScore() {
    Throw throw1 = new Throw(2, new int[] {5, 5});
    Throw throw2 = new Throw(2, new int[] {11, 0});
    Throw throw3 = new Throw(3, new int[] {2, -12});
    Throw throw4 = new Throw(4, new int[] {-1, 5});
    Throw throw5 = new Throw(4, new int[] {0, 0});
    
    assertTrue("failure - should be true 1", throw1.validThrow);
    assertFalse("failure - should be false 1", throw2.validThrow);
    assertFalse("failure - should be false 2", throw3.validThrow);
    assertFalse("failure - should be false 3", throw4.validThrow);
    assertTrue("failure - should be true 2", throw5.validThrow);
  }
}
