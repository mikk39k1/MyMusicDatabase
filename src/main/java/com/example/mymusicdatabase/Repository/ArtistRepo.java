package com.example.mymusicdatabase.Repository;

import com.example.mymusicdatabase.Model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ArtistRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Artist> fetchAll(){
        String sql = "SELECT * FROM artist";
        RowMapper<Artist> rowMapper = new BeanPropertyRowMapper<>(Artist.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    public void addArtist(Artist artist){
        String sql = "INSERT INTO artist (first_name, last_name) VALUES (?,?)";
        jdbcTemplate.update(sql, artist.getFirstName(), artist.getLastName());
    }

    public boolean deleteArtist(int artistId) {
        String sql = "DELETE FROM artist WHERE artist_id = ?";
        return jdbcTemplate.update(sql, artistId) > 0;
    }
}
