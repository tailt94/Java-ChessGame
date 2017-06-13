package com.tuantai0625.chessgame.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private TextField textInput;

    @FXML
    private GridPane chessBoard;

    @FXML
    private Button btnSend;

    @FXML
    private TextArea chatBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawChessBoard();
    }

    private void drawChessBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Pane pane = new Pane();
                if ((row % 2 == 0 && col % 2 == 1) || (row % 2 == 1 && col % 2 == 0)) {
                    pane.setStyle("-fx-background-color: #33939A");
                } else {
                    pane.setStyle("-fx-background-color: #98DCE1");
                }
                chessBoard.add(pane, col, row);
            }
        }
    }
}
