package com.tuantai0625.chessgame.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
                addPiece(pane, row, col);
                if ((row % 2 == 0 && col % 2 == 1) || (row % 2 == 1 && col % 2 == 0)) {
                    pane.setStyle("-fx-background-color: #33939A");
                } else {
                    pane.setStyle("-fx-background-color: #98DCE1");
                }
                chessBoard.add(pane, col, row);
            }
        }
    }

    private void addPiece(Pane pane, int row, int col) {
        if (row == 0) {
            switch (col) {
                case 0:
                case 7:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/black_rook.png"));
                    break;
                case 1:
                case 6:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/black_knight.png"));
                    break;
                case 2:
                case 5:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/black_bishop.png"));
                    break;
                case 3:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/black_queen.png"));
                    break;
                case 4:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/black_king.png"));
                    break;
            }
        } else if (row == 1) {
            pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/black_pawn.png"));
        } else if (row == 6) {
            pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/white_pawn.png"));
        } else if (row == 7) {
            switch (col) {
                case 0:
                case 7:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/white_rook.png"));
                    break;
                case 1:
                case 6:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/white_knight.png"));
                    break;
                case 2:
                case 5:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/white_bishop.png"));
                    break;
                case 3:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/white_queen.png"));
                    break;
                case 4:
                    pane.getChildren().add(new ImageView("com/tuantai0625/chessgame/assets/pieces/white_king.png"));
                    break;
            }
        }
    }
}
