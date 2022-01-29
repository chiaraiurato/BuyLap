package com.example.buylap.Bean;

public class BEANcpu {

    private String Name;
    private String Subtitles;
    private String Url;

    public BEANcpu(String name, String subtitles, String url) {
        this.Name = name;
        this.Subtitles = subtitles;
        this.Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSubtitles() {
        return Subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.Subtitles = subtitles;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }
}
