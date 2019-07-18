/**
 * 
 */
package sg.tennisKata;

/**
 * @author Badis
 *
 */
public class Player {
	private String name;
	private Score score;

	/**
	 * Constructor
	 * @param name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.score = new Score();
	}

	/**
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the current score of the player
	 */
	public Score getScore() {
		return this.score;
	}
}
