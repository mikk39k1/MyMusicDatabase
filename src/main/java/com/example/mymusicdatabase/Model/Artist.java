package com.example.mymusicdatabase.Model;

public class Artist {

    private int artistId;
    private String firstName;
    private String lastName;


    // CONSTRUCTOR -------------------------------------------

    public Artist() {
    }


    // GETTER -----------------------------------------------

    public int getArtistId() {
        return artistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    // SETTER ------------------------------------------------------

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
