package com.ecommerce.data.repository;

import com.ecommerce.data.exceptions.OrderException;
import com.ecommerce.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    public default Order saveOrder(Order order) throws OrderException {
        if (order.getCustomer() == null) {
            throw new OrderException("Customer can not be null");
        }

        save(order);
        return order;
    }

    private boolean isOrderValid (Order order) {


        return false;
    }
}
