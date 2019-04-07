package pl.ykom.dto;

import java.math.BigDecimal;

public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal prize;
    private String categoryName;
    private String description;
    private Long warehouseQuantity;

    private int basketQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWarehouseQuantity() {
        return warehouseQuantity;
    }

    public void setWarehouseQuantity(Long warehouseQuantity) {
        this.warehouseQuantity = warehouseQuantity;
    }

    public int getBasketQuantity() {
        return basketQuantity;
    }

    public void setBasketQuantity(int basketQuantity) {
        this.basketQuantity = basketQuantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", warehouseQuantity=" + warehouseQuantity +
                ", basketQuantity=" + basketQuantity +
                '}';
    }
}
