package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class NewUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient Date birthDate;
    public NewUser(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public int getAge() {
        return dateToAge(birthDate);
    }
    
    private Date ageToDate(int age) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int newYear = currentYear - age;
        calendar.set(Calendar.YEAR, newYear);
        return calendar.getTime();
    }
    
    private int dateToAge(Date date) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.setTime(birthDate);
        int birthYear = calendar.get(Calendar.YEAR);
        int age = currentYear - birthYear;
        return age;
    }
    
    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        int age = dateToAge(birthDate);
        output.writeInt(age);
        System.out.println(age);
    }
    
    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        int age = input.readInt();
        this.birthDate = ageToDate(age);
        
        input.registerValidation(new UserValidator(this), 0);
    } 
    
    private static class UserValidator implements ObjectInputValidation {
        private NewUser user;
        public UserValidator(NewUser user) {
            this.user = user;
        }
        public void validateObject() throws InvalidObjectException {
            if (user.getAge() < 0) {
                throw new InvalidObjectException("非法的年龄数值。");
            }
        }
    }
}
