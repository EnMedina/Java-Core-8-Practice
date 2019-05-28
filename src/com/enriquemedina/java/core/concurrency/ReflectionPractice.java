package com.enriquemedina.java.core.concurrency;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionPractice {
	public static void main(String[] args) {
		PrivateC privateC = new PrivateC();
		Method method;
		try {
			method = privateC.getClass().getDeclaredMethod("privateMethod", null);
			method.setAccessible(true);
			method.invoke(privateC);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}

class PrivateC{
	private void privateMethod() {
		System.out.println("Reached something you shouldn't, bucko");
	}
}