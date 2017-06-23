package com.tuantai0625.chessgame.controller;

import com.tuantai0625.chessgame.Main;
import com.tuantai0625.chessgame.ai.AI;
import com.tuantai0625.chessgame.ai.MinMaxGenerator;
import com.tuantai0625.chessgame.ai.RandomGenerator;
import com.tuantai0625.chessgame.network.Client;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lionheart on 16-Jun-17.
 */
public class PrepareScreenController implements Initializable {

    @FXML
    private TextField textUserName;

    @FXML
    private RadioButton radioPvp;

    @FXML
    private RadioButton radioAiEasy;

    @FXML
    private RadioButton radioAiHard;

    @FXML
    private TextField textIp;

    @FXML
    private Button btnStart;

    private ToggleGroup gameMode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupRadioGroup();
    }

    @FXML
    void onButtonStartClick(ActionEvent event) throws IOException {
        if (isValidToStart()) {
            if (getMode() == 0) { //PvP
                Client client = new Client(textIp.getText());
                client.sendMessage(textUserName.getText());
                String[] info = client.receiveMessage().split("_");
                startPvpMode(client, info[0], info[1], info[2]);
            } else if (getMode() == 1) { //AI - Dễ
                startAiMode(new RandomGenerator(), textUserName.getText());
            } else { //AI - Khó
                startAiMode(new MinMaxGenerator(), textUserName.getText());
            }
        }
    }

    @FXML
    void onTextIpPress(KeyEvent event) {
        if (isValidToStart()) {
            if (event.getCode() == KeyCode.ENTER) {
                Client client = new Client(textIp.getText());
                client.sendMessage(textUserName.getText());
                String[] info = client.receiveMessage().split("_");
                startPvpMode(client, info[0], info[1], info[2]);
            }
        }
    }

    private void setupRadioGroup() {
        gameMode = new ToggleGroup();
        radioPvp.setToggleGroup(gameMode);
        radioPvp.setSelected(true);
        radioAiEasy.setToggleGroup(gameMode);
        radioAiHard.setToggleGroup(gameMode);

        gameMode.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (gameMode.getSelectedToggle() == radioPvp) {
                    textIp.setDisable(false);
                } else if (gameMode.getSelectedToggle() == radioAiEasy) {
                    textIp.setDisable(true);
                } else if (gameMode.getSelectedToggle() == radioAiHard) {
                    textIp.setDisable(true);
                }
            }
        });
    }

    private boolean isValidToStart() {
        if (!textUserName.getText().equals("")) {
            if (gameMode.getSelectedToggle() == radioPvp) {
                return (!textIp.getText().equals(""));
            }
            return true;
        }
        return false;
    }

    /**
     *
     * @return 0 - Chế độ PvP;
     * 1 - Chế độ AI Dễ;
     * 2 - Chế độ AI Khó;
     */
    private int getMode() {
        if (gameMode.getSelectedToggle() == radioPvp) {
            return 0;
        }
        if (gameMode.getSelectedToggle() == radioAiEasy) {
            return 1;
        }
        return 2;
    }

    private void startPvpMode(Client connection, String playerId, String playerName, String rivalName) {
        try {
            PvpModeController pvpModeController = new PvpModeController(connection, playerId, playerName, rivalName);
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/main_screen.fxml"));
            Stage stage = (Stage) btnStart.getScene().getWindow();
            loader.setController(pvpModeController);
            Parent root = loader.load();
            stage.getScene().setRoot(root);
            stage.show();
            stage.sizeToScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startAiMode(AI ai, String playerName) {
        try {
            AiModeController aiModeController = new AiModeController(ai, playerName, "AI");
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/main_screen.fxml"));
            Stage stage = (Stage) btnStart.getScene().getWindow();
            loader.setController(aiModeController);
            Parent root = loader.load();
            stage.getScene().setRoot(root);
            stage.show();
            stage.sizeToScene();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
