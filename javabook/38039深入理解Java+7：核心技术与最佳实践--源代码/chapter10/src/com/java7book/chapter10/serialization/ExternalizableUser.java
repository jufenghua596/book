package com.java7book.chapter10.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableUser implements Externalizable {
    private String name;
    private String email;
    public ExternalizableUser() {  
    }
    public ExternalizableUser(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(getName());
        out.writeUTF(getEmail());
    }

    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        name = in.readUTF();
        email = in.readUTF();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableUser user = new ExternalizableUser("Alex", "alex@example.org");
        String filePath = "e_user.bin";
        SerializationUtils.write(user, filePath);
        user = (ExternalizableUser) SerializationUtils.read(filePath);
        System.out.println(user.getEmail());
    }
}
