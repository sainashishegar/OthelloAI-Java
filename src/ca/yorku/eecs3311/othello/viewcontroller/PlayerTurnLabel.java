package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * The view of the label containing turn
 * @author Saina Shishegar
 */
public class PlayerTurnLabel extends Label implements Observer {
    /**
     * Constructor of this view
     * @param fontSize: font of text of this label
     */
    public PlayerTurnLabel(int fontSize){
        setFont(new Font(fontSize));
        setPadding(new Insets(0,0,8,0));
    }

    @Override
    public void update(Observable o) {
        Othello othello = (Othello)o;
        char turn = othello.getWhosTurn();
        if(turn == OthelloBoard.EMPTY){
            setText("restart or load new game...");
        }else {
            String colorName = OthelloApplication.playerColorName(turn);
            setText("Turn: [" + colorName + " player]");
        }
    }
}
