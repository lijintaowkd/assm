package com.lean.ssm.charpter2.reflect;

public class ReflectServiceImpl2 {
	private String name;
	
    public ReflectServiceImpl2(String name) {
		super();
		this.name = name;
	}

	public void sayHello(){
    	System.out.println("Hello "+name);
    }
    
}
