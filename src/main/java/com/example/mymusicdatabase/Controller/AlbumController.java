package com.example.mymusicdatabase.Controller;

import com.example.mymusicdatabase.Model.Album;
import com.example.mymusicdatabase.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlbumController {


    @Autowired
    AlbumService albumService;

    @GetMapping("/albums")
    public String albums(@RequestParam("artistId") int artistId, Model model){
        List<Album> albumList = albumService.fetchByArtistId(artistId);
        model.addAttribute("albums", albumList);
        return "home/albums";
    }

    @GetMapping("/createAlbum")
    public String createAlbum(){
        return "home/createAlbum";
    }

    @GetMapping("/deleteAlbum/{album_id}")
    public String deleteAlbum(@PathVariable("album_id")int albumId){
        boolean deleted = albumService.deleteAlbum(albumId);
        return deleted ? "redirect:/" : "redirect:/";
    }

    @PostMapping("/createNewAlbum")
    public String createNewAlbum(@ModelAttribute Album album){
        albumService.addNewAlbum(album);
        return "redirect:/";
    }

    @GetMapping("/editAlbum/{album_id}")
    public String editAlbum(@PathVariable("album_id")int albumId, Model model){
        model.addAttribute("album", albumService.findAlbumById(albumId));
        return "home/editAlbum";
    }

    @PostMapping("/editAlbum")
    public String editAlbum(@ModelAttribute Album album){
        albumService.editAlbum(album.getAlbumId(), album);
        return "redirect:/";
    }
}
