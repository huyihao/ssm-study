package com.learn.ssm.chapter2.builder;

public class TicketBuilder {
	public static Object builder(TicketHelper helper) {
		System.out.println("通过TicketHelper构建套票信息");
		return null;
	}
	
	public static void main(String[] args) {
		TicketHelper helper = new TicketHelper();
		helper.buildAdult("成人票");
		helper.buildChildrenForSeat("有座儿童票");
		helper.buildChildrenNoSeat("无座儿童票");
		helper.buildElderly("老人票");
		helper.buildSoldier("军人票");
		Object ticket = TicketBuilder.builder(helper);
	}
}
