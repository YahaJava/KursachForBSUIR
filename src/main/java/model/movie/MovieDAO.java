package model.movie;


import model.actor.Actor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MovieDAO {
    List<Movie> getMoviesInRent() throws SQLException;
    Movie getMovieOnId(int id);
    List getMoviesOnMainPage();
    List<Movie> getMoviesInNoneRent() throws SQLException;
    List<Movie> getAllMovies() throws SQLException;
    List<Movie> getMoviesOnActors(Actor actor) throws SQLException;
    List<Movie> searchMovies(String searchParameter) throws SQLException;
    void updateRent(ArrayList<String> list1, ArrayList<String> list2) throws SQLException;
}
