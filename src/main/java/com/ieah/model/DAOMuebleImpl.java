/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieah.model;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.singletonMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class DAOMuebleImpl {
    
    public String obtenerTodos() throws Exception {
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        
        Criteria cri = sesion.createCriteria(Mueble.class);
        
        ArrayList<Mueble> muebles = (ArrayList<Mueble>)cri.list();
        Map<String, ArrayList<Mueble>> singletonMap = Collections.singletonMap("mueble", muebles);
        ObjectMapper mapper = new ObjectMapper();
        
        tranza.commit();
        sesion.close();
        
        return mapper.writeValueAsString(singletonMap);
    }
    
    public String obtenerId(Integer id) throws Exception{
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        
        Criteria cri = sesion.createCriteria(Mueble.class).add(Restrictions.idEq(id));
        Mueble mueble = (Mueble)cri.uniqueResult();
    
        ObjectMapper mapper = new ObjectMapper();
        tranza.commit();
        sesion.close();
        
        return mapper.writeValueAsString(mueble);
        
    }
    
    public String obtenerNombre(String nombre) throws Exception{
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        
        Criteria cri = sesion.createCriteria(Mueble.class).add(Restrictions.like("nombre", nombre + "%e%"));

        ArrayList<Mueble> muebles = (ArrayList<Mueble>)cri.list();
        ObjectMapper mapper = new ObjectMapper();

        Map<String ,ArrayList<Mueble>> singletonMap = Collections.singletonMap("mueble", muebles);

        tranza.commit();
        sesion.close();
  
        return mapper.writeValueAsString(singletonMap);
    }
   
   }
