package com.lean.ssm.charpter2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a {
    public static ReflectServiceImpl2 getInstance(){
    	ReflectServiceImpl2 object = null;
        	try {
				object=(ReflectServiceImpl2) Class.forName("com.lean.ssm.charpter2.reflect.ReflectServiceImpl2")
						 .getConstructor(String.class).newInstance("李四");
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException  | IllegalArgumentException 
					| InvocationTargetException	| NoSuchMethodException 
					| SecurityException e) {
 			e.printStackTrace();
		}
		
    	return object;
    }
    public static Object reflectMethod(){
    	Object returnObj =null;
    	ReflectServiceImpl target = new ReflectServiceImpl();
    
    	try {
			Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
				returnObj = method.invoke(target, "张三");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
    	return returnObj;
		
    }
    public static Object reflect(){
    	ReflectServiceImpl object = null;
     
    	try {
			object = (ReflectServiceImpl) Class.forName("com.lean.ssm.charpter2.reflect.ReflectServiceImpl").newInstance();
			Method method = object.getClass().getMethod("sayHello", String.class);
			method.invoke(object, "张三");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
    }
	public static void main(String[] args) {
		reflect();
	}

}
