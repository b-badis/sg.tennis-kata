/**
 * 
 */
package sg.tennis_kata;

import java.util.stream.IntStream;

/**
 * @author Badis
 *
 */
public class Score {
private int value;
	
	/**
	 * Constructor
	 */
	public Score() {
		reset();
	}
	
	
	/**
	 * increment the score
	 * @throws GameException 
	 */
	public int increment() throws GameException {		
		int[] expectedValues = {0, 15, 30, 40};
		if (this.value<=40&&!IntStream.of(expectedValues).anyMatch(x -> x == this.value)) {
			throw new GameException("score value not supported");
		}
    	if (this.value == 0 || this.value == 15) {
    		this.value += 15;
    	} else if (this.value == 30) {
    		this.value = 40;
    	}else {
    		this.value++;
    	}
    	return this.value;
	}

	/**
	 *	@return the score value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 *	reset the scor value
	 */
	public void reset() {
		this.value=0;
	}

}
