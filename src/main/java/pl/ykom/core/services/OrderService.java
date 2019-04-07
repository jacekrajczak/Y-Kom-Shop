package pl.ykom.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ykom.data.model.Order;
import pl.ykom.data.repositories.OrderRepository;
import pl.ykom.data.repositories.UserRepository;
import pl.ykom.dto.OrderDTO;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

//    public void saveOrder(Long userId) {
//
//        Order order = new Order();
//
//        order.setUser(userRepository.getOne(userId));
//        order.setStatus("Zamówiono");
//        order.setDescription("domyślny opis");
//        order.setOrderDate(LocalDate.now());
//        order.setOrderProducts(null);
//
//    }
}
