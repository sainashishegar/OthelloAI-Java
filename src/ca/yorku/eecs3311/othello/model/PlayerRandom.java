package ca.yorku.eecs3311.othello.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayerRandom makes a move by first determining all possible moves that this
 * player can make, putting them in an ArrayList, and then randomly choosing one
 * of them.
 * 
 * @author student
 *
 */
public class PlayerRandom extends Player {
	private Random rand = new Random();

	/**
	 * constructs a random Player
	 * @param othello the othello game
	 * @param player the representor of player
	 */
	public PlayerRandom(Othello othello, char player) {
		super(othello, player);
	}
	
	@Override
	public Move getMove() {
		ArrayList<Move> moves = new ArrayList<Move>();
		for(int row=0;row<Othello.DIMENSION;row++) {
			for(int col=0;col<Othello.DIMENSION;col++) {
				Othello othelloCopy = othello.copy();
				if(othelloCopy.move(row, col))moves.add(new Move(row,col));
			}
		}
		return moves.get(this.rand.nextInt(moves.size()));
	}
}

