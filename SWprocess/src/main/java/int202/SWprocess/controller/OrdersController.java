/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWProcess.controller;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;
import int202.SWProcess.model.Orders;
import int202.SWProcess.model.Users;
import int202.SWProcess.model.Product;
import int202.SWprocess.service.OrderService;
import int202.SWprocess.service.ProductService;
import int202.SWprocess.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kittisak
 */
@Controller
public class OrdersController {

    @Autowired
    OrderService orderService;


    /*@GetMapping("/payment")
    public String getOrders() {
        return "payment";
    }*/

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

//    @GetMapping("/payment")
//    public String getOrders() {
//        return "payment";
//    }


    @GetMapping("/shipping")
    public String getShipping() {
        return "shipping";
    }

    @GetMapping("/omiseInProgess")
    public String test1(HttpServletRequest request) throws ClientException, IOException, OmiseException {
        Client client = new Client("pkey_test_5dyabo9iygs2rte1srz","skey_test_5dyabo9jig632rot8ac");
        String a = request.getParameter("description");
        long amount = (long)(Double.parseDouble(a)*100);
        try {
            Charge charge = client.charges().create(new Charge.Create()
                    .amount(amount)
                    .currency("THB")
                    .card(request.getParameter("omiseToken")));
            System.out.println("created charge: " + charge.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "omiseSuccess"; 
    }
    
    
    @GetMapping("/payment")
    public String bill(ModelMap modelmap, HttpServletRequest request){
        
        String fullname = request.getParameter("full_name");
//      String email = request.getParameter("email");
//      String phone = request.getParameter("phone_number");   
        String address = request.getParameter("address");
        String totalPrice = request.getParameter("total_price");
//      String quantity = request.getParameter("quantity");
//      String size = request.getParameter("size");
        
        Users user = new Users();
        user.setUserId(1);
        user.setFullName(fullname);
        user.setEmail("test@hotmail.com");
        user.setPhoneNumber("1234567890");
        user.setPassword("1234");
        user.setUserName("Test");
        userService.save(user);
        System.out.println("save user successs test");
        
        Orders order = new Orders();
        order.setOrderId(3);
        order.setQuantity(1);
        order.setSize('s');
        order.setAddress(address);
        order.setTotalPrice(Double.parseDouble(totalPrice));
        orderService.save(order);
        
        System.out.println("save order success test");
 
        return "Shipping";
    }

}
