

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


public class DAOTipoImpl {
    
    public String obtenerTodos()throws Exception {
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        
        Criteria cri = sesion.createCriteria(Tipo.class);
        ArrayList<Tipo> muebles = (ArrayList<Tipo>)cri.list();
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, ArrayList<Tipo>> singletonMap = Collections.singletonMap("tipo", muebles);
        
        tranza.commit();
        sesion.close();
        System.out.println(mapper.writeValueAsString(singletonMap));
        return mapper.writeValueAsString(singletonMap);
        }
    
    public String obtenerId(Integer id) throws Exception{
        SessionFactory factory = HibernateUtilidades.getSessionFactory();
        Session sesion = factory.openSession();
        Transaction tranza = sesion.beginTransaction();
        
        Criteria cri = sesion.createCriteria(Tipo.class).add(Restrictions.idEq(id));
        Tipo tipo = (Tipo)cri.uniqueResult();
    
        ObjectMapper mapper = new ObjectMapper();
        tranza.commit();
        sesion.close();
        
        return mapper.writeValueAsString(tipo);
        
    }
}
