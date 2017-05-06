/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

/**
 *
 * @author W205951620
 */
public class Student {
    private String FirstName;
    private String LastName;
    private int Age;
        
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
    
    @Override
    public String toString() {
        return "First Name: " + getFirstName() + "\nLast Name: " +
                getLastName() + "\nAge: " + getAge() + "\n";
    }
}
