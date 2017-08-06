package com.lean.ssm.charpter2.CGLIB;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;



public class CglibProxyExample implements MethodInterceptor {

	public Object getProxy(Class cls){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("调用真实对象前");
		Object result = methodProxy.invokeSuper(proxy, args);
		System.out.println("调用真实方法后");
		return result;
	}

	

}
