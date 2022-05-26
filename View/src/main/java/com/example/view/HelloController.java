package com.example.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML TextField sampleRate;

    Recorder rec;
    SendRecord sr;
    ReceiveRecord rr;

    @FXML
    void initialize(){
        rec = new Recorder();
        sr = new SendRecord();
        rr = new ReceiveRecord();

        send.setDisable(true);
        receive.setDisable(true);

        Image imgRecord = new Image("C:\\telekomunikacjeZad4_2\\View\\src\\main\\resources\\com\\example\\view\\play.jpg");
        ImageView viewRecord = new ImageView(imgRecord);
        viewRecord.setFitHeight(40);
        viewRecord.setPreserveRatio(true);
        record.setGraphic(viewRecord);

        Image img = new Image("C:\\telekomunikacjeZad4_2\\View\\src\\main\\resources\\com\\example\\view\\stop.jpg");
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
        String sampleRateString = sampleRate.getText();
        rec.captureAudio(Float.parseFloat(sampleRateString));
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