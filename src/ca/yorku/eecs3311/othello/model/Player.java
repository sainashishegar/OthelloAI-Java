package ca.yorku.eecs3311.othello.model;

/**
 * An abstract class for a player
 *
 * @author Saina Shishegar
 */
public abstract class Player {
    protected Othello othello;
    protected char player;

    /**
     * constructs a Player
     *
     * @param othello the othello game
     * @param player  the representor of player
     */
    public Player(Othello othello, char player) {
        this.othello = othello;
        this.player = player;
    }

    /**
     * @return the player char representor
     */
    public char getPlayer() {
        return this.player;
    }

    /**
     * @return the chosen move by this player
     */
    public abstract Move getMove();
}
