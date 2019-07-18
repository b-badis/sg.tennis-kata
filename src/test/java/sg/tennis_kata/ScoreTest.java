/**
 * 
 */
package sg.tennis_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Badis
 *
 */
public class ScoreTest {
	static Score score = new Score();

	@Before
    public void scoreInit() {
    	score.reset();
    }

	@Test
	public void incrementTest() {
		try {
			score.increment();
			assertEquals(15, score.getValue());
			score.increment();
			assertEquals(30, score.getValue());
			score.increment();
			assertEquals(40, score.getValue());
		} catch (GameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
