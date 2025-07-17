package ca.yorku.eecs3311.othello.model;

import ca.yorku.eecs3311.othello.model.commands.Command;
import ca.yorku.eecs3311.othello.model.commands.CommandHistory;
import ca.yorku.eecs3311.othello.model.commands.MoveCommand;
import ca.yorku.eecs3311.util.Observer;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;


/**
 * The Controller of the game and GUI
 *
 * @author Saina Shishegar
 */
public class OthelloGUIController extends OthelloController {
    CommandHistory history;

    /**
     * Constructor of controller
     * @param othello: the game model that should be controlled
     */
    public OthelloGUIController(Othello othello) {
        this.history = new CommandHistory();
        super.othello = othello;
        super.player1 = new PlayerHumanGUI(this.othello, OthelloBoard.P1);
        super.player2 = new PlayerHumanGUI(this.othello, OthelloBoard.P2);
    }

    /**
     * this method attach several observers to othello game model at once
     * @param observers: list of observers
     */
    public void attachToOthello(Observer... observers) {
        for (Observer o : observers)
            othello.attach(o);
    }

    /**
     * this method manually notifies all observers of othello object
     */
    public void notifyOthelloObservers() {
        othello.notifyObservers();
    }

    /**
     * this method set a new type of player to the player 2
     * note that the player 1 is always a GUI human player
     * @param playerType: string containing name of new type
     */
    public void setPlayer2(String playerType) {
        switch (playerType) {
            case "Greedy Player":
                super.player2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
                break;
            case "Random player":
                super.player2 = new PlayerRandom(this.othello, OthelloBoard.P2);
                break;
            case "Human Player":
                super.player2 = new PlayerHumanGUI(this.othello, OthelloBoard.P2);
                break;
            default:
                throw new IllegalArgumentException();
        }
        play();
    }

    @Override
    public void play() {
        while (!othello.isGameOver()) {
            Move move = null;
            char whosTurn = othello.getWhosTurn();

            if (whosTurn == OthelloBoard.P1) move = super.player1.getMove();
            if (whosTurn == OthelloBoard.P2) move = super.player2.getMove();

            if (move != null)
                command(new MoveCommand(this, move));
            else
                break;
        }
    }

    /**
     * this method executes a move
     * @param move: the move holding position of cell
     */
    public void doMove(Move move) {
        othello.move(move.getRow(), move.getCol());
    }

    /**
     * this method is a handler for clicking on a cell in the game GUI
     * @param moveCell: the move object containing position of cell
     */
    public void onClickCell(Move moveCell) {
        char whosTurn = othello.getWhosTurn();
        if (whosTurn == OthelloBoard.P1 && super.player1 instanceof PlayerHumanGUI)
            ((PlayerHumanGUI) super.player1).setGUIMove(moveCell);

        if (whosTurn == OthelloBoard.P2 && super.player2 instanceof PlayerHumanGUI)
            ((PlayerHumanGUI) super.player2).setGUIMove(moveCell);

        play();
    }

    /**
     * this method accepts a new command for controller
     * @param command: the command to be executed
     */
    public void command(Command command) {
        this.history.execute(command);
    }

    /**
     * Undo the last done command
     */
    public void undo() {
        this.history.undo();
    }

    /**
     * Redo the last undone command
     */
    public void redo() {
        this.history.redo();
    }

    /**
     * set the state of the game to the state of the given Othello object
     * @param state: Othello object (desired state)
     */
    public void setState(Othello state) {
        super.othello.load(state);
        super.othello.notifyObservers();
    }

    /**
     * @return a copy of current state (othello model)
     */
    public Othello getState() {
        return super.othello.copy();
    }

    /**
     * this method saves the othello object to a file by the use
     * of serializability of this class.
     * @param file: the file containing the path of destination directory
     */
    public void saveState(File file) {
        if (file == null || !file.isDirectory())
            return;

        String path = file.getPath();
        file = new File(path + "/othello.sjo");

        try {
            ObjectOutputStream write = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            write.writeObject(getState());
        } catch (IOException e) {
            System.err.println("Unable to save to " + path);
        }
    }

    /**
     * this method loads the othello model (state of the game) from the give path
     * @param file: path to the file
     */
    public void loadState(File file) {
        if (file == null || file.isDirectory())
            return;

        try {
            ObjectInputStream inFile = new ObjectInputStream(Files.newInputStream(file.toPath()));
            Othello state = (Othello) inFile.readObject();
            setState(state);
        } catch (Exception e) {
            System.err.println("Unable to load from " + file.getPath());
        }
    }
}
