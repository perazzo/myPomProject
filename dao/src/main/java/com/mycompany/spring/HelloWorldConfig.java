/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring;

import com.mycompany.dao.HelloWorld;
import com.mycompany.dao.HelloWorldImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author W205951620
 */

@Configuration
public class HelloWorldConfig {
    @Bean(name="HelloWorldBean") 
    public HelloWorld helloWorld(){
        return new HelloWorldImpl();
    }
}
