package com.example.music.repo;

import com.example.music.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Long> {

    @Query("SELECT SUM(a.copies) FROM Album a ")
    Integer totalSoldCopies();
}
