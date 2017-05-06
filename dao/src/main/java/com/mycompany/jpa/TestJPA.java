/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author W205951620
 */
public class TestJPA {
    public static void main(String [] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"jdbcTemplateConfig.xml"});
        
        StudentDao dao = (StudentDao) context.getBean("studentDao");
        
        Students st = dao.findById(6);
        st.setFirstname("New Name");
        dao.update(st);
        /*
        Students student = new Students();
        student.setFirstname("Test FName");
        student.setLastname("Test LName");
        student.setAge(25);
        
        try{
         
            dao.persist(student);
       
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        */
        
        
    }
}
