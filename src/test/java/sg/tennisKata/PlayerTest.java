/**
 * 
 */
package sg.tennisKata;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import sg.tennisKata.Player;

/**
 * @author Badis
 *
 */
public class PlayerTest {
	static Player player = new Player("Player 1");

    @Test
    public void getNameTest() {
        assertEquals("Player 1", player.getName());        
    }

    @Test
    public void getScoreTest() {
        assertEquals(0, player.getScore().getValue());        
    }
    
}
