package pl.ykom.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ykom.data.model.Category;
import pl.ykom.data.model.Product;
import pl.ykom.data.repositories.ProductRepository;
import pl.ykom.dto.ProductDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProduct(Long id) {

        return buildProductDTO(productRepository.getOne(id));
    }

    public List<ProductDTO> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::buildProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProducts(String category) {

        return productRepository.findAllByCategory_CategoryName(category)
                .stream()
                .map(this::buildProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO buildProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setPrize(product.getPrice());
        productDTO.setCategoryName(product.getCategory().getCategoryName());
        productDTO.setDescription(product.getDescription());
        productDTO.setWarehouseQuantity(product.getWarehouseQuantity());

        return productDTO;
    }
}
