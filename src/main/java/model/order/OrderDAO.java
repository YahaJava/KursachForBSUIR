package model.order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders(String date,String time, int movieId);
}
