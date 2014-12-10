
package com.ieah.controller;

import com.ieah.model.DAOMuebleImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")

public class ControladorMueble {
    
    @RequestMapping(value="/mueble", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    
    public @ResponseBody String mueble() throws Exception{
        
        DAOMuebleImpl mu = new DAOMuebleImpl();
        
        String mueble = mu.obtenerTodos();
        return mueble;
    }
    
    
    @RequestMapping(value="/mueble/{id}", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String artId(@PathVariable Integer id)throws Exception{
        DAOMuebleImpl mu = new DAOMuebleImpl();
    
        return mu.obtenerId(id);
    }
    
   @RequestMapping(value="/mueble/nombre/{nombre}", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String artNom(@PathVariable String nombre)throws Exception{
        DAOMuebleImpl mu new DAOMuebleImpl();
    
        return mu.obtenerNombre(nombre);
    }
    
}
