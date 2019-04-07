package pl.ykom.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ykom.core.services.OrderProductService;
import pl.ykom.core.services.OrderService;
import pl.ykom.core.services.ProductService;
import pl.ykom.dto.ProductDTO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    private ProductService productService;
    private OrderService orderService;
    private OrderProductService orderProductService;

    private final String basketAttributeName = "basket";

    @Autowired
    public BasketController(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public String getBasketPage(HttpSession session, Model model) {

        List<ProductDTO> basket = (List<ProductDTO>) session.getAttribute(basketAttributeName);

        model.addAttribute("products", basket);

        return "basket";
    }

    @PostMapping("/add")
    public String addToBasket(Long productId, HttpSession session) {

        ProductDTO productDTO = productService.getProduct(productId);

        List<ProductDTO> basket = (List<ProductDTO>) session.getAttribute(basketAttributeName);

        if (basket == null) {
            basket = new ArrayList<>();
            session.setAttribute(basketAttributeName, basket);
        }

        if (basket.contains(productDTO)) {
            productDTO.setBasketQuantity(productDTO.getBasketQuantity() + 1);
        } else {
            productDTO.setBasketQuantity(1);
            basket.add(productDTO);
        }

        session.setAttribute(basketAttributeName,basket);

        return "basket-confirm";
    }

    @GetMapping("/order")
    public String confirmOrder(HttpSession session, Model model) {

        List<ProductDTO> basket = (List<ProductDTO>) session.getAttribute(basketAttributeName);

        Long userId = (Long) session.getAttribute("userId");

        Long orderId = orderService.saveOrder(userId);
        orderProductService.addOrderProducts(basket, orderId);

        session.removeAttribute(basketAttributeName);

        return "order-confirm";
    }


}
