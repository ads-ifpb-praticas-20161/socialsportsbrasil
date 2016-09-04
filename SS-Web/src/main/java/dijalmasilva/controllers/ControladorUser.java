/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.controllers;

import dijalmasilva.core.service.UsuarioService;
import dijalmasilva.entidades.Usuario;
import dijalmasilva.form.UsuarioForm;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dijalma
 */
@Controller
@RequestMapping("/user")
public class ControladorUser {

    @Inject
    private UsuarioService serviceUser;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/otherUser/{id}")
    public String otherUser(@PathVariable Long id, HttpServletRequest req) {
        Usuario outroUsuario = serviceUser.findById(id);
        req.setAttribute("outroUsuario", outroUsuario);
        return "otherUser";
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/home");
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(String login, String senha, HttpServletRequest req) {
        Usuario user = null;
        user = serviceUser.login(login, senha);
        if (user == null) {
            req.setAttribute("result", "Nome de usuário ou senha inválidos.");
            return "index";
        } else {
            req.getSession().setAttribute("user", user);
            req.setAttribute("result", "Bem vindo!");
        }
        return "home";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String newUser(UsuarioForm u, HttpServletRequest req, Date dataDeNascimento, MultipartFile foto) throws IOException {
        Usuario usuario = this.convertToUsuario(u, dataDeNascimento.toLocalDate());
        usuario.setConta("ATIVADA");
        if (foto.getSize() != 0) {
            usuario.setFoto(foto.getBytes());
        }
        Usuario user = serviceUser.salvarUsuario(usuario);
        if (user == null) {
            req.setAttribute("result", "Não foi possível criar a conta, verifique se todos os campos foram"
                    + " preenchidos corretamente!");
        } else {
            req.setAttribute("result", "Usuário cadastrado com sucesso."
                    + "\n Faça login e aproveite!");
        }

        return "/index";
    }

    @RequestMapping("/disable/{id}")
    public String cancelUser(@PathVariable Long id, HttpServletRequest req) throws IOException {
        serviceUser.desativarConta(id);
        req.getSession().invalidate();
        req.setAttribute("result", "Sua conta foi desativada.");
        
        return "redirect:/home";
    }

    @RequestMapping(value = {"/update"})
    public String atualizarPerfil(UsuarioForm u, HttpServletRequest req, MultipartFile foto) throws IOException {
        Usuario usuario = this.convertToUsuario(u, null);
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        atualizaUsuario(user, usuario);
        if (foto.getSize() != 0) {
            user.setFoto(foto.getBytes());
        }
        user = serviceUser.atualizarPerfil(user);
        if (user == null) {
            req.setAttribute("result", "Não foi possível atualizar seu perfil, verifique se todos os campos foram"
                    + " preenchidos corretamente!");
        } else {
            req.setAttribute("result", "Perfil atualizado com sucesso.");
        }

        return "redirect:/user/home";
    }

    @RequestMapping(value = {"/follow/{id}"}, method = RequestMethod.GET)
    public String adicionarAmigo(@PathVariable Long id, HttpServletRequest req) {
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        user = serviceUser.adicionarAmigo(user.getId(), id);
        if (user == null) {
            return "erro";
        }else{
            req.getSession().setAttribute("user", user);
        }

        return "redirect:/user/otherUser/"+id;
    }

    @RequestMapping(value = {"/unfollow/{id}"}, method = RequestMethod.GET)
    public String removerAmigo(@PathVariable Long id, HttpServletRequest req) {
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        user = serviceUser.removerAmigo(user.getId(), id);
        if (user == null) {
            return "erro";
        }else{
            req.getSession().setAttribute("user", user);
        }

        return "redirect:/user/otherUser/"+id;
    }

    @RequestMapping(value = {"/searchUsers"})
    public String buscarUsuario(String nome, HttpServletRequest req) {
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        List<Usuario> usuarios = serviceUser.buscarUsuariosComIdDiferenteAndNaoDesativada(nome, user.getId());
        if (usuarios.isEmpty()) {
            req.setAttribute("result", "Nenhum usuário encontrado com esse nome.");
        }

        req.getSession().setAttribute("usuariosEncontrados", usuarios);

        return "usersfind";
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

    private Usuario convertToUsuario(UsuarioForm u, LocalDate data) {
        Usuario usuario = new Usuario();
        if (data != null) {
            usuario.setDataDeNascimento(data);
        }
        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        usuario.setSenha(u.getSenha());
        usuario.setSobrenome(u.getSobrenome());
        usuario.setUsername(u.getUsername());

        return usuario;
    }
    
    @RequestMapping("/editProfile")
    public String editarPerfil(){
        return "editProfile";
    }
    
    @RequestMapping("/following")
    public String seguindo(){
        return "following";
    }
    
    private void atualizaUsuario(Usuario user, Usuario usuarioNovo){
        user.setNome(usuarioNovo.getNome());
        user.setSobrenome(usuarioNovo.getSobrenome());
        user.setSenha(usuarioNovo.getSenha());
    }
}
