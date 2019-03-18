package com.java.util;

import java.util.ArrayList;
import java.util.List;

/**
 * List例子
 * @author yuefan
 * 2019.3.18
 */

public class Player {
    private String name;
    private String nickname;
    private Double score;
    private Double blackboard;
    private Double assists;

    public Player(){

    }

    public Player(String name, String nickname, Double score, Double blackboard, Double assists) {
        this.name = name;
        this.nickname = nickname;
        this.score = score;
        this.blackboard = blackboard;
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getBlackboard() {
        return blackboard;
    }

    public void setBlackboard(Double blackboard) {
        this.blackboard = blackboard;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", score=" + score +
                ", blackboard=" + blackboard +
                ", assists=" + assists +
                '}';
    }
    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("乔丹","飞人",30.1,6.1,5.2));
        playerList.add(new Player("拉塞尔","指环王",15.1,22.5,4.3));
        playerList.add(new Player("贾巴尔","天勾",24.6,11.2,3.6));
        playerList.add(new Player("张伯伦","篮球皇帝",30.1,22.9,4.4));
        System.out.println("球员    绰号    得分    篮板    助攻");
        for (int i = 0; i < playerList.size();  i++){
            System.out.println(playerList.get(i).getName() + "    " +
                    playerList.get(i).getNickname() + "    " + playerList.get(i).getScore() +"    "
                    + playerList.get(i).getBlackboard() + "    "
                    + playerList.get(i).getAssists());
        }
    }
}


