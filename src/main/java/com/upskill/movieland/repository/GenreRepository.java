package com.upskill.movieland.repository;

import com.upskill.movieland.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {



}
