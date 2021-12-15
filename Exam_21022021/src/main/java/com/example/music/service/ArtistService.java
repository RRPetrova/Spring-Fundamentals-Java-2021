package com.example.music.service;

import com.example.music.model.entity.Artist;
import com.example.music.model.entity.ArtistName;

import java.util.List;

public interface ArtistService {
    void initializeArtists();

    List<Artist> findAll();
    Artist findByName(ArtistName name);
}
