/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerHome {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/newUser")
    public String newUser(){
        return "newUser";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
