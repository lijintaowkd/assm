package com.lean.ssm.charpter2.Interceptor;

import java.lang.reflect.Method;

public class Interceptor1 implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method,
			Object[] args) {
        System.out.println("【拦截器1】的before方法");
       return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		 System.out.println("【拦截器1】的after方法");
	}

}
