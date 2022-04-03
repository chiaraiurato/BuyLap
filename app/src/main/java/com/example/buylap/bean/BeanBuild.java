package com.example.buylap.bean;

public class BeanBuild {
    private String title;
    private String subtitles;
    private String urlEbay;
    private Float price;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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
