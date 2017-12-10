package com.java7book.chapter12;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

class GenericeSuperClass<T> {
    public List<? extends Serializable> method() {
        System.out.println("调用父类中的方法。");
        return null;
    }
}

class GenericeSubClass<S extends Number> extends GenericeSuperClass<S> {
    @Override
    public List<S> method() {
        System.out.println("调用子类中的方法。");
        return null;
    }
}

public class GenericOverride {
    public static void main(String[] args) throws Exception {
        GenericeSubClass<Long> subClass = new GenericeSubClass<>();
        subClass.method();
        Method method = GenericeSuperClass.class.getMethod("method", new Class<?>[] {Object.class});
        System.out.println(method.toGenericString());
        System.out.println(method.toString());
    }
}
