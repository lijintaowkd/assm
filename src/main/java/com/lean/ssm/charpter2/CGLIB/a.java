package com.lean.ssm.charpter2.CGLIB;

import com.lean.ssm.charpter2.reflect.ReflectServiceImpl;

public class a {
    public static void testCGLIBProxy(){
    	CglibProxyExample cpe = new CglibProxyExample();
    	ReflectServiceImpl obj = (ReflectServiceImpl) cpe.getProxy(ReflectServiceImpl.class);
                 obj.sayHello("张三");
    }
	public static void main(String[] args) {
	  
		testCGLIBProxy();
	}

}
