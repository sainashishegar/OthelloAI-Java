package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * The view of the label containing winner's name
 * @author Saina Shishegar
 */
public class WinnerLabel extends Label implements Observer {
    int fontSize;

    /**
     * Constructor of this view
     * @param fontSize: font of text of this label
     */
    public WinnerLabel(int fontSize) {
        this.fontSize = fontSize;

        setPadding(new Insets(0,0,8,0));
    }

    @Override
    public void update(Observable o) {
        Othello othello = (Othello) o;
        char winner = othello.getWinner();
        if (winner != OthelloBoard.EMPTY) {
            String colorName = OthelloApplication.playerColorName(winner);
            super.setFont(new Font(fontSize));
            setText("!!> " + colorName + " Player Won <!!");
        }else{
            super.setFont(new Font(0));
        }
    }
}
