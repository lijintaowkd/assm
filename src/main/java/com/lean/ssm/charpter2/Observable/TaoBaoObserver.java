package com.lean.ssm.charpter2.Observable;

import java.util.Observable;
import java.util.Observer;

public class TaoBaoObserver implements Observer{
  
	public void update(Observable o,Object product){
		String newProduct =(String) product;
		System.out.println("发送新产品【"+newProduct+"】同步的淘宝商城");
	}
}
