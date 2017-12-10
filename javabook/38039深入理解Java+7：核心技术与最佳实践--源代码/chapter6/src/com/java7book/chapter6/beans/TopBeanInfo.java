package com.java7book.chapter6.beans;

import java.awt.Image;
import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

public class TopBeanInfo implements BeanInfo {
	public BeanInfo[] getAdditionalBeanInfo() {
		return new BeanInfo[] {};
	}

	@Override
	public BeanDescriptor getBeanDescriptor() {
		return new BeanDescriptor(Top.class);
	}

	@Override
	public int getDefaultEventIndex() {
		return 0;
	}

	@Override
	public int getDefaultPropertyIndex() {
		return 0;
	}

	@Override
	public EventSetDescriptor[] getEventSetDescriptors() {
		return new EventSetDescriptor[] {};
	}

	@Override
	public Image getIcon(int iconKind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MethodDescriptor[] getMethodDescriptors() {
		return new MethodDescriptor[] {};
	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			return new PropertyDescriptor[] {new PropertyDescriptor("dummy", Top.class, null, null)};
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
