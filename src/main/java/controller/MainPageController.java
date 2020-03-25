package controller;

import model.actor.Actor;
import model.actor.ActorDAO;
import model.actor.DBActorDAO;
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
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        if(movie==null){
            return "404-error";
        }
        model.addAttribute("movie",movie);
        return "moviePage";
    }

    @RequestMapping("/director/*")
    public String makeDirectorPage(Model model, HttpServletRequest request) {
        DirectorDAO directorDAO = new DBDirectorDAO();
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Director director = directorDAO.getDirectorOnId(id);
        if(director==null){
            return "404-error";
        }
        model.addAttribute("man",director);
        return "manPage";
    }

    @RequestMapping("/actor/*")
    public String makeActorPage(Model model, HttpServletRequest request) {
        ActorDAO actorDAO = new DBActorDAO();
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Actor actor = actorDAO.getActorOnId(id);
        if(actor==null){
            return "404-error";
        }
        model.addAttribute("man",actor);
        return "manPage";
    }

    private int getId(String url){
        String[] partsOfUrl = url.split("/");
        int id = Integer.valueOf(partsOfUrl[partsOfUrl.length-1]);
        return id;
    }
}
