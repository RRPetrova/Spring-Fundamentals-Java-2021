package com.example.music.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{
    public ArtistName name;
    public String careerInformation;

    public Artist() {

    }

   @Enumerated(EnumType.STRING)
    public ArtistName getName() {
        return name;
    }

    public Artist setName(ArtistName name) {
        this.name = name;
        return this;
    }

    @Column(name = "career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public Artist setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
