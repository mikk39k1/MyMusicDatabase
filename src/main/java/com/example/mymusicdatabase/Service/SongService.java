package com.example.mymusicdatabase.Service;

import com.example.mymusicdatabase.Model.Song;
import com.example.mymusicdatabase.Repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepo songRepo;

    public List<Song> fetchAll(){
        return songRepo.fetchAll();
    }

    public void addNewSong(Song song){
        songRepo.addNewSong(song);
    }

    public List<Song> fetchSongsById(int artistId){
        return songRepo.fetchSongsById(artistId);
    }
}
