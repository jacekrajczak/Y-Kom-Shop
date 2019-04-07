package pl.ykom.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ykom.data.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
