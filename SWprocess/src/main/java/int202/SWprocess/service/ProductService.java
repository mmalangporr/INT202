/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWprocess.service;

import int202.SWProcess.model.Product;
import int202.SWprocess.repository.ProductRepository;
import int202.SWprocess.repository.ProductTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kittisak
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private ProductTypeRepository productTypeRepo;
    
    public List<Product> getAllProducts(){
        List<Product> p = productRepo.findAll();
        return p;
    }
    
    public void setProduct(Product product){
       productRepo.save(product);
    }

}
