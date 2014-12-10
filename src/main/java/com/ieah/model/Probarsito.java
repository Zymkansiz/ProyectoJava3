/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ieah.model;

/**
 *
 * @author Ivan
 */
public class Probarsito {

    public static void main (String args[]) throws Exception {
        DAOMuebleImpl m = new DAOMuebleImpl();
        System.out.println(m.obtenerTodos());
        
        DAOTipoImpl t = new DAOTipoImpl();
        System.out.println(t.obtenerTodos());
        
        DAOEnvioImpl e = new DAOEnvioImpl();
        System.out.println(e.obtenerTodos());
    }
}

