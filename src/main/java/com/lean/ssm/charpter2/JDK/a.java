package com.lean.ssm.charpter2.JDK;

public class a {
    public static void testJdkProxy(){
    	JdkProxyExample jdk = new JdkProxyExample();
    	HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
    	proxy.sayHelloWorld();
    }
	public static void main(String[] args) {
		testJdkProxy();
	}

}
