package controller;

import model.movie.DBMovieDAO;
import model.movie.Movie;
import model.movie.MovieDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MainPageController {

    @RequestMapping("/")
    public String makeHomePage() {
        return "homePage";
    }

    @RequestMapping("/poster")
    public String makeAllMoviesPage(Model model) throws SQLException {
        MovieDAO movieDAO = new DBMovieDAO();
        List<Movie> movies = movieDAO.getMoviesInRent();
        model.addAttribute("movies", movies);
        return "poster";
    }
}
