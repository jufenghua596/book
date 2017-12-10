package com.java7book.chapter6.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class UseIntrospector {
	
	private static class ParentBean extends Top {
		private long number;
		public long getNumber() {
			return number;
		}

		public void setNumber(long number) {
			this.number = number;
		}
	}

	private static class MyBean extends ParentBean{
		private String name;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public void introspect() throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(MyBean.class);
		outputBeanInfo(beanInfo);
		
		beanInfo = Introspector.getBeanInfo(Top.class);
		outputBeanInfo(beanInfo);
		
		beanInfo = Introspector.getBeanInfo(MyBean.class, ParentBean.class);
		outputBeanInfo(beanInfo);
		
		beanInfo = Introspector.getBeanInfo(MyBean.class, Top.class, Introspector.IGNORE_ALL_BEANINFO);
		outputBeanInfo(beanInfo);
	}
	
	private void outputBeanInfo(BeanInfo beanInfo) {
		System.out.println("== START ==");
		PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : properties) {
			System.out.println(pd);
		}
		System.out.println("==  END ==");
	}
	
	public static void main(String[] args) {
		UseIntrospector ui = new UseIntrospector();
		try {
			ui.introspect();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}

}
