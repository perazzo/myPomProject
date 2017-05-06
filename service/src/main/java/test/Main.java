/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.service.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author W205951620
 */
public class Main {
    public static void main(String [] args){
        ApplicationContext context =
               new ClassPathXmlApplicationContext(new String[] {"ServiceConfig.xml"});
        HelloWorldService test = (HelloWorldService) context.getBean("ServiceTest");

        test.sayHello("Test Component");
    }
}
 