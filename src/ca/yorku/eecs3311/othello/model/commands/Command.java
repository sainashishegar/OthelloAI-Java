package ca.yorku.eecs3311.othello.model.commands;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloGUIController;

/**
 * The abstract class for a command that holds the previous version of the
 * game to enable undo functionality.
 *
 * @author Saina Shishegar
 */
public abstract class Command {
    protected Othello previousState;
    protected final OthelloGUIController controller;

    /**
     * constructor of Command
     * @param controller: the controller of othello game
     */
    public Command(OthelloGUIController controller){
        this.controller = controller;
    }

    /**
     * this method does the manin functionality of this command
     */
    abstract public void execute();

    /**
     * this method Undo the execute method effects
     */
    public void undo(){
        controller.setState(previousState);
    }
}
