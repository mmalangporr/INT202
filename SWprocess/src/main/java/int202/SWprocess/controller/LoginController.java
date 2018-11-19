/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWprocess.controller;

import int202.SWprocess.service.ProductService;
import int202.SWprocess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    private ProductService productService;

    @GetMapping("/")
    public String loadPage() {
        return "login";
    }

    @PostMapping("/login")
    public String homePage(ModelMap model) {
        model.addAttribute("allProduct", productService.getAllProducts());
        return "index";
    }

}
