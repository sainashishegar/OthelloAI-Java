package ca.yorku.eecs3311.othello.model;

public abstract class OthelloController {

	protected Othello othello;
	protected Player player1, player2;

	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with a user at the console.
	 */
	public OthelloController() {
		this.othello = new Othello();
	}

	/**
	 * the main function of playing the game which this controller should control the progress
	 */
	public void play() {
		while (!othello.isGameOver()) {
			this.report();

			Move move=null;
			char whosTurn = othello.getWhosTurn();
			
			if(whosTurn==OthelloBoard.P1)move = player1.getMove();
			if(whosTurn==OthelloBoard.P2)move = player2.getMove();

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}

	/**
	 * prints the result of move to console
	 * @param whosTurn player who did the move
	 * @param move information of move
	 */
	protected void reportMove(char whosTurn, Move move) { }

	/**
	 * prints a full report of game board and the player who should make a move
	 */
	protected void report() { }

	/**
	 * prints a final report for scores of players
	 */
	protected void reportFinal() { }
}
