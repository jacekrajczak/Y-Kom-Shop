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
import java.math.BigDecimal;
import java.util.*;

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

        BigDecimal totalPrice = getBasketTotalPrice(basket);

        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("products", basket);

        return "basket";
    }

    @PostMapping("/add")
    public String addToBasket(Long productId, HttpSession session) {

        ProductDTO productDTO = productService.getProduct(productId);

        List<ProductDTO> basket = (List<ProductDTO>) session.getAttribute(basketAttributeName);

        if (basket == null) {
            basket = new ArrayList<>();
        }

        boolean isInside = false;

        for (ProductDTO dto : basket) {

            if (dto.equals(productDTO)) {
                dto.setBasketQuantity(dto.getBasketQuantity() + 1);
                isInside = true;
                break;
            }
        }

        if (!isInside) {
            productDTO.setBasketQuantity(1);
            basket.add(productDTO);
        }

        session.setAttribute(basketAttributeName, basket);

        return "basket-confirm";
    }

    @GetMapping("/order")
    public String confirmOrder(HttpSession session, Model model) {

        List<ProductDTO> basket = (List<ProductDTO>) session.getAttribute(basketAttributeName);

        Long userId = (Long) session.getAttribute("userId");

        List<ProductDTO> productsWithChangedQuantity = new ArrayList<>();

        boolean isQuantityValid = true;

        for (ProductDTO productDTO : basket) {
            if (productDTO.getBasketQuantity() > productDTO.getWarehouseQuantity()) {
                isQuantityValid = false;

                // ustawiam ilość na maksymalnie możliwą
                productDTO.setBasketQuantity(productDTO.getWarehouseQuantity());

                productsWithChangedQuantity.add(productDTO);
            }
        }

        if (isQuantityValid) {
            Long orderId = orderService.saveOrder(userId);
            orderProductService.addOrderProductsAndLowerWarehouseQuantity(basket, orderId);

            session.removeAttribute(basketAttributeName);

            return "order-confirm";

        } else {

            BigDecimal totalPrice = getBasketTotalPrice(basket);

            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("products", basket);
            model.addAttribute("productsWithChangedQuantity", productsWithChangedQuantity);

            return "basket-changed";
        }
    }

    private BigDecimal getBasketTotalPrice(List<ProductDTO> basket) {
        BigDecimal totalPrice = new BigDecimal(0);

        for (ProductDTO productDTO : basket) {
            totalPrice = totalPrice.add(productDTO.getPrize()
                    .multiply(BigDecimal.valueOf(productDTO.getBasketQuantity())));
        }
        return totalPrice;
    }

}
