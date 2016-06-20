/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.web.controladores;

import dijalmasilva.ssb.core.services.ServiceUser;
import dijalmasilva.ssb.entidades.Usuario;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        req.getSession().setAttribute("user", user);
        return "home";
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String newUser(Usuario usuario){
        Usuario user = serviceUser.salvarUsuario(usuario);
        if (user == null)
            return "erroNewUser";
        
        return "login";
    }
    
    @RequestMapping("/cancel")
    public void cancelUser(Long id, HttpServletResponse res) throws IOException{
        serviceUser.desativarConta(id);
        res.sendRedirect("/home");
    }
}
