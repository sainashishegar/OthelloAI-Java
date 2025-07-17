package ca.yorku.eecs3311.othello.model;

/**
 * This class contains the row and column of a move
 *
 * @author student
 *
 */
public class Move {
	private int row, col;

	/**
	 * Construct a Move object
	 * @param row the row of token in board
	 * @param col the column of token in board
	 */
	public Move(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * getter method for row
	 * @return the row of this move
	 */
	public int getRow() {
		return row;
	}

	/**
	 * getter method for column
	 * @return the column of this move
	 */
	public int getCol() {
		return col;
	}

	/**
	 * casts this object to a single string
	 * @return a String representation of this move
	 */
	public String toString() {
		return "(" + this.row + "," + this.col + ")";
	}
}
