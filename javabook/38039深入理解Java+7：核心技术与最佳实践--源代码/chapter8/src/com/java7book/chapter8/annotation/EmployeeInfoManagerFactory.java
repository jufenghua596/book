package com.java7book.chapter8.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class EmployeeInfoManagerFactory {
    private static class AccessInvocationHandler<T> implements InvocationHandler {
        private final T targetObject;
        
        public AccessInvocationHandler(T targetObject) {
            this.targetObject = targetObject;
        }
        
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            Role annotation = method.getAnnotation(Role.class);
            if (annotation != null) {
                String[] roles = annotation.value();
                String currentRole = AccessManager.getCurrentUserRole();
                if (!Arrays.asList(roles).contains(currentRole)) {
                    throw new RuntimeException("没有调用此方法的权限。");
                }
            }
            return method.invoke(targetObject, args);
        }
    }
    
    public static EmployeeInfoManager getManager() {
        EmployeeInfoManager instance = new DefaultEmployeeInfoManager();
        return (EmployeeInfoManager) Proxy.newProxyInstance(instance.getClass().getClassLoader(), new Class<?>[] { EmployeeInfoManager.class }, new AccessInvocationHandler<EmployeeInfoManager>(instance));
    }
}
