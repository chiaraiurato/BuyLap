package com.example.buylap;

public class Category {
    private String title;
    private String url;
    private String subtitles;

    public Category(String title, String url, String subtitles){
        this.title =title;
        this.url= url;
        this.subtitles = subtitles;
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
