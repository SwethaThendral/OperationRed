package com.login;

public class Sampl extends Class {

	public static void main(String[] args) {
		
	
	Class a = new Class();
	a.getDriver();
	a.loadUrl("https://www.facebook.com/");
	a.typData(a.findElementById("email"), "SwethaThendral");
	a.typData(a.findElementById("pass"), "2174151226");
	a.clickBtn(a.findELementByXpath("name"));
	
	
	
	
	
}
}