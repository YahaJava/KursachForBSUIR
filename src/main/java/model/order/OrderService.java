package model.order;

import tools.DateService;
import tools.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private DateService dateService = new DateService();

    public List<Seat> makeSeatsForView(List<Order> orders) {
        List<Seat> seats = new ArrayList<>();
        for (Order order:orders) {
            String[] s1 = order.getSeat().split(" ");
            for (String s2:s1) {
                String[] s3 = s2.split(":");
                seats.add(new Seat(s3[0],s3[1]));
            }
        }
        return seats;
    }

    public List<Order> filterOrders(List<Order> orders) {
        long currentDate = dateService.getCurrentDate();
        orders.forEach(item -> {
            long date = dateService.getIntDate(item.getDate() + " " + item.getTime());
            if(date < currentDate && item.getStatus().equals("Active")) {
                item.setStatus("Deprecated");
            }
        });
        return orders;
    }
}
