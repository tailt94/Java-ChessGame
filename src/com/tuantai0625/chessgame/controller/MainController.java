package com.tuantai0625.chessgame.controller;

import com.tuantai0625.chessgame.model.ChessBoard;
import com.tuantai0625.chessgame.model.Tile;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private GridPane chessPane;

    @FXML
    private TextField textInput;

    @FXML
    private Label namePlayer2;

    @FXML
    private Label namePlayer1;

    @FXML
    private Button btnSend;

    @FXML
    private TextArea chatBox;

    private ChessBoard chessBoard = new ChessBoard();
    private String name;

    public MainController(String name) {
        this.name = name;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawChessPane();
        displayPlayerName();
    }

    private void drawChessPane() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                chessPane.add(chessBoard.getTile(row, col).getPane(), col, row);
            }
        }
    }

    private void displayPlayerName() {
        namePlayer1.setText(name);
    }
}
