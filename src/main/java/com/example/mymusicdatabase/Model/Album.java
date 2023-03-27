package com.example.mymusicdatabase.Model;

public class Album {
    private int albumId;
    private String albumName;
    private int artistId;

    // CONSTRUCTOR --------------------------------------------

    public Album() {
    }

    // SETTER --------------------------------------------------

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    // GETTER ---------------------------------------------------------

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getArtistId() {
        return artistId;
    }
}
