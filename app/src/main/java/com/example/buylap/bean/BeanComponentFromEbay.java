package com.example.buylap.bean;

public class BeanComponentFromEbay {

    private String type;
    private String title;
    private String subtitles;
    private String urlEbay;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
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

    public void setUrlEbay(String urlEbay ){
        this.urlEbay = urlEbay;
    }
}
