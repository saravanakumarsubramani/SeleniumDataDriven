package loginTestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenDifferentExcelInfomats {

	//	Different XL for Data Driven in TestNG:

	WebDriver d;
	//	String XLpath="C:\\Users\\Admin\\eclipse-workspace\\NGPRO\\WorkBook\\ddtng.xls";

	String pathv="C:\\Users\\Admin\\Desktop\\ddtngv.xls";
	String pathin="C:\\Users\\Admin\\Desktop\\ddtngin.xls";
	String pathill="C:\\Users\\Admin\\Desktop\\ddtngill.xls";
	String pathn="C:\\Users\\Admin\\Desktop\\ddtngn.xls";


	@Test(priority=3)
	public void fvalid() throws BiffException, IOException, InterruptedException {
		FileInputStream f= new FileInputStream( pathv);
		Workbook b=Workbook.getWorkbook(f);
		Sheet s =  b.getSheet(0);
		int rowcount =s.getRows();
		for(int i=1; i<rowcount; i++){
			String username= s.getCell(0, i).getContents();
			String password=s.getCell(1, i).getContents();


			d.findElement(By.xpath("//*[@id=\"txt_unam\"]")).sendKeys(username);
			d.findElement(By.xpath("//*[@id='txt_pass']")).sendKeys(password);
			d.findElement(By.xpath("//*[@id=\"Button3\"]")).click();
			Thread.sleep(5000);
			d.findElement(By.xpath("//*[@id=\"LinkButton1\"]")).click();
		}

	}

	@Test(priority=2)
	void finvalid() throws BiffException, IOException, InterruptedException {
		FileInputStream f= new FileInputStream( pathin);
		Workbook b=Workbook.getWorkbook(f);
		Sheet s = b.getSheet(0);
		int rowcount =s.getRows();
		for(int i=4; i<rowcount; i++){
			String username= s.getCell(0, i).getContents();
			String password=s.getCell(1, i).getContents();


			d.findElement(By.xpath("//*[@id=\"txt_unam\"]")).sendKeys(username);
			d.findElement(By.xpath("//*[@id='txt_pass']")).sendKeys(password);
			d.findElement(By.xpath("//*[@id=\"Button3\"]")).click();
			Thread.sleep(5000);
			d.switchTo().alert().accept();
		}

	}

	@Test(priority=1)
	void fillegal() throws BiffException, IOException, InterruptedException {
		FileInputStream f= new FileInputStream( pathill);
		Workbook b=Workbook.getWorkbook(f);
		Sheet s = b.getSheet(0);
		int rowcount =s.getRows();
		for(int i=6; i<rowcount; i++){
			String username= s.getCell(0, i).getContents();
			String password=s.getCell(1, i).getContents();


			d.findElement(By.xpath("//*[@id=\"txt_unam\"]")).sendKeys(username);
			d.findElement(By.xpath("//*[@id='txt_pass']")).sendKeys(password);
			d.findElement(By.xpath("//*[@id=\"Button3\"]")).click();
			Thread.sleep(5000);
			d.switchTo().alert().accept();
		}	

	}

	@Test	(enabled=true)				
	void fnull() throws BiffException, IOException {
		FileInputStream f= new FileInputStream( pathn);
		Workbook b=Workbook.getWorkbook(f);
		Sheet s = b.getSheet(0);
		int rowcount =s.getRows();
		for(int i=9; i<rowcount; i++){
			String username= s.getCell(0, i).getContents();
			String password=s.getCell(1, i).getContents();


			d.findElement(By.xpath("//*[@id=\"txt_unam\"]")).sendKeys(username);
			d.findElement(By.xpath("//*[@id='txt_pass']")).sendKeys(password);
			d.findElement(By.xpath("//*[@id=\"Button3\"]")).click();
			d.switchTo().alert().accept();
		}
	}	

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		d=new ChromeDriver();  
		d.get("http://brm.tremplintech.in/web_pages/login.aspx");
		Thread.sleep(5000);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		d.close();
	}

}



