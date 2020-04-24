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
import model.order.Order;
import model.order.OrderDAO;
import model.order.OrderService;
import model.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class MainPageController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private MovieDAO movieDAO;

    private OrderService orderService = new OrderService();

    @RequestMapping("/")
    public String makeHomePage(Model model) throws SQLException {
        List<Movie> mainMovies = movieDAO.getMoviesOnMainPage();
        model.addAttribute("mainMovies", mainMovies);
        return "homePage";
    }

    @RequestMapping("/poster")
    public String makeAllMoviesPage(Model model) throws SQLException {
        List<Movie> movies = movieDAO.getMoviesInRent();
        model.addAttribute("movies", movies);
        return "poster";
    }

    @RequestMapping("/film/*")
    public String makeMoviePage(Model model, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Movie movie = movieDAO.getMovieOnId(id);
        if (movie == null) {
            return "404-error";
        }
        model.addAttribute("movie", movie);
        return "moviePage";
    }


    @RequestMapping("/director/*")
    public String makeDirectorPage(Model model, HttpServletRequest request) {
        DirectorDAO directorDAO = new DBDirectorDAO();
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Director director = directorDAO.getDirectorOnId(id);
        if (director == null) {
            return "404-error";
        }
        model.addAttribute("man", director);
        return "manPage";
    }

    @RequestMapping("/actor/*")
    public String makeActorPage(Model model, HttpServletRequest request) {
        ActorDAO actorDAO = new DBActorDAO();
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Actor actor = actorDAO.getActorOnId(id);
        if (actor == null) {
            return "404-error";
        }
        model.addAttribute("man", actor);
        return "manPage";
    }

    @RequestMapping("/userOrders")
    public String getUserOrders(Model model, Principal principal) {
        List<Order> orders = orderDAO.getUserOrders(principal.getName());
        orders = orderService.filterOrders(orders);
        model.addAttribute("orders", orders);
        return "userOrders";
    }

    @RequestMapping("/deleteOrder/*")
    public String deleteOrder(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        int id = getId(url);
        orderDAO.deleteOrder(id);
        return "redirect:/userOrders?success=true";
    }

    private int getId(String url) {
        String[] partsOfUrl = url.split("/");
        int id = Integer.valueOf(partsOfUrl[partsOfUrl.length - 1]);
        return id;
    }
}
