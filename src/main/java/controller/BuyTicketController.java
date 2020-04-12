package controller;

import model.movie.Movie;
import model.movie.MovieDAO;
import model.order.Order;
import model.order.OrderDAO;
import model.order.OrderService;
import model.schedule.Schedule;
import model.schedule.ScheduleDAO;
import model.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tools.ScheduleForView;
import tools.Seat;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BuyTicketController {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private OrderDAO orderDAO;

    private ScheduleService scheduleService = new ScheduleService();

    private OrderService orderService = new OrderService();

    @RequestMapping("/buy/date/*")
    public String getDateForMovie(Model model, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        int id = getId(url);
        Movie movie = movieDAO.getMovieOnId(id);
        if (movie == null) {
            return "404-error";
        }
        model.addAttribute("movie", movie);
        List<Schedule> schedule = scheduleDAO.getScheduleByMovieID(id);
        List<ScheduleForView> scheduleForView = scheduleService.filter(schedule);
        model.addAttribute("schedule", scheduleForView);
        model.addAttribute("type","date");
        return "buyPage";
    }

    @RequestMapping("/buy/seat/*")
    public String getSeatsForMovie(Model model, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        int id = getId(url);
        if (checkId(id, model)) {
            return "404-error";
        }
        String date = request.getParameter("choisenDate");
        String time = request.getParameter("choisenTime");
        List<Order> orders = orderDAO.getOrders(date,time,id);
        List<Seat> takenSeats = orderService.makeSeatsForView(orders);
        model.addAttribute("takenSeats",takenSeats);
        model.addAttribute("type","seats");
        return "buyPage";
    }

    boolean checkId(int id,Model model) {
        Movie movie = movieDAO.getMovieOnId(id);
        if (movie == null) {
            return true;
        }
        model.addAttribute("movie", movie);
        return false;
    }

    private int getId(String url) {
        String[] partsOfUrl = url.split("/");
        int id = Integer.valueOf(partsOfUrl[partsOfUrl.length - 1]);
        return id;
    }

}
