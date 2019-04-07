package pl.ykom.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ykom.data.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
