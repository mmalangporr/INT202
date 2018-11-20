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
import int202.SWProcess.model.Products;
import int202.SWprocess.service.OrderService;
import int202.SWprocess.service.ProductService;
import int202.SWprocess.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    
    
    @GetMapping("/orders")
    public String getOrders(){
        return "orders";
    }
    
    @PostMapping("/omiseInProgess")
    public String test1(HttpServletRequest request,ModelMap model) throws ClientException, IOException, OmiseException {
        Client client = new Client("pkey_test_5dyabo9iygs2rte1srz", "skey_test_5dyabo9jig632rot8ac");
        String a = request.getParameter("description");
        long amount = (long) (Double.parseDouble(a) * 100);
      //  String productId = request.getParameter("productId");
        String totalprice = request.getParameter("total_price");
        String productId = request.getParameter("product_Id");
        String fullname = request.getParameter("full_name");
        String userId = request.getParameter("userId");
        String orderId = request.getParameter("orderId");
        System.out.println(fullname);
        //String user = request.getParameter("userId");
        Users user = new Users();
        user.setUserId(Long.parseLong(userId));
        
        Orders order = new Orders();
        order.setOrderId(Long.parseLong(orderId));
        
        Products product = new Products();
        product.setProductId(Long.parseLong(productId));
        
        System.out.println(user.getUserId());
        System.out.println(totalprice);
        System.out.println(orderId);
        System.out.println(productId);
        
        model.addAttribute("total_price", totalprice);
        model.addAttribute("userDetail", userService.getById(user.getUserId()));
        model.addAttribute("orderDetail", orderService.getById(order.getOrderId()));
        model.addAttribute("productDetail", productService.getProductById(product.getProductId()));
        try {
            Charge charge = client.charges().create(new Charge.Create()
                    .amount(amount)
                    .currency("THB")
                    .card(request.getParameter("omiseToken")));
            System.out.println("created charge: " + charge.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "orders";
    }
    
    /*@GetMapping("/omiseSuccess")
    public String omisePayment(ModelMap model,HttpServletRequest request) {
        String productId = request.getParameter("productId");
        String totalprice = request.getParameter("total_price");
        int id = Integer.parseInt(productId);
        System.out.println(id+" testttttttttttttttttttttttttttrtt");
        model.addAttribute("total_price", totalprice);
//        model.addAttribute("shippingDetail", productService.getProductById(id));
        return "omiseSuccess";
    }*/
    
//    @RequestMapping("/paymentsize")
//    public char productsize(@RequestParam char size){
//        return size;
//    }
//    
//    @RequestMapping("/paymentquantity")
//    public int productquantity(@RequestParam int quantity){
//        return quantity;
//    }
    
    
    @GetMapping("/payment")
    public String bill(ModelMap modelmap, HttpServletRequest request) {

        String fullname = request.getParameter("full_name");
//      String email = request.getParameter("email");
//      String phone = request.getParameter("phone_number");   
        String address = request.getParameter("address");
        String totalPrice = request.getParameter("total_price");
//        Double sentTotalprice = Double.parseDouble(totalPrice);
        String ProductId = request.getParameter("product_Id");
      String quantity = request.getParameter("quantity");
      String s = request.getParameter("size");
      char size = s.charAt(0);
        System.out.println(totalPrice);
        Users user = new Users();
//        user.setUserId(1);
        user.setName(fullname);
        user.setEmail("test@hotmail.com");
        user.setPhoneNumber("1234567890");
        user.setPassword("1234");
        user.setUserName("Test");
        userService.save(user);
        System.out.println("save user successs test");
        
        Orders order = new Orders();
//        order.setOrderId(1);
        order.setQuantity(Integer.parseInt(quantity));
        order.setSize(size);
        order.setAddress(address);
        order.setTotalPrice(Double.parseDouble(totalPrice));
        order.setUserId(user);
        Products p = new Products();
        p.setProductId(Long.parseLong(ProductId));
        order.setProductId(p);
        orderService.save(order);
        
        modelmap.addAttribute("total_price", totalPrice);
        modelmap.addAttribute("full_name", fullname);
        modelmap.addAttribute("address", address);
        modelmap.addAttribute("product_Id", ProductId);
        modelmap.addAttribute("quantity", quantity);
        modelmap.addAttribute("size", size);
        modelmap.addAttribute("user", userService.getById(user.getUserId()));
        modelmap.addAttribute("orderId", order.getOrderId());

        System.out.println("save order success test");

        return "payment";
    }
    
       
    
     @RequestMapping("/order")
    public long getOrderDetail(@RequestParam int orderId) {
        orderService.getById(orderId);
        return orderId;
    }
    
    @GetMapping("/order/{id}")
    public String orderDetail(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("orderDetail", orderService.getById(id));
        model.addAttribute("products", productService.getProductById(id));
        return "test";
    }


}

