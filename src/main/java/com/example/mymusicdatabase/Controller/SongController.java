package com.example.mymusicdatabase.Controller;

import com.example.mymusicdatabase.Model.Song;
import com.example.mymusicdatabase.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongService songService;


    @GetMapping("/createSong")
    public String createSong(){
        return "home/createSong";
    }

    @GetMapping("/songs")
    public String songs(@RequestParam("artistId") int artistId, Model model){
        List<Song> songlist = songService.fetchSongsById(artistId);
        model.addAttribute("songs", songlist);
        return "home/songs";
    }

    @GetMapping("/viewSongsByAlbumId/{album_id}")
    public String viewSongsByAlbumId(@PathVariable("album_id")int albumId, Model model){
        model.addAttribute("songs", songService.fetchSongsByAlbumId(albumId));
        return "home/songs";
    }


    @GetMapping("/deleteSong/{song_id}")
    public String deleteSong(@PathVariable("song_id")int songId){
        boolean deleted = songService.deleteSong(songId);
        return deleted ? "redirect:/" : "redirect:/";
    }

    @PostMapping("/createNewSong")
    public String createNewSong(@ModelAttribute Song song){
        songService.addNewSong(song);
        return "redirect:/";
    }
}
