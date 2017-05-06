/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author W205951620
 */

@Repository
public class HelloWorldImpl implements HelloWorld{

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
    
    @Override
    public String toString() {
        return "Hello";
    }
}
