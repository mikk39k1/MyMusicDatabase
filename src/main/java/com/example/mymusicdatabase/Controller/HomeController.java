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
public class HomeController {

    @Autowired
    ArtistService artistService;




    // MAPPINGS THAT DISPLAYS THE HOME, ALBUMS, AND SONGS PAGE/TABLES --------------------
    @GetMapping("/")
    public String index(Model model){
        List<Artist> artistList = artistService.fetchAll();
        model.addAttribute("artists", artistList);
        return "home/index";
    }














}
