package com.lean.ssm.charpter2.Interceptor;

import com.lean.ssm.charpter2.JDK.HelloWorld;
import com.lean.ssm.charpter2.JDK.HelloWorldImpl;

public class a {

	public static void main(String[] args) {

		/*HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
				"com.lean.ssm.charpter2.Interceptor.MyInterceptor");
	*/
		HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
				"com.lean.ssm.charpter2.Interceptor.Interceptor1");
		HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,
				"com.lean.ssm.charpter2.Interceptor.Interceptor2");
		HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2,
				"com.lean.ssm.charpter2.Interceptor.Interceptor3");

		proxy3.sayHelloWorld();
	}

}
