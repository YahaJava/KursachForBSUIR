package controller;

import model.director.DBDirectorDAO;
import model.director.Director;
import model.director.DirectorDAO;
import model.movie.DBMovieDAO;
import model.movie.Movie;
import model.movie.MovieDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/film/*")
    public String makeMoviePage(Model model, HttpServletRequest request) {
        MovieDAO movieDAO = new DBMovieDAO();
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Movie movie = movieDAO.getMovieOnId(id);
        model.addAttribute("movie",movie);
        return "moviePage";
    }

    @RequestMapping("/director/*")
    public String makeDirectorPage(Model model, HttpServletRequest request) {
        DirectorDAO directorDAO = new DBDirectorDAO();
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Director director = directorDAO.getDirectorOnId(id);
        model.addAttribute("director",director);
        return "manPage";
    }

    private int getId(String url){
        String[] partsOfUrl = url.split("/");
        int id = Integer.valueOf(partsOfUrl[partsOfUrl.length-1]);
        return id;
    }
}
