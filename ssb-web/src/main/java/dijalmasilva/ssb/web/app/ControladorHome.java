/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.web.app;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dijalma
 */
@Controller
public class ControladorHome {
    
    @RequestMapping("/")
    public String index() throws IOException{
        return "/home";
    }
    
    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
