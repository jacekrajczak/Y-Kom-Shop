package pl.ykom.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ykom.core.services.ProductService;
import pl.ykom.data.model.Product;
import pl.ykom.dto.ProductDTO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    private ProductService productService;

    @Autowired
    public BasketController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getBasketPage(HttpSession session, Model model) {

        Enumeration<String> attributeNames = session.getAttributeNames();

        List<ProductDTO> productDTOList = new ArrayList<>();

        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            ProductDTO productDTO = (ProductDTO) session.getAttribute(attributeName);

            System.out.println(productDTO);

            productDTOList.add(productDTO);
        }

        model.addAttribute("products",productDTOList);

        return "basket";
    }

    @PostMapping("/add")
    public String addToBasket(Long productId, HttpSession session) {

        ProductDTO productDTO = productService.getProduct(productId);

        System.out.println(productDTO);

        String attributeName = productDTO.getName() + "-" + productDTO.getId();

        ProductDTO attribute = (ProductDTO) session.getAttribute(attributeName);

        if (attribute != null) {
            attribute.setBasketQuantity(attribute.getBasketQuantity() + 1);
        } else {
            productDTO.setBasketQuantity(1);
            session.setAttribute(attributeName, productDTO);
        }

        return "basket-confirm";
    }

    @PostMapping("/order")
    public String confirmOrder(HttpSession session, Model model) {

        Enumeration<String> attributeNames = session.getAttributeNames();

        List<ProductDTO> productDTOList = new ArrayList<>();

        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            ProductDTO productDTO = (ProductDTO) session.getAttribute(attributeName);

            System.out.println(productDTO);

            productDTOList.add(productDTO);
        }



        return "order-confirm";
    }


}
