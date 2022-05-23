package com.example.view;

import java.io.*;
import java.net.Socket;

public class SendRecord {

    void send() throws IOException {
        Socket s = new Socket("192.168.0.4",1234);

        File record = new File("record");
        FileInputStream fileInputStream = new FileInputStream(record);

        DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());

        String fileName = record.getName();
        byte[] fileNameBytes = fileName.getBytes();

        byte[] fileContent = new byte[(int) record.length()];
        fileInputStream.read(fileContent);

        dataOutputStream.writeInt(fileNameBytes.length);
        dataOutputStream.write(fileNameBytes);

        dataOutputStream.writeInt(fileContent.length);
        dataOutputStream.write(fileContent);
    }
}
