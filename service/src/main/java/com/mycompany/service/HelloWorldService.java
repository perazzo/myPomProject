/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.HelloWorldImpl;
import com.mycompany.dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author W205951620
 */

@Service("ServiceTest")
public class HelloWorldService {
    @Autowired
    HelloWorldImpl helloworld = new HelloWorldImpl();
    
    @Autowired
    Person person = new Person();
    
    public void sayHello(String name) {
        System.out.println("HelloWorldService [HelloWorldDAO=" + helloworld + " " + name + "\nSkill: " + person.getSkill());
    }
}
