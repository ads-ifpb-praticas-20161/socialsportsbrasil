/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.ssb.web.app;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@SpringBootApplication
@Controller
public class AppConfig {

    @RequestMapping("/")
    public void init(HttpServletResponse res) throws IOException{
        res.sendRedirect("/home");
    }
    
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
