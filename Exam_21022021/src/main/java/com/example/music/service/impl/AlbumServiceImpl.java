package com.example.music.service.impl;

import com.example.music.model.dto.AlbumAddDto;
import com.example.music.model.entity.Album;
import com.example.music.repo.AlbumRepo;
import com.example.music.service.AlbumService;
import com.example.music.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepo albumRepo;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepo albumRepo, ModelMapper modelMapper,
                            ArtistService artistService) {
        this.albumRepo = albumRepo;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
    }

    @Override
    public void addNewAlbum(AlbumAddDto albumAddDto) {
        Album album = modelMapper.map(albumAddDto, Album.class);
        album.setArtist(this.artistService.findByName(albumAddDto.getArtist()));
        album.setImageUrl(albumAddDto.getImgUrl());

        this.albumRepo.save(album);
        System.out.println();
    }

    @Override
    public List<Album> findAll() {
        return this.albumRepo.findAll();
    }

    @Override
    public void deleteAlbumById(Long id) {
        this.albumRepo.deleteById(id);
    }

    @Override
    public Integer totalSoldCopies() {
        return this.albumRepo.totalSoldCopies();
    }
}
