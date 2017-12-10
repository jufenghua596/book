package com.java7book.chapter8.annotation;

public class EmployeeInfoManagerMain {

    public static void main(String[] args) {
        EmployeeInfoManager manager = EmployeeInfoManagerFactory.getManager();
        manager.updateSalary();
    }

}
