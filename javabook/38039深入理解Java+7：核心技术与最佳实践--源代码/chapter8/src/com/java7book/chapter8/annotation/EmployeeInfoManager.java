package com.java7book.chapter8.annotation;

public interface EmployeeInfoManager {
    @Role("manager")
    public void updateSalary();
}
