package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.OthelloGUIController;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 * The view of whole game in GUI
 *
 * @author Saina Shishegar
 */
public class OthelloGUI extends GridPane {
    WinnerLabel winnerLabel;
    PlayerTurnLabel turnLabel;
    PlayerCountLabel playersCount;
    OthelloBoardView boardView;
    OthelloGUIController controller;
    ActionButtons actionButtons;

    int baseFontSize = 20;
    int baseShapeSize = 50;

    /**
     * constructor of this view
     * @param controller: controller of this view
     */
    public OthelloGUI(OthelloGUIController controller) {
        this.controller = controller;

        winnerLabel = new WinnerLabel(baseFontSize * 2);
        super.add(winnerLabel, 1, 0);

        playersCount = new PlayerCountLabel(baseFontSize);
        super.add(playersCount, 1, 1);

        turnLabel = new PlayerTurnLabel(baseFontSize);
        super.add(turnLabel, 1, 2);

        actionButtons = new ActionButtons(controller);
        super.add(actionButtons, 0, 3);

        boardView = new OthelloBoardView(baseShapeSize, this.controller);
        super.add(boardView, 1, 3);

        controller.attachToOthello(winnerLabel, playersCount, turnLabel, boardView);
        setPadding(new Insets(8));

        this.controller.notifyOthelloObservers();
    }
}
