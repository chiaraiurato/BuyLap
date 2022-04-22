package com.example.buylap.model;

public class ModelBuild {
    private String name;
    private String subtitles;
    private String url;
    private float price;

    public ModelBuild(String name, String subtitles, String url, float price) {
        this.name = name;
        this.subtitles = subtitles;
        this.url = url;
        this.price = price;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
