package ca.yorku.eecs3311.othello.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class implements a Human player which asks the user through console to
 * determine the next move
 *
 * @author arnold
 *
 */
public class PlayerHumanConsole extends Player {
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin= new BufferedReader(new InputStreamReader(System.in));

	/**
	 * constructs a human Player
	 * @param othello the othello game
	 * @param player the representor of player
	 */
	public PlayerHumanConsole(Othello othello, char player) {
		super(othello, player);
	}

	public Move getMove() {
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}

	private int getMove(String message) {
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHumanConsole.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}


