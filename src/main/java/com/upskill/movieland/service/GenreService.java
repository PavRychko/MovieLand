package com.upskill.movieland.service;

import com.upskill.movieland.entity.Genre;
import com.upskill.movieland.entity.Movie;
import com.upskill.movieland.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private volatile List<Genre> cachedGenresList;

    @PostConstruct
    private void initCache(){
        fillCache();
    }

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAll(){
       return genreRepository.findAll();
    }

//    @Scheduled(cron = "${cron.interval}")
    private final void fillCache(){
        cachedGenresList = genreRepository.findAll();

    }




}
