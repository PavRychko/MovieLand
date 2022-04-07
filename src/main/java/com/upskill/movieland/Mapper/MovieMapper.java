package com.upskill.movieland.Mapper;

import com.upskill.movieland.dto.MovieDto;
import com.upskill.movieland.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public List<MovieDto> map(List<Movie> movies) {
        List<MovieDto> dtos = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            MovieDto movieDto = map(movies.get(i));
            dtos.add(movieDto);
        }
        return dtos;
    }

    public MovieDto map(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .nameNative(movie.getNameNative())
                .nameRussian(movie.getNameRussian())
                .picturePath(movie.getPosterURL())
                .price(movie.getPrice())
                .rating(movie.getRating())
                .yearOfRelease(movie.getYearOfRelease())
                .build();

    }
}
