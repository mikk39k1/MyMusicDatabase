package com.example.mymusicdatabase.Repository;

import com.example.mymusicdatabase.Model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Album> fetchAll(){
        String sql = "SELECT * FROM album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    public void addNewAlbum(Album album){
        String sql = "INSERT INTO album (album_name, artist_id) VALUES (?,?)";
        jdbcTemplate.update(sql, album.getAlbumName(),album.getArtistId());
    }

    public List<Album> fetchByArtistId(int artistId) {
        String sql = "SELECT * FROM album WHERE artist_id = " + artistId;
        RowMapper<Album> rowMapperById = new BeanPropertyRowMapper<>(Album.class);
        return jdbcTemplate.query(sql,rowMapperById);
    }
}
