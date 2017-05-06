/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbctemplate;

import com.mycompany.dao.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author W205951620
 */
public class SampleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void print(String ln){
        List<Student> students = getStudents(ln);
        
        for(Student model : students) {
            System.out.println(model);
        }
    }
    
    public List<Student> getStudents(String lastname){
        String sql = "SELECT * FROM STUDENTS WHERE LASTNAME = ?";
        
        List<Student> students  = jdbcTemplate.query(sql,new Object[] { lastname },
                    new BeanPropertyRowMapper(Student.class));
        return students;
        
        /*
        List<Student> students = new ArrayList<Student>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows){
            Student st = new Student();
            st.setFirstName((String)row.get("FirstName"));
            st.setLastName((String)row.get("FirstName"));
            st.setAge(Integer.parseInt(String.valueOf(row.get("Age"))));
            students.add(st);
        }
        return students;
        */
    }
    
    public void insertStudent(Student st){
        String sqlInsert = "INSERT INTO Students (FirstName, LastName, Age)"
                + " VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlInsert, st.getFirstName(), st.getLastName(), st.getAge());
    }
    
    public void updateStudent(Student st){
        String sqlUpdate = "UPDATE Students set Age=? where FirstName=?";
        jdbcTemplate.update(sqlUpdate, st.getAge(), st.getFirstName());
    }
    
    public void deleteStudent(Student st){
        String sqlDelete = "DELETE FROM Students where LastName=?";
        jdbcTemplate.update(sqlDelete, st.getLastName());
    }
}
