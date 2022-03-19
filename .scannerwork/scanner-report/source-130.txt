package com.example.buylap.model;

public class ModelBuild {
    private String name;
    private String subtitles;
    private String url;

    public ModelBuild(String name, String subtitles, String url) {
        this.name = name;
        this.subtitles = subtitles;
        this.url = url;
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
