package pl.ykom.mvc.controllers;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.ykom.core.services.CategoryService;
import pl.ykom.core.services.ProductService;
import pl.ykom.data.model.Category;
import pl.ykom.data.model.Product;
import pl.ykom.dto.CategoryDTO;
import pl.ykom.dto.ProductDTO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public HomePageController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getHomePage(Model model) {

        List<ProductDTO> products = productService.getAllProducts();
        model.addAttribute("products", products);

        List<CategoryDTO> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        return "home";
    }

    @GetMapping(path = "category/{category}")
    public String getHomePage(Model model, @PathVariable String category) {

        List<ProductDTO> products = productService.getProducts(category);
        model.addAttribute("products", products);

        List<CategoryDTO> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        return "home";
    }

    @PostMapping("search")
    public String searchItem(String search, Model model) {

        List<ProductDTO> allProducts = productService.getAllProducts();

        List<ProductDTO> displayedProducts = new ArrayList<>();

        for (ProductDTO productDTO : allProducts) {
            String[] words = productDTO.getName().split(" ");
            for (String word : words) {
                if (search.equalsIgnoreCase(word)) {
                    displayedProducts.add(productDTO);
                }
            }
        }

        model.addAttribute("products", displayedProducts);

        List<CategoryDTO> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        return "home";
    }

    @GetMapping("testlog")
    @ResponseBody
    public String testLog(HttpSession session) {

        session.setAttribute("userId", 1L);

        return "Zalogowano";
    }
}
