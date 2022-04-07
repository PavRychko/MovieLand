package com.upskill.movieland.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "country")
public class MovieCountry {
    @Id
    private Long id;
    private String country;
}
