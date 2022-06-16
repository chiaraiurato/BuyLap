package com.example.buylap.model;

public class ModelCashback {
    public ModelCashback(int points) {
        this.points = points;
    }
    public ModelCashback(){
        this.points = 0;
    }

    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
