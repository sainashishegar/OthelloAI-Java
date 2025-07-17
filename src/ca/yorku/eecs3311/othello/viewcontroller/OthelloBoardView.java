package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.othello.model.OthelloGUIController;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;

/**
 * The view of board in the game GUI
 *
 * @author Saina Shishegar
 */
public class OthelloBoardView extends GridPane implements Observer {
    private final Image p1PieceImage, p2PieceImage;
    private final int size;
    private OthelloGUIController controller;

    /**
     * constructor of OthelloBoardView
     *
     * @param size:       defines the size of many things in view
     * @param controller: controller of this view
     */
    public OthelloBoardView(int size, OthelloGUIController controller) {
        this.size = size;
        this.controller = controller;
        this.p1PieceImage = new Image("ca/yorku/eecs3311/resources/white.png", size, size, true, true);
        this.p2PieceImage = new Image("ca/yorku/eecs3311/resources/black.png", size, size, true, true);

        setPadding(new Insets(0, 0, 8, 8));
    }

    @Override
    public void update(Observable o) {
        Othello othello = (Othello) o;

        List<Move> availableMoves = othello.getPossibleMoves(othello.getWhosTurn());
        getChildren().clear();
        for (int i = 0; i < Othello.DIMENSION; i++) {
            for (int j = 0; j < Othello.DIMENSION; j++) {
                char token = othello.getToken(i, j);
                Node node;
                if (token == OthelloBoard.P1) {
                    node = getPiece(p1PieceImage);
                } else if (token == OthelloBoard.P2) {
                    node = getPiece(p2PieceImage);
                } else {
                    Move availableCell = null;
                    for (Move m : availableMoves) {
                        if (i == m.getRow() && j == m.getCol()) {
                            availableCell = m;
                            break;
                        }
                    }
                    node = getEmptyCell(availableCell);
                }
                add(node, j, i);
                setHalignment(node, HPos.CENTER);
                setValignment(node, VPos.CENTER);
            }
        }
    }

    /**
     * @param img: image of piece
     * @return a view of a cell containing a piece
     */
    private Node getPiece(Image img) {
        ImageView imgView = new ImageView(img);
        StackPane p = new StackPane(imgView);
        p.setAlignment(Pos.CENTER);
        p.setPadding(new Insets(this.size / 10.0));
        p.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        return p;
    }

    /**
     * this method return an empty cell view, but if availableCell is not null
     * this means that the cell should hold something (a small dot) as hint.
     * if availableCell is not null, this cell is clickable and by pressing it
     * the controller will be notified through OthelloGUIController::onClickCell.
     *
     * @param availableCell: a move object
     * @return a view of a cell containing a piece
     */
    private Node getEmptyCell(Move availableCell) {
        Region empty = new Region();
        empty.setMinSize(this.size, this.size);
        empty.setClip(new Rectangle(0, 0, this.size, this.size));
        StackPane p = new StackPane(empty);
        p.setPadding(new Insets(this.size / 10.0));

        if (availableCell != null) {
            empty.setOnMouseClicked((__) -> this.controller.onClickCell(availableCell));
            Circle hint = new Circle(this.size / 20.0, Color.DARKGRAY);
            p.getChildren().add(hint);
        }
        p.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        return p;
    }

}
