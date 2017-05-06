/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author W205951620
 */
public class Person {
    @Autowired
    private Ability ability;

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
    
    
//    public void print(){
//        System.out.println(ability.getSkill().toString());
//    }

    public String getSkill() {
        return ability.getSkill();
    }
}
