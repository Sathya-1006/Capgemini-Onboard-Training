package com.demo;

import org.springframework.transaction.annotation.Transactional;

public class EmployeeService {

    private EmployeeDAO dao;

    public void setDao(EmployeeDAO dao) {
        this.dao = dao;
    }

    @Transactional   // says that everything inside this method is one transaction
    public void updateTwoEmployees() {

        dao.updateSalary(102,70000);//to update first employee salary

        int x = 10 / 2; // exception takes place so the transaction will roll back
        dao.updateSalary(103,80000);// not execute if there is exception
    }
    
    
    
}