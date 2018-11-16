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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kittisak
 */
@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
//    @GetMapping("/product/{id}")
//    public String getProductById(@PathVariable long id){
//        return "this is product"+id;
//    }
    
    @GetMapping("/index")
    public String getAllProduct(ModelMap model){
        model.addAttribute("allProduct",productService.getAllProducts());
        return "index";
    }
    

//    @RequestMapping("/index")
//    public long getProductDetail(@RequestParam long productId){
//       productService.getProductById(productId);
//       return productId;
//    }
    
    
   
//    @RequestMapping("/index")
//    public String search(@RequestParam String search){
//        productService.getAllSearch(search);
//        return search;
//    }

    @GetMapping("/search")
    public String searchProduct(ModelMap model,@RequestParam String search){
        model.addAttribute("searchProduct",productService.getAllSearch(search));
        return "search";
    }
    
    @RequestMapping("/search")
    public String searchPro(@RequestParam String search){
        productService.getAllSearch(search);
        
        return search;
    }
    
     @RequestMapping("/productdetail")
    public long getProductDetail(@RequestParam long productId){
        productService.getProductById(productId);
        return productId;
    }
   
    @GetMapping("productdetail/{id}")
    public String productDetail(ModelMap model,@PathVariable("id") int id){
        model.addAttribute("productDetail",productService.getProductById(id));
        return "productdetail";
    }

    
}
