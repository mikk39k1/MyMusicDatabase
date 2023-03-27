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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ArtistService artistService;

    @Autowired
    AlbumService albumService;

    @Autowired
    SongService songService;


    // MAPPINGS THAT DISPLAYS THE HOME, ALBUMS, AND SONGS PAGE/TABLES --------------------
    @GetMapping("/")
    public String index(Model model){
        List<Artist> artistList = artistService.fetchAll();
        model.addAttribute("artists", artistList);
        return "home/index";
    }

    @GetMapping("/albums")
    public String albums(@RequestParam("artistId") int artistId, Model model){
        List<Album> albumList = albumService.fetchByArtistId(artistId);
        model.addAttribute("albums", albumList);
        return "home/albums";
    }

    @GetMapping("/songs")
    public String songs(@RequestParam("artistId") int artistId, Model model){
        List<Song> songlist = songService.fetchSongsById(artistId);
        model.addAttribute("songs", songlist);
        return "home/songs";
    }

    @GetMapping("/createArtist")
    public String createArtist(){
        return "home/createArtist";
    }

    @GetMapping("/createSong")
    public String createSong(){
        return "home/createSong";
    }

    @GetMapping("/createAlbum")
    public String createAlbum(){
        return "home/createAlbum";
    }

    // POST MAPPINGS TO CREATE NEW ARTISTS, ALBUMS AND SONGS TO TABLE

    @PostMapping("/createNewArtist")
    public String createNewArtist(@ModelAttribute Artist artist){
        artistService.addArtist(artist);
        return "redirect:/";
    }

    @PostMapping("/createNewSong")
    public String createNewSong(@ModelAttribute Song song){
        songService.addNewSong(song);
        return "redirect:/";
    }

    @PostMapping("/createNewAlbum")
    public String createNewAlbum(@ModelAttribute Album album){
        albumService.addNewAlbum(album);
        return "redirect:/";
    }


}
