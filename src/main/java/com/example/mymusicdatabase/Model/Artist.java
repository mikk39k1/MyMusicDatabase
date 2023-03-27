package com.example.mymusicdatabase.Model;

public class Artist {
    private int artistId;
    private String artistName;

    // CONSTRUCTOR -------------------------------------------------

    public Artist() {

    }


    //SETTER -----------------------------------------------------
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    // GETTER --------------------------------------------------
    public int getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }
}
