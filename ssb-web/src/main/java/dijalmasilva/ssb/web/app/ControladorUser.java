/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.web.app;

import dijalmasilva.ssb.core.services.ServiceUser;
import dijalmasilva.ssb.entidades.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    
    @RequestMapping("/otherUser")
    public String otherUser(HttpServletRequest req){
        return "otherUser";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(String login, String senha, HttpServletRequest req) {
        Usuario user = null;
        user = serviceUser.loginEmail(login, senha);
        if (user == null) {
            user = serviceUser.loginUsername(login, senha);

            if (user == null) {
                return "erro/login";
            }
        }
        req.getSession().setAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String newUser(Usuario usuario, HttpServletRequest req) {
        Usuario user = serviceUser.salvarUsuario(usuario);
        if (user == null) {
            req.setAttribute("result", "Não foi possível criar a conta, verifique se todos os campos foram"
                    + " preenchidos corretamente!");
        }else{
            req.setAttribute("result", "Usuário cadastrado com sucesso."
                    + "\n Faça login e aproveite!");
        }
        
        return "login";
    }

    @RequestMapping("/cancel")
    public void cancelUser(Long id, HttpServletResponse res) throws IOException {
        serviceUser.desativarConta(id);
        res.sendRedirect("/home");
    }

    @RequestMapping(value = {"/update"})
    public String atualizarPerfil(Usuario u, HttpServletRequest req) {
        Usuario user = serviceUser.atualizarPerfil(u);

        if (user == null) {
            return "erro/atualizarPerfil";
        }

        return "";
    }

    @RequestMapping(value = {"/addFriend"}, method = RequestMethod.POST)
    public String adicionarAmigo(Long id, Long amigo, HttpServletRequest req) {
        Usuario user = serviceUser.adicionarAmigo(id, amigo);
        if (user == null) {
            return "erro/amigoNovo";
        }

        return "novoAmigo";
    }

    @RequestMapping(value = {"/removeFriend"}, method = RequestMethod.POST)
    public String removerAmigo(Long id, Long amigo, HttpServletRequest req) {
        Usuario user = serviceUser.removerAmigo(id, amigo);
        if (user == null) {
            return "erro/removerAmigo";
        }

        return "removerAmigo";
    }

    @RequestMapping(value = {"/search={email}"}, method = RequestMethod.GET)
    public String buscarPorEmail(@PathVariable("email") String email, HttpServletRequest req) {
        List<Usuario> usuarios = serviceUser.buscarUsuariosPorEmail(email);
        req.setAttribute("usuariosEncontrados", usuarios);

        return "busca";
    }

    @RequestMapping(value = {"/search={username}"}, method = RequestMethod.GET)
    public String buscarPorUsername(@PathVariable("username") String username, HttpServletRequest req) {
        List<Usuario> usuarios = serviceUser.buscarUsuariosPorUsername(username);
        req.setAttribute("usuariosEncontrados", usuarios);

        return "busca";
    }

    @RequestMapping("/otherUsers")
    public String listarUsuarios(HttpServletRequest req) {
        List<Usuario> usuarios = serviceUser.listarTodos();
        req.setAttribute("todosusuarios", usuarios);

        return "listartodos";
    }

    @RequestMapping("/image/{id}")
    public void carregaImagem(@PathVariable Long id, HttpServletResponse resp) {
        ServletOutputStream out = null;
        try {
            Usuario usuario = serviceUser.findById(id);
            out = resp.getOutputStream();
            out.write(usuario.getFoto());
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
