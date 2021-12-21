package com.login;

import java.io.IOException;

public class SearchHotel extends BaseClassTask {
	
	public static void main(String[] args) throws Exception {
		BaseClassTask a = new BaseClassTask();
		a.selectOptionByText(a.findElementById("location"), a.getdata(1, 2));
		
	}

}
