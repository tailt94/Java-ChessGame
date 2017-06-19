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
            namePlayer1.setText(playerName);
            namePlayer2.setText(rivalName);
        } else {
            namePlayer1.setText(rivalName);
            namePlayer2.setText(playerName);
        }
    }
}
