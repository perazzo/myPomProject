/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.RESTful;

import com.mycompany.jpa.StudentDao;
import com.mycompany.jpa.Students;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author W205951620
 */

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired //this will give you the reference to UserDAO      
    StudentDao stDao = new StudentDao(); 
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Students>> students() {
        List<Students> listStudents = stDao.getAllStudents();
        
        return new ResponseEntity<List<Students>>(listStudents, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        stDao.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Students> update(@PathVariable int id, @RequestBody Students student){
        Students currentStudent = stDao.findById(id);

        if (currentStudent == null){
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        }

        currentStudent.setFirstname(student.getFirstname());
        currentStudent.setLastname(student.getLastname());

        stDao.update(currentStudent);
        return new ResponseEntity<Students>(currentStudent, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Students student, UriComponentsBuilder ucBuilder){

        stDao.create(student);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
