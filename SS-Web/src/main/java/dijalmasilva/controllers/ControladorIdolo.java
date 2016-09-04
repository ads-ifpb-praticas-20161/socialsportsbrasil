/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.controllers;

import dijalmasilva.core.service.IdoloService;
import dijalmasilva.entidades.Idolo;
import dijalmasilva.form.IdoloForm;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
@RequestMapping("/idolo")
public class ControladorIdolo {

    @Inject
    private IdoloService serviceIdolo;
    
    @RequestMapping("/new")
    public String newIdolo(IdoloForm i, HttpServletRequest req, MultipartFile foto) throws IOException {
        Idolo idolo = convertToIdolo(i);
        
        if (foto.getSize() != 0){
            idolo.setFoto(foto.getBytes());
        }
        
        Idolo newIdolo = serviceIdolo.salvar(idolo);
        
        if (newIdolo == null){
            req.setAttribute("result", "Não foi possível cadastrar ídolo.");
        }else{
            req.setAttribute("result", "Ídolo cadastrado com sucesso.");
        }
        
        return "newGroup";
    }
    
    @RequestMapping(value = "/{nome}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Idolo>> buscarIdolosPorNome(@PathVariable String nome){
        
        List<Idolo> idolos = serviceIdolo.buscarPorNome(nome);
        
        
//        String result = "";
//        
//        for (Idolo idolo : idolos) {
//            result += "<option data-value=" + idolo.getId() + " value="+idolo.getNome()+"/>\n";
//        }
//        System.out.println(result);
        
        
        return ResponseEntity.accepted().body(idolos);
    }
    
    private Idolo convertToIdolo(IdoloForm i){
        Idolo idolo = new Idolo();
        idolo.setEsporte(i.getEsporte());
        idolo.setNome(i.getNome());
        idolo.setTipo(i.getTipo());
        
        return idolo;
    }
}
