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
        String sql = "INSERT INTO song (song_name, album_id, artist_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,song.getSongName(), song.getAlbumId(), song.getArtistId());
    }

    public List<Song> fetchSongsById(int artistId){
        String sql = "SELECT * FROM song WHERE artist_id = " + artistId;
        RowMapper<Song> rowMapperById = new BeanPropertyRowMapper<>(Song.class);
        return jdbcTemplate.query(sql,rowMapperById);
    }

    public List<Song> fetchSongsByAlbumId(int albumId) {
        String sql = "SELECT * FROM song WHERE album_id = " + albumId;
        RowMapper<Song> rowMapper = new BeanPropertyRowMapper<>(Song.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    public boolean deleteSong(int songId) {
        String sql = "DELETE FROM song where song_id = ?";
        return jdbcTemplate.update(sql,songId) > 0;
    }
}
