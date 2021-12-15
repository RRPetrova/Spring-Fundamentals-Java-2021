package com.example.music.repo;

import com.example.music.model.entity.Artist;
import com.example.music.model.entity.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Long> {
        Artist findByName(ArtistName name);

}
