/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWprocess.service;

import int202.SWProcess.model.Product;
import int202.SWprocess.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kittisak
 */
@Service
public class ProductService {
    
    private Product[] cart;
    private int itemCount;
    private double totalPrice;
    private int capacity;
      
    @Autowired
    private ProductRepository productRepo;
    
//    public List<Product> getAllProducts(){
//        List<Product> p = productRepo.findAll();
//        return p;
//    }
    
    
//    public List<Product> searchResult(String search){
//        try{
//            return (List<Product>) getAllSearch(search);
//        }
//        catch(Exception ex){
//            return getAllProducts();
//        }
//    }
    
    public List<Product> getAllProducts(){
        List<Product> p = productRepo.findAll();
        return p;
    }
    
<<<<<<< Updated upstream
    public Product getProductById(){
        Product prod = productRepo.getOne(Long.MIN_VALUE);
        return prod;
    }
    
    public String test(){
        test = "Kuy";
        return test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
=======
    
>>>>>>> Stashed changes
    
    public void setProduct(Product product){
       productRepo.save(product);
    }
    
    public ProductService(){
        capacity = 5;
        cart = new Product[capacity];
        itemCount = 0;
        totalPrice = 0.0;
    }
    
<<<<<<< Updated upstream
=======
    public List<Product> getProductById(int productId){
        List<Product> p = productRepo.findByProductId(productId);
        return p;
    }
    
    public List<Product> getProductByName(String productName){
        List<Product> p2 = productRepo.findByProductNameLike("%"+productName+"%");
        return p2;
    }
    
    public List<Product> getAllSearch(String search){
        try{
            int id = Integer.parseInt(search);
            return getProductById(id);
        }
        catch(Exception ex){
            return getProductByName(search);
        }
    }
    
>>>>>>> Stashed changes
//    public void addToCart(String ProductName, double price){
//        
//        Product temp = new Product(ProductName, price);
//        totalPrice += (price * quantity);
//        itemCount += quantity;
//        cart[itemCount] = temp;
//        if(itemCount == capacity){
//            increaseSizeCart();
//        }
//    }
        
    private void increaseSizeCart(){
        Product[] temp = new Product[capacity+3];
        for(int i=0; i < capacity; i++){
            temp[i] = cart[i];
        }
        cart = temp;
        temp = null;
        capacity = cart.length;
    }
    
        
    

}
