/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.Student;

/**
 *
 * @author W205951620
 */
public class StudentManager implements StudentManagerInt{

    @Override
    public void addStudent(Student student) {
        service.StudentManager sm = new service.StudentManager();
        sm.addStudent(student);
    }
        
}
