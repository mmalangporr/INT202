/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWProcess.model;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Kittisak
 */
@Entity
@Table(name = "products")
public class Product extends SerializableSerializer{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    
    @NotBlank
    private String productName;
    
    @NotBlank
    private double productPrice;
    
    @NotBlank
    private double productStock;
    
    @NotBlank
    private String productSize;
    
    @NotBlank
    private String productImage;
    
    @NotBlank
    private String productDetails;
    
    @NotBlank
    private long productTypeId;
    
    @NotBlank
    private long sellerId;

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }
    
    

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductStock() {
        return productStock;
    }

    public void setProductStock(double productStock) {
        this.productStock = productStock;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", productStock=" + productStock + ", productSize=" + productSize + ", productImage=" + productImage + ", productDetails=" + productDetails + ", productTypeId=" + productTypeId + ", sellerId=" + sellerId + '}';
    }

    

}
