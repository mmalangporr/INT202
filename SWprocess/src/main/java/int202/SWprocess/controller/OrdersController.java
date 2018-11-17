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
import int202.SWprocess.service.OrderService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kittisak
 */
@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    /*@GetMapping("/payment")
    public String getOrders() {
        return "payment";
    }*/

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

}
