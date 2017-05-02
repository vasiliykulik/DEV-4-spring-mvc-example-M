package ua.com.garage.dao;

import ua.com.garage.model.Orders;

import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public interface OrderDao {
    void save(Orders orders);
    // 117. Таким же образом - для начала в интерфейсе объявим

    List<Orders> findAllOrders();
}
