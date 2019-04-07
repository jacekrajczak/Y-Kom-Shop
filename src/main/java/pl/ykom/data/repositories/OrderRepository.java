package pl.ykom.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ykom.data.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
