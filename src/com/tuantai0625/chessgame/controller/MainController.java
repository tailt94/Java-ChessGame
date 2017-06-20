package com.tuantai0625.chessgame.controller;

import com.tuantai0625.chessgame.model.ChessBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private Label nameP2;

    @FXML
    private Label lastMoveP2;

    @FXML
    private Label nameP1;

    @FXML
    private Label lastMoveP1;

    @FXML
    private GridPane chessPane;

    @FXML
    private TextArea chatBox;

    @FXML
    private TextField textInput;

    @FXML
    private Button btnSend;

    private ChessBoard chessBoard = new ChessBoard();
    private String playerId;
    private String playerName;
    private String rivalName;

    public MainController(String playerId, String playerName, String rivalName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.rivalName = rivalName;
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
        if (playerId.equals("1")) {
            nameP1.setText(playerName);
            nameP2.setText(rivalName);
        } else {
            nameP1.setText(rivalName);
            nameP2.setText(playerName);
        }
    }
}
