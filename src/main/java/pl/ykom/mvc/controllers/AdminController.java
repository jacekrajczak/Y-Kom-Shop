package pl.ykom.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ykom.core.services.OrderService;
import pl.ykom.core.services.ProductService;
import pl.ykom.core.services.UserService;
import pl.ykom.data.model.Order;
import pl.ykom.dto.ProductDTO;
import pl.ykom.dto.UserDTO;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private OrderService orderService;
    private UserService userService;
    private ProductService productService;

    @GetMapping
    public String getAdminPanelPage(Model model){
        Order order = new Order();
        model.addAttribute("", order);
        return "/admin/admin-panel";
    }

    @Autowired
    public AdminController(OrderService orderService, UserService userService, ProductService productService) {
        this.orderService = orderService;
        this.userService = userService;
        this.productService = productService;
    }



    @RequestMapping("/add/product")
    private String addProduct(String name, BigDecimal prize, String categoryName, String description, Long warehouseQuantity){

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCategoryName(categoryName);
        productDTO.setName(name);
        productDTO.setPrize(prize);
        productDTO.setDescription(description);
        productDTO.setWarehouseQuantity(warehouseQuantity);

        return "/admin/admin-panel-new-product-added";
    }
//
//    @PostMapping
//    private String deleteProduct(){
//        return "";
//    }
//
//    @GetMapping
//    public String prepareAdminPanel(){
//        return "";
//    }
//
//    @GetMapping
//    private String manageOrders(){
//        return "";
//    }
//
////    @PostMapping
////    public String editUser(){
////        return ;
////    }
}