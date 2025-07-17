package ca.yorku.eecs3311.othello.model.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds history of commands and provides the
 * functionalities for Undo and Redo commands in history
 *
 * @author Saina Shishegar
 */
public class CommandHistory {
    private final List<Command> history;
    int i = 0;

    /**
     * default constructor of CommandHistory
     */
    public CommandHistory() {
        history = new ArrayList<>();
    }

    /**
     * this method executes the given command and record it in a command history list
     * @param command: the command to be executed
     */
    public void execute(Command command) {
        if (history.size() > i + 1) {
            history.subList(i + 1, history.size()).clear();
        }

        command.execute();
        history.add(command);
        i = history.size() - 1;
    }

    /**
     * undo the last executed command, If you run this function
     * multiple times, it will undo an older command each time.
     */
    public void undo() {
        if (i >= 0) {
            Command c = history.get(i);
            c.undo();
            i--;
        }
    }

    /**
     * just goes forward within history (reverse of Undo)
     */
    public void redo() {
        if (i < history.size()-1) {
            i++;
            Command c = history.get(i);
            c.execute();
        }
    }
}
