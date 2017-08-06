package com.lean.ssm.charpter2.Builder;

public class TickerHelper {
    
	public void buildAdult(String info){
		System.out.println("构建成年人票逻辑："+info);
	}
	
	public void buildChildernForSeat(String info){
		System.out.println("构建有座儿童票逻辑："+info);
	}
	
	public void buildChildernNoSeat(String info){
		System.out.println("构建无座儿童票逻辑："+info);
	}
	
	public void buildElderly(String info){
		System.out.println("构建有老年人票逻辑："+info);
	}
	
	public void buildSoldier(String info){
		System.out.println("构建军人及其家属票逻辑："+info);
	}
}
