package com.soft1841.work1.workServer1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WorkServerController1 {
    @FXML
    private TextArea receiveArea;

    public void start(ActionEvent actionEvent) {
        ServerSocket serverSocket;
        receiveArea.setEditable(false);
        try {
            serverSocket = new ServerSocket(10086);
            receiveArea.setText("服务器启动" +"\n");
            Socket socket;
            while (true){
                socket = serverSocket.accept();
                ServerThread server = new ServerThread(socket);
                new Thread(server).start();
                server.setReceiveArea(receiveArea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ServerThread implements Runnable{
    private Socket socket;
    private TextArea receiveArea;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void setReceiveArea(TextArea receiveArea) {
        this.receiveArea = receiveArea;
    }

    @Override
    public void run() {
        InputStream inputStream ;
        try {
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            inputStream.close();
            socket.close();
            receiveArea.setText(bytes.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

