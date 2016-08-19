/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.controllers;

import dijalmasilva.entidades.Idolo;
import dijalmasilva.form.IdoloForm;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
@RequestMapping("/idolo")
public class ControladorIdolo {

    @RequestMapping("/new")
    public @ResponseBody Idolo newIdolo(IdoloForm i, HttpServletRequest req) {
        
        return new Idolo();
    }
}
