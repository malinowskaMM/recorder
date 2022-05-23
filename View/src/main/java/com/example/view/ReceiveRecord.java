package com.example.view;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveRecord {

    void receive() throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        Socket s = ss.accept();

        DataInputStream dataInputStream = new DataInputStream(s.getInputStream());

        int fileNamelength = dataInputStream.readInt();

        if(fileNamelength > 0) {
            byte[] fileNameBytes = new byte[fileNamelength];
            dataInputStream.readFully(fileNameBytes, 0, fileNameBytes.length);
            String filename =  new String(fileNameBytes);

            int fileContentLength = dataInputStream.readInt();

            if(fileContentLength > 0) {
                byte[] fileContentBytes = new byte[fileContentLength];
                dataInputStream.readFully(fileContentBytes, 0, fileContentLength);

                File downloadFile = new File("record");

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(downloadFile);
                    fileOutputStream.write(fileContentBytes);
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }
    }
}
