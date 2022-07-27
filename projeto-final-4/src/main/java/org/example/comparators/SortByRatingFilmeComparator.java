package org.example.comparators;

import org.example.models.Filme;

import java.util.Comparator;

public class SortByRatingFilmeComparator implements Comparator<Filme> {
    @Override
    public int compare(Filme a, Filme b) {
        return Double.valueOf(b.getRating()).compareTo(Double.valueOf(a.getRating()));
    }
}
