package pl.ykom.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.ykom.data.model.Order;

import java.math.BigDecimal;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query("UPDATE Order o SET o.totalCost=?2 WHERE o.orderId=?1")
    void setTotalCost(Long orderId, BigDecimal totalCost);
}
