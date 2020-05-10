package model.movie;


import model.actor.Actor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MovieDAO {
    List<Movie> getMoviesInRent();
    Movie getMovieOnId(int id);
    List getMoviesOnMainPage();
}
