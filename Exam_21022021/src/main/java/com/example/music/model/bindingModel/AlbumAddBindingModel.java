package com.example.music.model.bindingModel;

import com.example.music.model.entity.Artist;
import com.example.music.model.entity.ArtistName;
import com.example.music.model.entity.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class AlbumAddBindingModel {
    public String name;
    public String imgUrl;
    public BigDecimal price;
    public Integer copies;
    public LocalDate releasedDate;
    public String producer;
    public ArtistName artist;
    public GenreEnum genre;
    public String description;

    public AlbumAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    public String getName() {
        return name;
    }


    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    @NotBlank
    @Size(min = 5, message = "Image URL must be more than 5 symbols.")
    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumAddBindingModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull
    @Min(10)
    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @NotNull(message = "Enter a date.")
    @PastOrPresent(message = "Enter valid date.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumAddBindingModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull
    public ArtistName getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistName artist) {
        this.artist = artist;
        return this;
    }

    @NotNull
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @NotBlank
    @Size(min = 5, message = "Description must be min 5 symbols.")
    public String getDescription() {
        return description;
    }


    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
