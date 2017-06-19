package com.tuantai0625.chessgame.controller;

import com.tuantai0625.chessgame.Main;
import com.tuantai0625.chessgame.network.Client;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupRadioGroup();
    }

    @FXML
    void onButtonStartClick(ActionEvent event) throws IOException {
        if (isValidToStart()) {
            Client client = new Client(textIp.getText());
            client.sendMessage(textUserName.getText());
            //TODO Tạo thread mới để loại bỏ hiện tượng treo app khi chờ response từ server
            String[] info = client.receiveMessage().split("_");
            startGame(info[0], info[1], info[2]);
        }
    }

    private void setupRadioGroup() {
        ToggleGroup group = new ToggleGroup();
        radioPvp.setToggleGroup(group);
        radioPvp.setSelected(true);
        radioAiEasy.setToggleGroup(group);
        radioAiHard.setToggleGroup(group);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (group.getSelectedToggle() == radioPvp) {
                    textIp.setDisable(false);
                } else if (group.getSelectedToggle() == radioAiEasy) {
                    textIp.setDisable(true);
                } else if (group.getSelectedToggle() == radioAiHard) {
                    textIp.setDisable(true);
                }
            }
        });
    }

    private boolean isValidToStart() {
        return (!textUserName.getText().equals("") && !textIp.getText().equals(""));
    }

    private void startGame(String playerId, String playerName, String rivalName) {
        try {
            MainController mainController = new MainController(playerId, playerName, rivalName);
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/main_screen.fxml"));
            Stage stage = (Stage) btnStart.getScene().getWindow();
            loader.setController(mainController);
            Parent root = loader.load();
            stage.getScene().setRoot(root);
            stage.show();
            stage.sizeToScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
