package com.example.mymusicdatabase.Model;

public class Song {
    private int songId;
    private String songName;
    private int albumId;

    // CONSTRUCTOR -----------------------------------

    public Song() {
    }

    // SETTER -----------------------------------------------

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    // GETTER ----------------------------------------------------------

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public int getAlbumId() {
        return albumId;
    }
}
