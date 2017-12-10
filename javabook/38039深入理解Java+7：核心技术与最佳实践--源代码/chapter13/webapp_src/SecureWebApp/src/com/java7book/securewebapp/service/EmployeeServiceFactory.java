package com.java7book.securewebapp.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

import javax.security.auth.Subject;

import com.java7book.securewebapp.BasePermission;
import com.java7book.securewebapp.DeclaredPermission;
import com.java7book.securewebapp.SubjectHolder;

public class EmployeeServiceFactory {
	private static class AccessControlInvocationHandler implements InvocationHandler {
		private Object targetObj;

		public AccessControlInvocationHandler(Object targetObj) {
			this.targetObj = targetObj;
		}

		public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
			Subject subject = SubjectHolder.get();
			return Subject.doAsPrivileged(subject,
				new PrivilegedExceptionAction<Object>() {
					public Object run() throws Exception {
						try {
							DeclaredPermission annotation = method.getAnnotation(DeclaredPermission.class);
							if (annotation != null) {
								BasePermission permission = new BasePermission(annotation.name(), annotation.actions());
								AccessController.checkPermission(permission);
							}
							return method.invoke(targetObj, args);
						} catch (ReflectiveOperationException e) {
							throw e;
						}
					}
			}, null);
		}
		
	}

	public static EmployeeService getEmployeeService() {
		EmployeeService service = new EmployeeServiceImpl();
		ClassLoader cl = service.getClass().getClassLoader();
		return (EmployeeService) Proxy.newProxyInstance(cl, new Class<?>[] { EmployeeService.class }, new AccessControlInvocationHandler(service));
	}
}
