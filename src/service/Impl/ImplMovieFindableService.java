package service.Impl;

import models.Actor;
import models.Genre;
import models.Movie;
import service.MovieFindableService;

import java.time.LocalDate;
import java.util.List;


public class ImplMovieFindableService implements MovieFindableService {
    private List<Movie> movies;

    public ImplMovieFindableService(List<Movie> movies) {
        this.movies = movies;
    }



@Override
public List<Movie> getAllMovies() {
    return movies;
}

@Override
public Movie findMovieByFullNameOrPartName(String name) {
    for (Movie movie : movies) {
        if (movie.getName().contains(name)) {
            return movie;
        }
    }
    return null;
}

@Override
public Movie findMovieByActorName(String actorName) {
    for (Movie movie : movies) {
        for (Actor actor : movie.getActors()) {
            if (actor.getActorFullName().equalsIgnoreCase(actorName)) {
                return movie;
            }
        }
    }
    return null;
}



    @Override
public Movie findMovieByYear(LocalDate year) {
    for (Movie movie : movies) {
        if (movie.getYear().equals(year)) {
            return movie;
        }
    }
    return null;
}

@Override
public Movie findMovieByProducer(String producerFullName) {
    for (Movie movie : movies) {
        if (movie.getProducer().getFirstName().equalsIgnoreCase(producerFullName)) {
            return movie;
        }
    }
    return null;
}

@Override
public Movie findMovieByGenre(Genre genre) {
    for (Movie movie : movies) {
        if (movie.getGenre() == genre) {
            return movie;
        }
    }
    return null;
}

@Override
public Movie findMovieByRole(String role) {
    for (Movie movie : movies) {
        for (Actor actor : movie.getActors()) {
            if (actor.getRole().equalsIgnoreCase(role)) {
                return movie;
            }
        }
    }
    return null;
}
}