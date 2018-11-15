/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWProcess.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author Kittisak
 */

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String homePage(Model model) {
        String hello = "Hello Theme";
        model.addAttribute("fifa",hello);
        return "test";
        
    }
}
