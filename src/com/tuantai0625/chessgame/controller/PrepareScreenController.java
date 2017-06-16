package com.tuantai0625.chessgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lionheart on 16-Jun-17.
 */
public class PrepareScreenController implements Initializable {

    @FXML
    private StackPane prepareScreenRootPane;

    @FXML
    private Button btnStart;

    @FXML
    private RadioButton radioInternet;

    @FXML
    private RadioButton radioLan;

    @FXML
    private TextField textUserName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onButtonStartClick(ActionEvent event) {
        
    }
}
