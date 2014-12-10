/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieah.model;

/**
 *
 * @author T107
 */
import java.util.logging.Level; 
import java.util.logging.Logger; 
import org.hibernate.HibernateException; 
 import org.hibernate.Session; 
 import org.hibernate.SessionFactory; 
 import org.springframework.context.annotation.Configuration; 
 
 
 public class DAO { 
      
 private static final Logger log = Logger.getAnonymousLogger(); 
 private static final ThreadLocal session = new ThreadLocal(); 
 
 
 private static final SessionFactory sessionFactory = HibernateUtilidades.getSessionFactory(); 
          
    public DAO() {  } 
                      
     public static Session getSession() { 
           Session session = (Session) DAO.session.get(); 
if (session == null) { 
session = sessionFactory.openSession(); 
DAO.session.set(session); 
                   } 
     return session; 
    } 
     protected  void begin() { 
           getSession().beginTransaction(); 
       } 
   protected   void commit() { 
            getSession().getTransaction().commit(); 
      } 
   protected  void rollback() { 
       try { 
      getSession().getTransaction().rollback(); 
           } catch( HibernateException e ) { 
      log.log(Level.WARNING,"No se puede hacer el roolback",e); 
    } 
    try { 
     getSession().close(); 
     } catch( HibernateException e ) { 
      log.log(Level.WARNING,"Imposible cerrar",e); 
       } 
       DAO.session.set(null); 
    } 
 
 
     public static void close() { 
      getSession().close(); 
       DAO.session.set(null); 
    } 
 
 
 } 
