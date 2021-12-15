package com.example.music.service;

import com.example.music.model.dto.AlbumAddDto;
import com.example.music.model.entity.Album;

import java.util.List;

public interface AlbumService {
    void addNewAlbum(AlbumAddDto albumAddDto);

    List<Album> findAll();

    void deleteAlbumById(Long id);

    Integer totalSoldCopies();
}
