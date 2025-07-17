package ca.yorku.eecs3311.othello.model.commands;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloGUIController;

/**
 * A command for restarting the game
 * @author Saina Shishegar
 */
public class RestartCommand extends Command{

    /**
     * Constructor of RestartCommand
     * @param controller: the controller of othello game
     */
    public RestartCommand(OthelloGUIController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        previousState = controller.getState();
        controller.setState(new Othello());
    }
}
