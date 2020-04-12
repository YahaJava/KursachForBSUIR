package model.order;

import tools.Seat;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

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
}
