package pl.ykom.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ykom.data.model.Category;
import pl.ykom.data.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory_CategoryName(String category);

    @Modifying
    @Query("UPDATE Product p SET p.warehouseQuantity=?2 WHERE p.productId=?1")
    void updateWarehouseQuantity(Long productId, Long newQuantity);
}
