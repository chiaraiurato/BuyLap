package com.example.buylap.model;

public class Category {
    private String title;
    private String url;
    private String subtitles;
    private float price;

    public Category(String title, String url, String subtitles, float price){
        this.title =title;
        this.url= url;
        this.subtitles = subtitles;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }
}
