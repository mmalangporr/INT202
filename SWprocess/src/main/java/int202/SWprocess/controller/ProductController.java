/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWProcess.controller;

import int202.SWProcess.model.Product;
import int202.SWprocess.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kittisak
 */
@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;
       
    @GetMapping("/products")
    public List<Product> getProduct(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable long id){
        return "this is product"+id;
    }
    
}
