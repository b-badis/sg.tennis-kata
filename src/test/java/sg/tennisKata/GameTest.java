/**
 * 
 */
package sg.tennisKata;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sg.tennisKata.Game;
import sg.tennisKata.GameException;

/**
 * @author Badis
 *
 */
public class GameTest {
	static Game game = new Game("Player 1", "Player 2");
	
    @Test
    public void setWinnerTestException() {
    	Assertions.assertThrows(GameException.class, () -> game.setWinner(4));
    }

    @Test
    public void setWinnerTest() throws GameException {
    	game.setWinner(2);
    	assertEquals(2, game.getWinner());
}

    @Test
    public void playTestRuntimeException() throws GameException {
    	game.setWinner(2);//game over (the winner is player 2)
    	Assertions.assertThrows(GameException.class, () -> game.playerScores(1));
    }

    @Test
    public void playTestIllegalArgumentException() {
    	Assertions.assertThrows(GameException.class, () -> game.playerScores(0));
    }

    @Test
    public void playTestPlayer1() throws GameException {
    	game.reset();
		game.playerScores(1);
		assertEquals(15, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(30, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(40, game.getPlayer1().getScore().getValue());		
		assertEquals("Player 1 : 0	-	Player 2 : 0\nPlayer 1 : 15	-	Player 2 : 0\nPlayer 1 : 30	-	Player 2 : 0\nPlayer 1 : 40	-	Player 2 : 0\n", game.showScores());
    }

    @Test
    public void playTestPlayer2() throws GameException {
    	game.reset();
		game.playerScores(2);
		assertEquals(15, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(30, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(40, game.getPlayer2().getScore().getValue());
		assertEquals("Player 1 : 0	-	Player 2 : 0\nPlayer 1 : 0	-	Player 2 : 15\nPlayer 1 : 0	-	Player 2 : 30\nPlayer 1 : 0	-	Player 2 : 40\n", game.showScores());
    }
    
    @Test
    public void testIsDeuce() throws GameException
    {
    	game.reset();
    	game.playerScores(2);
		assertEquals(15, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(30, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(40, game.getPlayer2().getScore().getValue());
		game.playerScores(1);
		assertEquals(15, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(30, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(40, game.getPlayer1().getScore().getValue());
		assertEquals(true,game.isDeuce());
    }
    
    @Test
    public void testHasAdvantage() throws GameException
    {
    	game.reset();
    	game.playerScores(2);
		assertEquals(15, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(30, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(40, game.getPlayer2().getScore().getValue());
		game.playerScores(1);
		assertEquals(15, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(30, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(40, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(41, game.getPlayer1().getScore().getValue());
		assertEquals(1,game.hasAdvantage());
    }
    
    @Test
    public void testHasWanAfterAdvantage() throws GameException
    {
    	game.reset();
    	game.playerScores(2);
		assertEquals(15, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(30, game.getPlayer2().getScore().getValue());
		game.playerScores(2);
		assertEquals(40, game.getPlayer2().getScore().getValue());
		game.playerScores(1);
		assertEquals(15, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(30, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(40, game.getPlayer1().getScore().getValue());
		game.playerScores(1);
		assertEquals(41, game.getPlayer1().getScore().getValue());
		assertEquals(0,game.getWinner());
		game.playerScores(1);
		assertEquals(1,game.getWinner());
    }
}
