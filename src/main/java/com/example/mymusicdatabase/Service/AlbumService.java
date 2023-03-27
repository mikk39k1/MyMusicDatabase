package com.example.mymusicdatabase.Service;

import com.example.mymusicdatabase.Model.Album;
import com.example.mymusicdatabase.Repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepo albumRepo;

    public List<Album> fetchAll(){
        return albumRepo.fetchAll();
    }

    public void addNewAlbum(Album album){
        albumRepo.addNewAlbum(album);
    }

    public List<Album> fetchByArtistId(int artistId) {
        return albumRepo.fetchByArtistId(artistId);
    }
}
