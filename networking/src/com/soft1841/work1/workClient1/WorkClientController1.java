package com.soft1841.work1.workClient1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class WorkClientController1{
    @FXML
    private TextArea displayArea;
    @FXML
    private TextArea editArea;
    private Socket client;

    public void connect(ActionEvent actionEvent) {
        try {
            client = new Socket("10.40.156.160",10086);
            displayArea.setText("成功连上服务器");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendOut(ActionEvent actionEvent) {
        String s = editArea.getText();
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bufferedWriter.write(s);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        displayArea.appendText(df.format(date) + "   发送：" +"\n" + s + "\n");
        displayArea.setEditable(false);
    }
}
