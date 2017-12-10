package com.java7book.chapter12;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

class Target <T> {
    public List<? extends Comparable<T>> create(T obj) {
        return null;
    }
}

public class GenericReflection {
    public void reflect() throws Exception {
        Class<?> clazz = Target.class;
        Method method = clazz.getMethod("create", new Class<?>[] {Object.class});
        Type paramType = method.getGenericParameterTypes()[0];
        TypeVariable<?> typeVariable = (TypeVariable<?>) paramType;
        typeVariable.getName(); //值为 T
        Type returnType = method.getGenericReturnType();
        ParameterizedType pType = (ParameterizedType) returnType;
        Type actualType = pType.getActualTypeArguments()[0];
        Type[] bounds = ((WildcardType) actualType).getUpperBounds();
        ParameterizedType boundType = (ParameterizedType) bounds[0];
        boundType.getRawType(); //Comparable接口的Class类对象
    }
    
    public static void main(String[] args) throws Exception {
        GenericReflection gf = new GenericReflection();
        gf.reflect();
    }
}
