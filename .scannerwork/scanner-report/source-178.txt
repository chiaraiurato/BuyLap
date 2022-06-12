package com.example.buylap.model;

public class ModelBuild {

    private String type;
    private String title;
    private String subtitles;
    private String urlEbay;
    private float price;

    public ModelBuild(String type, String title, String subtitles, String urlEbay, float price) {
        this.type = type;
        this.title = title;
        this.subtitles = subtitles;
        this.urlEbay = urlEbay;
        this.price = price;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getUrlEbay() {
        return urlEbay;
    }

    public void setUrlEbay(String urlEbay) {
        this.urlEbay = urlEbay;
    }
}
