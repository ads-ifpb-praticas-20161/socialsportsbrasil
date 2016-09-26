/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.interceptors;

import dijalmasilva.entidades.Usuario;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author dijalma
 */
public class TransactionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Usuario u = (Usuario) request.getSession().getAttribute("user");

        if (u == null) {
            response.sendRedirect("/home");
            return false;
        }

        return true;

//        if (request.getSession().getAttribute("usuarioLogado") == null){
//            response.sendRedirect("/index");
//            return false;
//        }
//        
//        return true;
    }

}
