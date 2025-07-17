package ca.yorku.eecs3311.othello.model.commands;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.OthelloGUIController;

/**
 * A command for move
 * @author Saina Shishegar
 */
public class MoveCommand extends Command{
    private Move move;

    /**
     * Constructor for MoveCommand
     * @param controller: the controller of othello game
     * @param move: the move to be executed
     */
    public MoveCommand(OthelloGUIController controller, Move move) {
        super(controller);
        this.move = move;
    }

    @Override
    public void execute() {
        previousState = controller.getState();
        controller.doMove(move);
    }
}
