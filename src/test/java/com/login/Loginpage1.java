package com.login;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Loginpage1 extends BaseClassTask {
	
	public static void main(String[] args) throws Exception {
	
	BaseClassTask a = new BaseClassTask();
	a.getDriver();
	a.loadUrl("http://adactinhotelapp.com/");
	a.maximize();
	
	
	a.type(a.findElementById("username"), a.getdata(1, 0));
	a.type(a.findElementById("password"), a.getdata(1,1));
	a.click(a.findElementById("login"));
	a.selectOptionByText(a.findElementById("location"), a.getdata(1, 2));
	a.selectOptionByText(a.findElementById("hotels"), a.getdata(1, 3));
	a.selectOptionByText(a.findElementById("room_type"), a.getdata(1, 4));
	a.selectOptionByText(a.findElementById("room_nos"), a.getdata(1, 5));
	a.type(a.findElementById("datepick_in"),a.se);
	a.selectOptionByText(a.findElementById("datepick_in"), a.getdata(1, 6));
	a.selectOptionByText(a.findElementById("datepick_out"), a.getdata(1, 7));
	a.selectOptionByText(a.findElementById("adult_room"), a.getdata(1, 8));
	a.selectOptionByText(a.findElementById("child_room"), a.getdata(1, 9));
	a.click(a.findElementById("Submit"));
	
	
	
	
	
	
	}

}
