package com.example.mymusicdatabase.Controller;

import com.example.mymusicdatabase.Model.Album;
import com.example.mymusicdatabase.Model.Artist;
import com.example.mymusicdatabase.Model.Song;
import com.example.mymusicdatabase.Service.AlbumService;
import com.example.mymusicdatabase.Service.ArtistService;
import com.example.mymusicdatabase.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    ArtistService artistService;


    @GetMapping("/createArtist")
    public String createArtist(){
        return "home/createArtist";
    }


    // GET MAPPINGS TO DELETE DATA

    @GetMapping("/deleteArtist/{artist_id}")
    public String deleteArtist(@PathVariable("artist_id")int artistId){
        boolean deleted = artistService.deleteArtist(artistId);
        return deleted ? "redirect:/" : "redirect:/";
    }


    // POST MAPPINGS TO CREATE NEW ARTISTS TO TABLE

    @PostMapping("/createNewArtist")
    public String createNewArtist(@ModelAttribute Artist artist){
        artistService.addArtist(artist);
        return "redirect:/";
    }







}
