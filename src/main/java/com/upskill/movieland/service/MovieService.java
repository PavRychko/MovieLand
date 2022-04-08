package com.upskill.movieland.service;


import com.upskill.movieland.entity.Movie;
import com.upskill.movieland.repository.MovieRepository;
import com.upskill.movieland.sort.SortingProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll(SortingProperties sortingProperties) {
        List<Movie> all = movieRepository.findAll(Sort.by(sortingProperties.getDirection(), sortingProperties.getByField()));
        log.info("MovieService getAll worked ");
        return all;
    }

    public List<Movie> getRandomMovies(int amount, SortingProperties sortingProperties) {
        List<Movie> randomMovies = movieRepository.getRandomMovies(amount, Sort.by(sortingProperties.getDirection(), sortingProperties.getByField()));
        log.info("MovieService get random movies with amount {}", amount);
        return randomMovies;
    }

    public List<Movie> getMoviesByGenre(Integer genreId) {
        return movieRepository.getByGenreId(genreId);
    }
}
