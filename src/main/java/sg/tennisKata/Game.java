/**
 * 
 */
package sg.tennisKata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Badis
 *
 */

public class Game {
	private Player player1;
	private Player player2;
	private int winner;
	private List<int[]> scores;

	/**
	 * Constructor
	 * 
	 * @param name1 The name of the player 1
	 * @param name2 The name of the player 2
	 */
	public Game(String name1, String name2) {
		this.player1 = new Player(name1);
		this.player2 = new Player(name2);
		this.reset();
	}

	/**
	 * initialize or reset the game
	 */
	public Game reset() {
		this.player1.getScore().reset();
		this.player2.getScore().reset();
		this.winner = 0;
		this.scores = new ArrayList<int[]>();
		int[] startScore = { 0, 0 };
		scores.add(startScore);
		return this;
	}

	public boolean isDeuce() {
		if (player1.getScore().getValue() >= 40 && player1.getScore().getValue() == player2.getScore().getValue())
			return true;
		return false;
	}

	public int hasAdvantage() throws GameException {
		if (player1.getScore().getValue() > 40 && player1.getScore().getValue() == player2.getScore().increment())
			return 1;
		if (player2.getScore().getValue() > 40 && player2.getScore().getValue() == player1.getScore().increment())
			return 2;
		return 0;
	}

	/**
	 * playerScores tells us who scored in this current service
	 * 
	 * @param playerNumber The winner of the current service
	 * @throws GameException
	 */
	public void playerScores(int playerNumber) throws GameException {
		// we need to check if the game is not over yet
		if (this.winner == 1 || this.winner == 2)
			throw new GameException("Game is already Over !");

		// we have only two player 1 or 2
		if (playerNumber != 1 && playerNumber != 2)
			throw new GameException("the value of the winner of this service must be 1 or 2");

		if (playerNumber == 1) {// if the winner is the player 1
			if ((this.player1.getScore().getValue() == 40 && !isDeuce())
					|| (hasAdvantage() == 1)) {
				this.setWinner(1);
			} else {
				this.player1.getScore().increment();
			}
		} else if (playerNumber == 2) {// if the winner is the player 2
			if ((this.player2.getScore().getValue() == 40 && !isDeuce())
					|| (hasAdvantage() == 2)) {
				this.setWinner(2);
			} else {
				this.player2.getScore().increment();
			}
		}

		// update the score of the game
		int[] serviceScore = { this.player1.getScore().getValue(), this.player2.getScore().getValue() };
		this.scores.add(serviceScore);
	}

	/**
	 * shows the current score of the game
	 * 
	 * @return The current score of the game
	 */
	public String showScores() {
		StringBuilder gameScore = new StringBuilder();
		for (int[] serviceScore : scores) {
			gameScore.append(this.player1.getName() + " : " + serviceScore[0] + "\t-\t" + this.player2.getName() + " : "
					+ serviceScore[1] + "\n");
		}
		return gameScore.toString();
	}

	/**
	 * this to help us do the tests
	 * 
	 * @param winner The winner (1 or 2)
	 * @throws GameException
	 */
	public void setWinner(int winner) throws GameException {
		if (winner != 1 && winner != 2)
			throw new GameException("the value of winner must be 1 or 2");

		this.winner = winner;
	}

	/**
	 * @return The winner of the game (if 0, there is no winner yet)
	 */
	public int getWinner() {
		return this.winner;
	}

	/**
	 * @return the first player
	 */
	public Player getPlayer1() {
		return this.player1;
	}

	/**
	 * @return the second player
	 */
	public Player getPlayer2() {
		return this.player2;
	}
}
