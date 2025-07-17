package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * The view of the label containing the count of each player's pieces.
 *
 * @author Saina Shishegar
 */
public class PlayerCountLabel extends Label implements Observer {
    /**
     * Constructor of this view
     * @param fontSize: font of text of this label
     */
    public PlayerCountLabel(int fontSize) {
        setFont(new Font(fontSize));
        setPadding(new Insets(0,0,8,0));
    }

    @Override
    public void update(Observable o) {
        Othello othello = (Othello) o;
        String p1 = String.format("%s count: %d", OthelloApplication.playerColorName(OthelloBoard.P1), othello.getCount(OthelloBoard.P1));
        String p2 = String.format("%s count: %d", OthelloApplication.playerColorName(OthelloBoard.P2), othello.getCount(OthelloBoard.P2));
        setText(p1 + "    " + p2);
    }
}
