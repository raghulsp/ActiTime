package script;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoA {
@DataProvider
public String[][] getData(){
	String[][] s = new String[2][2];
	s[0][0]="UserA";
	s[0][1]="A123";
	s[1][0]="UserB";
	s[1][1]="B123";
	return s;
	
}
@Test(dataProvider="getData")
public void testA(String un, String pw) {
	Reporter.log("Create:"+un+"PW is:"+pw,true);
}
}
