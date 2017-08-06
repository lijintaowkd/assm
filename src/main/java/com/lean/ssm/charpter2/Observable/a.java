package com.lean.ssm.charpter2.Observable;

public class a {

	public static void main(String[] args) {

		ProductList observable = ProductList.getInstance();
		TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
		JingDongObserver jingDongObserver = new JingDongObserver();
		observable.addObserver(jingDongObserver);
		observable.addObserver(taoBaoObserver);
		observable.addProduct("新增产品1");
	}

}
