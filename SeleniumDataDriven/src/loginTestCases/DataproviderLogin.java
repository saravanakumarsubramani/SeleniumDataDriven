package loginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataproviderLogin {
	
	//example for dataprovider
	
	//[] [] this is 2 dimensional array string
	String [][] data={
		{"Admin","admin123"},
		{"dummy","dummy"},
		{"Admin","dummy"},
		{"dummy","admin123"}
	};
	
	@DataProvider(name="logindata")
	public String[][] loginDataProvider() {
		return data;
	}

	@Test(dataProvider="logindata")
	public void loginwithBothcorrect(String uname,String pword) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(uname);
		
		WebElement passwd=driver.findElement(By.id("txtPassword"));
		passwd.sendKeys(pword);
		
		WebElement loginbutton=driver.findElement(By.id("btnLogin"));
		loginbutton.click();
		driver.quit();		
	}
}

