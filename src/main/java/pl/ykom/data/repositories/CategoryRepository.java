package pl.ykom.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ykom.data.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
