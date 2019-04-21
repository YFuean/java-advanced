package com.soft1841.sinaReading;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread extends Thread {
    private JLabel timeLabel;
    public void setTimeLabel(JLabel timeLabel){
        this.timeLabel=timeLabel;
    }

    /* String -> Date */
    private Date String2Date(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    void getTime(String dateStr){
        Date end = String2Date(dateStr);

        long time = (end.getTime() - 1 - new Date().getTime()) / 1000; // 自定义倒计时时间
        long hour ;
        long minute;
        long seconds ;

        while (time >= 0) {
            hour = time / 3600;
            minute = (time - hour * 3600) / 60;
            seconds = time - hour * 3600 - minute * 60;
            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("<html><br>距离").append(dateStr).append("还有<br><br>")
//                    .append(hour).append("时 ").append(minute).append("分 ").append(seconds).append("秒 ")
//                    .append("</html>");
            stringBuilder.append(hour).append("时 ").append(minute).append("分 ").append(seconds).append("秒 ");
            timeLabel.setText(stringBuilder.toString());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }
    }

}
