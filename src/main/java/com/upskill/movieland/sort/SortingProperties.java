package com.upskill.movieland.sort;

import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public class SortingProperties {
    private Sort.Direction direction;
    private String byField;

    public SortingProperties(String sortField, String sortDirection) {
        if (sortDirection != null) {
            direction = Sort.Direction.fromString(sortDirection);
        } else {
            direction = Sort.DEFAULT_DIRECTION;
        }

        if (sortField != null) {
            byField = SortField.RATING.getTitle();
        } else {
            byField = defineSortField(sortField);
        }
    }

    private String defineSortField(String sortField) {
        if (sortField.equalsIgnoreCase(SortField.PRICE.getTitle())) {
            return sortField;
        }
        return SortField.RATING.getTitle();
    }
}
