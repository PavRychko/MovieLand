package com.upskill.movieland.sort;

import lombok.Getter;

@Getter
public enum SortField {
    PRICE("price"),
    RATING("rating");

    private String title;

    SortField(String title) {
        this.title = title;
    }
}
