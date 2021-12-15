package com.example.music.model.dto;

import com.example.music.model.entity.ArtistName;
import com.example.music.model.entity.GenreEnum;
import com.example.music.model.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class AlbumAddDto {
    public String name;
    public String imgUrl;
    public BigDecimal price;
    public Integer copies;
    public LocalDate releasedDate;
    public String producer;
    public ArtistName artist;
    public GenreEnum genre;
    public String description;
    public User addedFrom;

    public AlbumAddDto() {
    }

    public String getName() {
        return name;
    }

    public AlbumAddDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumAddDto setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumAddDto setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumAddDto setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddDto setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public ArtistName getArtist() {
        return artist;
    }

    public AlbumAddDto setArtist(ArtistName artist) {
        this.artist = artist;
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddDto setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumAddDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public AlbumAddDto setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
