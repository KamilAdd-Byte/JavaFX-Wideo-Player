package com.responsywnie.WideoExample.video;

public class VideoMp4 {
    private String artist;
    private String title;
    private String time;
    private String filePath;

    public VideoMp4(String artist, String title, String time, String filePath) {
        this.artist = artist;
        this.title = title;
        this.time = time;
        this.filePath = filePath;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString(){
        String result = "Wykonawca " + artist;
        result+= " >>> tytuł: " + title;
        result+= " >>> czas trwania: " + time;
        return result;
    }
}
