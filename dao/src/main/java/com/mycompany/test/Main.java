/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import com.mycompany.dao.HelloWorld;
import com.mycompany.dao.HelloWorldImpl;
import com.mycompany.dao.Person;
import com.mycompany.dao.Student;
import com.mycompany.jdbctemplate.SampleDao;
import com.mycompany.spring.HelloWorldConfig;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author W205951620
 */
public class Main {
    public static void main(String [] args){
        // Get From XML
        ApplicationContext context2 = new ClassPathXmlApplicationContext("jdbcTemplateConfig.xml");
        SampleDao test = (SampleDao) context2.getBean("sampleDao");
        
        
        // Insert New Student
        /*
        Student newStudent = new Student();
        newStudent.setFirstName("Test1");
        newStudent.setLastName("Test2");
        newStudent.setAge(19);
        test.insertStudent(newStudent);
        
        
        // Update Student Age to 30 Where FirstName = "FName" 
        Student updateStudent = new Student();
        updateStudent.setFirstName("FName");
        updateStudent.setAge(30);
        test.updateStudent(updateStudent);
        
        // Delete all Students Where LastName = "Test"
        Student deleteStudent = new Student();
        deleteStudent.setLastName("Test");
        
        // Print Students
        */
        test.print("Test2");
    }
}
