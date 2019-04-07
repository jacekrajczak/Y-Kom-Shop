package pl.ykom.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ykom.data.model.OrderProduct;
import pl.ykom.data.model.Product;
import pl.ykom.data.repositories.OrderProductRepository;
import pl.ykom.data.repositories.OrderRepository;
import pl.ykom.data.repositories.ProductRepository;
import pl.ykom.dto.ProductDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderProductService {

    private OrderProductRepository orderProductRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderProductService(OrderProductRepository orderProductRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderProductRepository = orderProductRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void addOrderProductsAndLowerWarehouseQuantity(List<ProductDTO> productDTOList, Long orderId) {

        for (ProductDTO productDTO : productDTOList) {

            if (productDTO.getBasketQuantity() > 0) {

                OrderProduct orderProduct = buildOrderProduct(productDTO, orderId);

                orderProductRepository.save(orderProduct);

                Long productId = orderProduct.getProduct().getProductId();
                Product currentProduct = productRepository.getOne(productId);
                Long newQuantity = currentProduct.getWarehouseQuantity() - productDTO.getBasketQuantity();

                productRepository.updateWarehouseQuantity(productId, newQuantity);
                productRepository.flush();
            }
        }
    }

    private OrderProduct buildOrderProduct(ProductDTO productDTO, Long orderId) {

        OrderProduct orderProduct = new OrderProduct();

        orderProduct.setOrder(orderRepository.getOne(orderId));
        orderProduct.setProduct(productRepository.getOne(productDTO.getId()));
        orderProduct.setQuantity(productDTO.getBasketQuantity());

        return orderProduct;
    }
}
