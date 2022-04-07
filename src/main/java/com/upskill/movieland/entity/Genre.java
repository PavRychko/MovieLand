package com.upskill.movieland.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "genre")
public class Genre {
    @Id
    private int id;
    private String genre;





}
