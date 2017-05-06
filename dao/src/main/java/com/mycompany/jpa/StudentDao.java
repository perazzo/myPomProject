/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.io.Console;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author W205951620
 */
@Component
public class StudentDao {
    // Injected database connection:
    @PersistenceContext() 
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    // Stores a new student:
    @Transactional
    public void persist(Students student) {
        em.persist(student);
    }
    
    @Transactional
    public List<Students> getAllStudents(){
        List<Students> getStudents = null; 
        try{
            getStudents = em.createNamedQuery("Students.getAll").getResultList();
        } catch(Exception ex){
            System.console().writer().println(ex.toString());
        }
        return getStudents;
    }
    
    @Transactional
    public void delete(int id) {
        List<Students> stList = em.createNamedQuery("Students.findById").setParameter("id", id).getResultList();
        for (int i = 0; i < stList.size(); i++) {
            Students st = stList.get(i);
            em.remove(st);
        }
    }
    
    @Transactional
    public void update(Students st){
        Students merge = em.merge(st);
    }
    
    @Transactional
    public void create(Students st){
        em.persist(st);
    }
    
    public Students findById(int id){
        Students st = (Students) em.createNamedQuery("Students.findById").setParameter("id", id).getSingleResult();
        return st;
    }
}
