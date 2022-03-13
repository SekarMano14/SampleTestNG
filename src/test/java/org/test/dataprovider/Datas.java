package org.test.dataprovider;

import org.testng.annotations.DataProvider;

public class Datas {
	@DataProvider(name="login")
	private Object[][] data() {
		Object[][] obj=new Object[][]
				{
			{"mano@gmai.com","87654"},
			{"raj@gmail.com","98765"},
			{"ram@gmail.com","00000"},
			{"suresh@gmail.com","089898"}
				};
		return obj;

	}
	
	
	
	@DataProvider(name="register")
	private Object[][] data1() {
		Object[][] obj=new Object[][] {
			{"Manoj","Kumar","8015572746","34567"},
			{"kumar","Kumar","8015572746","34567"},
			{"Ram","Kumar","8015572746","34567"},
			{"Raj","Kumar","8015572746","34567"}
		};
		return obj;
	}
	@DataProvider(name="reg")
	private Object[][] data2() {
		Object[][] obj=new Object[][] {
			{"Manoj","Kumar"},
			{"kumar","Kumar"},
			{"Ram","Kumar"},
			{"Raj","Kumar"}
		};
		return obj;
	}

}
