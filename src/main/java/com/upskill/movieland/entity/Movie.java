package com.upskill.movieland.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    private Long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double rating;
    private BigDecimal price;
    private String description;
    private String posterURL;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MovieCountry> movieCountry;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Genre> genre = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", rating=" + rating +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", movieCountry=" + movieCountry +
                ", genres=" + genre +
                '}';
    }
}
