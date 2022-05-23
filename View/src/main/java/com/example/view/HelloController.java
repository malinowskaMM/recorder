package com.example.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class HelloController {
    @FXML Label text;
    @FXML Button pause;
    @FXML Button record;
    @FXML Button replay;
    @FXML Button send;
    @FXML Button receive;
    @FXML RadioButton sendChoose;
    @FXML RadioButton receiveChoose;

    Recorder rec;
    SendRecord sr;
    ReceiveRecord rr;

    @FXML
    void initialize(){
        rec = new Recorder();

        Image imgRecord = new Image("D:\\telekomunikacjaZad4\\View\\src\\main\\resources\\com\\example\\view\\play.jpg");
        ImageView viewRecord = new ImageView(imgRecord);
        viewRecord.setFitHeight(40);
        viewRecord.setPreserveRatio(true);
        record.setGraphic(viewRecord);

        Image img = new Image("D:\\telekomunikacjaZad4\\View\\src\\main\\resources\\com\\example\\view\\stop.jpg");
        ImageView view = new ImageView(img);
        view.setFitHeight(32);
        view.setPreserveRatio(true);
        pause.setGraphic(view);
    }

    @FXML void sendRecord() throws IOException {
        text.setText("Wysylanie pliku..");
        sr.send();
    }

    @FXML void receiveRecord() throws IOException {
        text.setText("Odbieranie pliku...");
        rr.receive();
    }

    @ FXML void updateChoose() {
        if (sendChoose.isSelected()) {
            send.setDisable(false);
            receive.setDisable(true);
        }
        if(receiveChoose.isSelected()) {
            send.setDisable(true);
            receive.setDisable(false);
        }
    }

    @ FXML void record() {
        text.setText("Nagrywanie...");
        rec.captureAudio();
    }

    @ FXML void pause() {
        text.setText("Zakonczono nagrywanie");
        rec.stopAudio();
    }

    @ FXML void play() {
        text.setText("Odtwarzanie...");
        rec.playRecord();
    }

}