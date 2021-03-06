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
    
    int[] throwsOne = bowlingGame.throw1.bothThrows; 
    int score = bowlingGame.throw1.score;
    
    int result = throwsOne[0] + throwsOne[1];
    
    String message = "Test if throw one + throw two is equal to score";
    
    assertEquals(message, score, result);
  }
  
  @Test
  public void validThrow() {
    Throw throw1 = new Throw(new int[] {5, 5});
    Throw throw2 = new Throw(new int[] {11, 0});
    Throw throw3 = new Throw(new int[] {2, -12});
    Throw throw4 = new Throw(new int[] {-1, 5});
    Throw throw5 = new Throw(new int[] {0, 0});
    
    assertTrue("failure - should be true 1", throw1.validThrow);
    assertFalse("failure - should be false 1", throw2.validThrow);
    assertFalse("failure - should be false 2", throw3.validThrow);
    assertFalse("failure - should be false 3", throw4.validThrow);
    assertTrue("failure - should be true 2", throw5.validThrow);
  }
  
  @Test
  public void ValidTenFrames() {
    Bowling bowlingGame2 = new Bowling();
    
    Throw[] myThrows = {
        new Throw(new int[] {1, 5}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 6})
        };
    
    Throw[] myThrows2 = myThrows.clone(); 
    Throw[] myThrows3 = myThrows.clone();
    Throw[] myThrows4 = new Throw[11];
    
    myThrows2[9] = new Throw(new int[] {1, -1});
    myThrows3[0] = new Throw(new int[] {7, 8});
    
    
    for(int i=0; i<11; i++) {
      myThrows4[i] = new Throw(new int[] {1, 1});
    }
    
    int score = bowlingGame2.playGame(myThrows);
    int score2 = bowlingGame2.playGame(myThrows2);
    int score3 = bowlingGame2.playGame(myThrows3);
    int score4 = bowlingGame2.playGame(myThrows4);
    
    
    assertEquals("should be valid 81", 81, score);
    assertEquals("should be invalid -1", -1, score2);
    assertEquals("should be invalid -1", -1, score3);
    assertEquals("should be invalid -1", -1, score4);
  }
  
  
  @Test
  public void strikeTest() {
    Bowling bowlingGame2 = new Bowling();
 
    Throw[] myThrows = {
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 6})
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 94", 94, score);
  }
  
  @Test
  public void spareTest() {
    Bowling bowlingGame2 = new Bowling();

    Throw[] myThrows = {
        new Throw(new int[] {1, 9}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 6})
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 88", 88, score);
  }
  
  @Test
  public void strikeSpareTest() {
    Bowling bowlingGame2 = new Bowling();

    Throw[] myThrows = {
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {4, 6}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 6})
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 103", 103, score);
  }
  
  @Test
  public void multiStrikeTest() {
    Bowling bowlingGame2 = new Bowling();
    
    
    Throw[] myThrows = {
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {0, 0}),
        new Throw(new int[] {0, 0}),
        new Throw(new int[] {0, 0}),
        new Throw(new int[] {0, 0}),
        new Throw(new int[] {0, 0}),
        new Throw(new int[] {0, 0}),
        new Throw(new int[] {0, 0}),
        new Throw(new int[] {0, 0})
        };
    
    Throw[] myThrows2 = {
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 6})
        };
     
    int score = bowlingGame2.playGame(myThrows);
    int score2 = bowlingGame2.playGame(myThrows2);
 
    assertEquals("should be valid 30", 30, score);
    assertEquals("should be valid 129", 129, score2);
  }
  
  @Test
  public void multiSpareTest() {
    Bowling bowlingGame2 = new Bowling();
    
    Throw[] myThrows = {
        new Throw(new int[] {8, 2}),
        new Throw(new int[] {5, 5}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 6})
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 98", 98, score);
  }
  
  
  @Test
  public void lastSpareTest() {
    Bowling bowlingGame2 = new Bowling();

    Throw[] myThrows = {
        new Throw(new int[] {1, 5}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 8}),
        new Throw(new int[] {7, 0})
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 90", 90, score);
  }
  
  
  @Test
  public void lastStrikeTest() {
    Bowling bowlingGame2 = new Bowling();

    Throw[] myThrows = {
        new Throw(new int[] {1, 5}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {7, 2})
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 92", 92, score);
  }
  
  @Test
  public void bonusIsStrikeTest() {
    Bowling bowlingGame2 = new Bowling();

    Throw[] myThrows = {
        new Throw(new int[] {1, 5}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {3, 6}),
        new Throw(new int[] {4, 4}),
        new Throw(new int[] {5, 3}),
        new Throw(new int[] {3, 3}),
        new Throw(new int[] {4, 5}),
        new Throw(new int[] {8, 1}),
        new Throw(new int[] {2, 8}),
        new Throw(new int[] {10, 0})
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 93", 93, score);
  }
  
  @Test
  public void bestScoreTest() {
    Bowling bowlingGame2 = new Bowling();

    Throw[] myThrows = {
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {10, 10}),
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 300", 300, score);
  }
  
  @Test
  public void realGameTest() {
    Bowling bowlingGame2 = new Bowling();

    Throw[] myThrows = {
        new Throw(new int[] {6, 3}),
        new Throw(new int[] {7, 1}),
        new Throw(new int[] {8, 2}),
        new Throw(new int[] {7, 2}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {6, 2}),
        new Throw(new int[] {7, 3}),
        new Throw(new int[] {10, 0}),
        new Throw(new int[] {8, 0}),
        new Throw(new int[] {7, 3}),
        new Throw(new int[] {10, 0}),
        };
     
    int score = bowlingGame2.playGame(myThrows);
 
    assertEquals("should be valid 135", 135, score);
  }
}
