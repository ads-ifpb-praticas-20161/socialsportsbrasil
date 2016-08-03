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
import java.util.ArrayList;
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
        System.out.println(user);
        if (user == null) {
            req.setAttribute("result", "Nome de usuário ou senha inválidos.");
            return "login";
        } else {
            req.getSession().setAttribute("user", user);
            req.setAttribute("result", "Bem vindo!");
            return "home";
        }
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

    @RequestMapping(value = {"/search/{nome}"})
    public void buscarUsuario(@PathVariable String nome, HttpServletRequest req) {

        List<Usuario> usuarios = serviceUser.buscarUsuarios(nome);
        System.out.println(usuarios.size());
        if(usuarios.isEmpty())
        req.getSession().setAttribute("usuariosEncontrados", usuarios);
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

        usuario.setDataDeNascimento(data);
        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        usuario.setSenha(u.getSenha());
        usuario.setSobrenome(u.getSobrenome());
        usuario.setUsername(u.getUsername());

        return usuario;
    }
}
