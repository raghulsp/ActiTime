package script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.XL;

public class IrctcDemo extends XL {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		String path="./data/input.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://irctc.com/displayServlet");
		int count = getRowCount(path, "irctc");
		System.out.println(count);
		
		for(int i=1; i<=count; i++) {
		String city=wb.getSheet("irctc").getRow(i).getCell(0).toString();
		System.out.println(city);
		
		String xp="//label[text()='"+city+"']/../label[2]";
		System.out.println(xp);
		
		String ph="";
		try {
			ph=driver.findElement(By.xpath(xp)).getText();
		}
		catch(Exception e) {
			ph="City not Found";
			
		}
		System.out.println(ph);
//		driver.close();
		
		wb.getSheet("irctc").getRow(i).createCell(1).setCellValue(ph);
		wb.write(new FileOutputStream(path));
//		wb.close();
//		}
		}
		driver.close();
		}
	
	

}
