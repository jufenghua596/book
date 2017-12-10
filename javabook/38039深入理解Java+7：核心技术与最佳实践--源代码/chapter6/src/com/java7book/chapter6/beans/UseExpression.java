package com.java7book.chapter6.beans;

import java.beans.Expression;

public class UseExpression {

	public void executeExpression() throws Exception {
		Expression expr = new Expression(new MyObject(), "greet", new Object[] {"alex"});
		expr.execute();
		Object result = expr.getValue();
	}
	
	public static void main(String[] args) {
		UseExpression ue = new UseExpression();
		try {
			ue.executeExpression();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
