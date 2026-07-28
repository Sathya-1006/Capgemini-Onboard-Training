package org.examples;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        
        //requesting once so one obj will be created
        Car car = ctx.getBean(Car.class);
        car.drive();
        
        
        // 2 request so 2 times executes
        Car car1 = ctx.getBean(Car.class);
        car1.drive();
        
        
        //type casting ApplicationContext and calling close()
        ((ConfigurableApplicationContext)ctx).close();
    }
}