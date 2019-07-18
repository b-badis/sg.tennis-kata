package sg.tennisKata;

import java.util.HashMap;
import java.util.Map;

public class TennisSet {

	private Map<Integer, Game> games;
	private int[] finalScors;
	private int winner;
	private boolean tieBreak=false;

	/**
	 * @return the tieBreak
	 */
	public boolean isTieBreak() {
		return tieBreak;
	}

	/**
	 * @param tieBreak the tieBreak to set
	 */
	public void setTieBreak(boolean tieBreak) {
		this.tieBreak = tieBreak;
	}

	/**
	 * 
	 */
	public TennisSet() {
		this.reset();
	}

	public void reset() {
		this.games = new HashMap<Integer, Game>();
		this.finalScors = new int[] { 0, 0 };
		this.winner = 0;
		this.tieBreak=false;
	}

	/**
	 * @param games
	 * @param winner
	 */
	public TennisSet(Map<Integer, Game> games, int[] finalScors, int winner) {
		this.games = games;
		this.finalScors = finalScors;
		this.winner = winner;
		this.reset();
	}

	/**
	 * @return the games
	 */
	public Map<Integer, Game> getGames() {
		return games;
	}

	/**
	 * @param games the games to set
	 */
	public void setGames(Map<Integer, Game> games) {
		this.games = games;
	}

	/**
	 * @return the winner
	 */
	public int getWinner() {
		return winner;
	}

	/**
	 * @param winner the winner to set
	 */
	public void setWinner(int winner) {
		this.winner = winner;
	}

	/**
	 * @return the finalScors
	 */
	public int[] getFinalScors() {
		return finalScors;
	}

	/**
	 * @param finalScors the finalScors to set
	 */
	public void setFinalScors(int[] finalScors) {
		this.finalScors = finalScors;
		this.winner=checkGameWinner();
	}

	
	public int checkGameWinner() {
		if (this.finalScors.length == 2) {
			int p1 = this.finalScors[0];
			int p2 = this.finalScors[1];
			if(p1>=6&&p1-p2>=2|| (p1 == 7 &&!tieBreak) )
				return 1;
			if(p2>=6&&p2-p1>=2|| (p2 == 7 &&!tieBreak))
				return 2;	
			if(p2==p1&& p1==6) {
				tieBreak=true;
				return 0;
			}
		}else {
			return -1;
		}
		return 0;
	}

	public void playerWinGame(int playerNumber) throws GameException {
		// we need to check if the set is not over yet
		if (this.winner == 1 || this.winner == 2)
			throw new GameException("Set is already Over !");

		// we have only two player 1 or 2
		if (playerNumber != 1 && playerNumber != 2)
			throw new GameException("the value of the winner of this service must be 1 or 2");

		if (playerNumber == 1) {// if the winner is the player 1
			this.finalScors[0]++;
		} else if (playerNumber == 2) {// if the winner is the player 2
			this.finalScors[1]++;
		}
		int localWinner =checkGameWinner();
		if(localWinner!=0&&localWinner!=-1)
			this.winner=localWinner;

	}

}
