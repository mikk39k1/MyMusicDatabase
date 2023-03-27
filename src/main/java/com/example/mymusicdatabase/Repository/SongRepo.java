package com.example.mymusicdatabase.Repository;

import com.example.mymusicdatabase.Model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Song> fetchAll(){
        String sql = "SELECT * FROM song";
        RowMapper<Song> rowMapper = new BeanPropertyRowMapper<>(Song.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    public void addNewSong(Song song){
        String sql = "INSERT INTO song (song_name, album_id) VALUES (?, ?)";
        jdbcTemplate.update(sql,song.getSongName(), song.getAlbumId());
    }

    public List<Song> fetchSongsById(int artistId){
        String sql = "SELECT * FROM song WHERE artistId = " + artistId;
        RowMapper<Song> rowMapperById = new BeanPropertyRowMapper<>(Song.class);
        return jdbcTemplate.query(sql,rowMapperById);
    }
}
