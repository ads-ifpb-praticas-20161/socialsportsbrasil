/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.web.controladores;

import dijalmasilva.ssb.core.services.ServiceUser;
import dijalmasilva.ssb.entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dijalma
 */
@Controller
@RequestMapping("/user")
public class ControladorUser {
    
    private final ServiceUser serviceUser = new ServiceUser();
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(String login, String senha, HttpServletRequest req){
        Usuario user = null;
        user = serviceUser.loginEmail(login, senha);
        if (user == null){
            user = serviceUser.loginUsername(login, senha);
            
            if (user == null){
                return "erroLogin";
            }
        }
        
        return "home";
    }
}
