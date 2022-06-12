package com.example.buylap.model;

public class ModelPoints {
    public ModelPoints(int points) {
        this.points = points;
    }
    public ModelPoints(){
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
