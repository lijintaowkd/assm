package com.lean.ssm.charpter2.Builder;

public class a {

	public static void main(String[] args) {
	  TickerHelper helper = new TickerHelper();
	  helper.buildAdult("成年票");
	  helper.buildChildernForSeat("有座儿童");
	  helper.buildChildernNoSeat("无座儿童");
	  helper.buildElderly("老年票");
	  helper.buildSoldier("军人票");
      Object ticket = TicketBuilder.builder(helper);
	}

}
