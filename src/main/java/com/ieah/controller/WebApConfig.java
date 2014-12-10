
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