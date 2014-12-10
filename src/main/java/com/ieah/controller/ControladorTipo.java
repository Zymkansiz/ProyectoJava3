

package com.ieah.controller;

import com.ieah.model.DAOTipoImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")

public class ControladorTipo {
    
    @RequestMapping(value = "/tipo", method = RequestMethod.GET, headers = {"Accept=Application/json"})
   public @ResponseBody String tipo() throws Exception{ 
       DAOTipoImpl ti = new DAOTipoImpl();
        
        return ti.obtenerTodos();
    }
    
}
