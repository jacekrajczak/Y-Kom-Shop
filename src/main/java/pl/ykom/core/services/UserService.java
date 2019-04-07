package pl.ykom.core.services;

import org.springframework.stereotype.Service;
import pl.ykom.data.model.Order;
import pl.ykom.data.model.User;
import pl.ykom.data.repositories.UserRepository;
import pl.ykom.dto.UserDTO;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUser(UserDTO userDTO){
        User user = buildUser(userDTO);
        userRepository.save(user);
    }

    private User buildUser(UserDTO userDTO){
        User user = new User();

        user.setUserId(userDTO.getUserId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAddress(userDTO.getAddress());
        user.setPostcode(userDTO.getPostcode());
        user.setCity(userDTO.getCity());

        return user;
    }
}
