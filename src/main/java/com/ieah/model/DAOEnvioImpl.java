/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieah.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DAOEnvioImpl {
    public String obtenerTodos() throws Exception{
        
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        
        Criteria cri = sesion.createCriteria(Envio.class);
        ArrayList<Envio> muebles = (ArrayList<Envio>)cri.list();
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, ArrayList<Envio>> singletonMap = Collections.singletonMap("envio", muebles);
        
        tranza.commit();
        sesion.close();
        System.out.println(mapper.writeValueAsString(singletonMap));
        return mapper.writeValueAsString(singletonMap);        
    }
        public String obtenerId(Integer id) throws Exception{
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        
        Criteria cri = sesion.createCriteria(Envio.class).add(Restrictions.idEq(id));
        Envio envio = (Envio)cri.uniqueResult();
    
        ObjectMapper mapper = new ObjectMapper();
        tranza.commit();
        sesion.close();
        
        return mapper.writeValueAsString(envio);
        
    }
        
}


