package ca.yorku.eecs3311.othello.model;
/**
 * This controller uses the Model classes to allow the Human player P1 to play
 * the computer P2. The computer, P2 uses a greedy strategy. 
 * 
 * @author student
 *
 */
public class OthelloControllerHumanVSGreedy extends OthelloControllerVerbose {

	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with one user at the console and one greedy player.
	 */
	public OthelloControllerHumanVSGreedy() {
		super();
		this.player1 = new PlayerHumanConsole(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
	}

	/**
	 * Run main to play a Human (P1) against the computer P2. 
	 * The computer uses a greedy strategy, that is, it picks the first
	 * move which maximizes its number of token on the board.
	 * The output should be almost identical to that of OthelloControllerHumanVSHuman.
	 * @param args
	 */
	public static void main(String[] args) {
		OthelloControllerHumanVSGreedy oc = new OthelloControllerHumanVSGreedy();
		oc.play();
	}
}
