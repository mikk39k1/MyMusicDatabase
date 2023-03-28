package com.example.mymusicdatabase.Service;

import com.example.mymusicdatabase.Model.Artist;
import com.example.mymusicdatabase.Repository.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    ArtistRepo artistRepo;

    public List<Artist> fetchAll(){
        return artistRepo.fetchAll();
    }

    public void addArtist(Artist artist){
        artistRepo.addArtist(artist);
    }

    public boolean deleteArtist(int artistId) {
        return artistRepo.deleteArtist(artistId);
    }
}
