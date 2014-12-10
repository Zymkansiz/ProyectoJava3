/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieah.controller;


 
 import org.springframework.context.annotation.ComponentScan; 
 import org.springframework.context.annotation.Configuration; 
 import org.springframework.web.servlet.config.annotation.EnableWebMvc; 
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter; 
 
  @Configuration 
@EnableWebMvc 
@ComponentScan({"com.ieah.controller"}) 

 
public class WebApConfig extends WebMvcConfigurerAdapter{ 
     
 } 