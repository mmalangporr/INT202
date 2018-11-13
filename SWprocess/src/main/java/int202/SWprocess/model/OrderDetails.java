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
@Table(name = "orderdetails")
public class OrderDetails extends SerializableSerializer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderDetailsId;

    @NotBlank
    private long orderId;
    
    @NotBlank
    private long productId;
    
    private double quantity;

    public long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "orderDetailsId=" + orderDetailsId + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + '}';
    }
    
    
}
