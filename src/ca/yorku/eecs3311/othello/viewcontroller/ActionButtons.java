package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.OthelloGUIController;
import ca.yorku.eecs3311.othello.model.commands.RestartCommand;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Paths;

/**
 * The view of available actions in the game GUI
 *
 * @author Saina Shishegar
 */
public class ActionButtons extends VBox {
    ComboBox<String> opponentType;
    Button restartBtn;
    Button undoBtn;
    Button redoBtn;
    Button saveStateBtn;
    Button loadStateBtn;

    /**
     * Constructor of ActionButtons
     * @param controller: the controller of this view
     */
    public ActionButtons(OthelloGUIController controller){
        opponentType = new ComboBox<>(FXCollections.observableArrayList("Human Player", "Random player", "Greedy Player"));
        opponentType.setOnAction((__) -> controller.setPlayer2(opponentType.getValue()));
        opponentType.setValue("Human Player");
        opponentType.setMinWidth(200);

        restartBtn = new Button("Restart");
        restartBtn.setMinWidth(200);
        restartBtn.setOnAction((__) -> controller.command(new RestartCommand(controller)));

        undoBtn = new Button("Undo");
        undoBtn.setMinWidth(200);
        undoBtn.setOnAction((__) -> controller.undo());

        redoBtn = new Button("Redo");
        redoBtn.setMinWidth(200);
        redoBtn.setOnAction((__) -> controller.redo());

        saveStateBtn = new Button("Save game");
        saveStateBtn.setMinWidth(200);
        saveStateBtn.setOnAction((__) -> controller.saveState(getSaveFilePath()));

        loadStateBtn = new Button("Load game");
        loadStateBtn.setMinWidth(200);
        loadStateBtn.setOnAction((__) -> controller.loadState(getLoadFilePath()));

        super.getChildren().addAll(opponentType, restartBtn, undoBtn, redoBtn, saveStateBtn, loadStateBtn);
        setSpacing(10);
    }

    /**
     * @return the path of file chosen by user to load the state of a game
     */
    public File getLoadFilePath() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load game file path");
        fileChooser.setInitialDirectory(Paths.get("saves/").toAbsolutePath().toFile());
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
                new FileChooser.ExtensionFilter("Serialized Java Object", "*.sjo")
        );
        return fileChooser.showOpenDialog(this.getScene().getWindow());
    }

    /**
     * @return the path of a directory chosen by user to save the state of game
     */
    public File getSaveFilePath() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Save game file path");
        directoryChooser.setInitialDirectory(Paths.get("saves/").toAbsolutePath().toFile());
        return  directoryChooser.showDialog(this.getScene().getWindow());
    }


}
