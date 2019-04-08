package pl.ykom.dto;

import lombok.Data;
import pl.ykom.data.model.Order;

import java.util.Set;

@Data
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String postcode;
    private String city;
    private Set<Order> orders;

    public UserDTO() {
    }

    private UserDTO(Builder builder) {
        setUserId(builder.userId);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setLogin(builder.login);
        setEmail(builder.email);
        setPassword(builder.password);
        setPhoneNumber(builder.phoneNumber);
        setAddress(builder.address);
        setPostcode(builder.postcode);
        setCity(builder.city);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    private static final class Builder {
        private Long userId;
        private String firstName;
        private String lastName;
        private String login;
        private String email;
        private String password;
        private String phoneNumber;
        private String address;
        private String postcode;
        private String city;
        private Set<Order> orders;

        private Builder(){}

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = "{noop}" + password;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder orders(Set<Order> orders) {
            this.orders = orders;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }

    }
}