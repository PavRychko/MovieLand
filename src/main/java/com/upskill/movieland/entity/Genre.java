package com.upskill.movieland.entity;

import lombok.*;
import javax.persistence.*;


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
