package com.tuantai0625.chessgame.controller;

import com.tuantai0625.chessgame.Main;
import com.tuantai0625.chessgame.model.ChessBoard;
import com.tuantai0625.chessgame.model.Move;
import com.tuantai0625.chessgame.network.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PvpModeController implements Initializable, Client.DataReceiveListener, ChessBoard.OnPieceMoveListener{
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

    private Client client;
    private ChessBoard chessBoard;
    private String playerId;
    private String playerName;
    private String rivalName;

    public PvpModeController(Client connection, String playerId, String playerName, String rivalName) {
        this.client = connection;
        this.playerId = playerId;
        this.playerName = playerName;
        this.rivalName = rivalName;

        client.setOnDataReceiveListener(this);
        client.startDataThread();

        chessBoard = new ChessBoard(playerId);
        chessBoard.setOnPieceMoveListener(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStageTitle("Chess Game - Player: " + playerName);
        drawChessPane();
        displayPlayerName();

        if (playerId.equals("2"))   chessPane.setDisable(true);
    }

    @Override
    public void onChatReceive(String message) {
        chatBox.appendText(message + "\n");
    }

    @Override
    public void onMoveReceive(String move) {
        chessPane.setDisable(false);
        Move m = new Move(move);
        if (playerId.equals("1")) {
            lastMoveP2.setText(m.toBoardMove());
        } else if (playerId.equals("2")) {
            lastMoveP1.setText(m.toBoardMove());
        }
        chessBoard.updateBoard(m);
    }

    @Override
    public void onPieceMove(Move move) {
        chessPane.setDisable(true);
        client.sendMessage(playerId + "_" + move.toString());
        if (playerId.equals("1")) {
            lastMoveP1.setText(move.toBoardMove());
        } else if (playerId.equals("2")) {
            lastMoveP2.setText(move.toBoardMove());
        }
    }

    @FXML
    void onButtonSendClick(ActionEvent event) {
        client.sendMessage(playerName + ": " + textInput.getText());
        textInput.clear();
    }

    @FXML
    void onTextInputPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            client.sendMessage(playerName + ": " + textInput.getText());
            textInput.clear();
        }
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

    private void setStageTitle(String title) {
        Main.getStage().setTitle(title);
    }
}
