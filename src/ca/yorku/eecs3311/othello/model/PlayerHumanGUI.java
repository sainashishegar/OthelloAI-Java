package ca.yorku.eecs3311.othello.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class implements a Human player which wits
 * for player in GUI to press a key showing his next move
 *
 * @author Saina Shishegar
 */
public class PlayerHumanGUI extends Player {
    Move move = null;

    public PlayerHumanGUI(Othello othello, char player) {
        super(othello, player);
    }

    public void setGUIMove(Move move) {
        this.move = move;
    }

    public Move getMove() {
        Move res = this.move;
        this.move = null;
        return res;
    }
}


