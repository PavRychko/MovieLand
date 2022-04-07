package com.upskill.movieland.repository;

import com.upskill.movieland.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM movie m\n" +
            "ORDER BY RAND()\n" +
            "LIMIT amount")
    List<Movie> getRandomMovies(int amount);

    @Query("select m from movie m " +
            "left join genres" +
            "on m.genre_id = genre.id" +
            "where genre.id = genreId")
    List<Movie> getByGenreId(Integer genreId);
}
