package service.Impl;

import models.Movie;
import service.MovieSortableService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImplMovieSortableService implements MovieSortableService {
    private final List<Movie> movies;

    public ImplMovieSortableService(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public void sortMovieByName(String ascOrDesc) {
        movies.sort(Comparator.comparing(Movie::getName));
        if (ascOrDesc.equalsIgnoreCase("descend")) {
            Collections.reverse(movies);
        }
    }



    @Override
    public void sortByYear(String ascOrDesc) {
        movies.sort(Comparator.comparing(Movie::getYear));
        if(ascOrDesc.equalsIgnoreCase("descend"))
            Collections.reverse(movies);

    }

    @Override
    public void sortByProducer(String nameOrlastName) {
        if (nameOrlastName.equalsIgnoreCase("descend")) {
            movies.sort(Comparator.comparing(moviem -> moviem.getProducer().getFirstName()));
        } else if (nameOrlastName.equalsIgnoreCase("ascend")){
            movies.sort(Comparator.comparing(moviem-> moviem.getProducer().getFirstName()));
            Collections.reverse(movies);
        }


    }
}
