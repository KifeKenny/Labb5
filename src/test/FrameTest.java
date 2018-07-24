package test;

import static org.junit.Assert.*;
import org.junit.Test;

import index.*;


//testing value analysis
public class FrameTest {
  
  public Bowling bowlingGame = new Bowling();
  
  @Test
  public void frameOneScore() {
    
    int[] throwsOne = bowlingGame.throwOne.bothThrows; 
    int score = bowlingGame.throwOne.score;
    
    int result = throwsOne[0] + throwsOne[1];
    
    String message = "Test if throw one + throw two is equal to score";
    
    assertEquals(message, score, result);
  }
}
