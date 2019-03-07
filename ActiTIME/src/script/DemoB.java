package script;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoB {
@DataProvider
public Object[][] getData(){
	Object[][] s = new Object[2][2];
	s[0][0]="UserA";
	s[0][1]=123;
	s[1][0]="UserB";
	s[1][1]=456;
	return s;
	
}
@Test(dataProvider="getData")
public void testA(String un, int pw) {
	Reporter.log("Create:"+un+"PW is:"+pw,true);
}
}
