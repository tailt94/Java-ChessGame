package com.tuantai0625.chessgame.controller;

import com.tuantai0625.chessgame.Main;
import com.tuantai0625.chessgame.ai.AI;
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

/**
 * Created by Lionheart on 22-Jun-17.
 */
public class AiModeController implements Initializable, ChessBoard.OnPieceMoveListener {
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

    private ChessBoard chessBoard;
    private String playerName;
    private String rivalName;
    private AI ai = null;

    public AiModeController(AI ai, String playerName, String rivalName) {
        this.playerName = playerName;
        this.rivalName = rivalName;
        this.ai = ai;
        chessBoard = new ChessBoard("1");
        chessBoard.setOnPieceMoveListener(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStageTitle("Chess Game - Player: " + playerName);
        disablePvpComponent();
        drawChessPane();
        displayPlayerName();
    }

    @Override
    public void onPieceMove(Move move) {
        lastMoveP1.setText(move.toBoardMove());
        lastMoveP2.setText(ai.makeMove(chessBoard));
    }

    @FXML
    void onButtonSendClick(ActionEvent event) {
    }

    @FXML
    void onTextInputPress(KeyEvent event) {
    }

    private void drawChessPane() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                chessPane.add(chessBoard.getTile(row, col).getPane(), col, row);
            }
        }
    }

    private void displayPlayerName() {
        nameP1.setText(playerName);
        nameP2.setText(rivalName);
    }

    private void disablePvpComponent() {
        textInput.setDisable(true);
        btnSend.setDisable(true);
        chatBox.setDisable(true);
    }

    private void setStageTitle(String title) {
        Main.getStage().setTitle(title);
    }
}
