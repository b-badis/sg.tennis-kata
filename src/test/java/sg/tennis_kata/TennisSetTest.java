/**
 * 
 */
package sg.tennis_kata;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * @author b.barbouch
 *
 */
public class TennisSetTest {
	static TennisSet tennisSet=new TennisSet();
	
	
	@Test
	public void testSetScor()
	{
		tennisSet.setFinalScors(new int[] {1,2});
		assertArrayEquals(new int[] {1, 2},tennisSet.getFinalScors());
	}
	
	@Test
	public void testCheckGameWinner()
	{
		tennisSet.setFinalScors(new int[] {6,2});
		assertEquals(1,tennisSet.checkGameWinner());
	}
	
	@Test
	public void testCheckGameWinner7()
	{
		tennisSet.setFinalScors(new int[] {7,6});
		assertEquals(1,tennisSet.checkGameWinner());
	}
	
	@Test
	public void testCheckGamePending()
	{
		tennisSet.setFinalScors(new int[] {6,5});
		assertEquals(0,tennisSet.checkGameWinner());
	}
	
	@Test
	public void testPlayerWinGameAlreadyFinished()
	{
		tennisSet.setFinalScors(new int[] {6,2});
		assertThrows(GameException.class,() ->tennisSet.playerWinGame(1));
	}
	
	@Test
	public void testPlayerWinGameWrongNumber()
	{
		tennisSet.setFinalScors(new int[] {3,2});
		assertThrows(GameException.class,() ->tennisSet.playerWinGame(3));
	}
	
	
	
}
