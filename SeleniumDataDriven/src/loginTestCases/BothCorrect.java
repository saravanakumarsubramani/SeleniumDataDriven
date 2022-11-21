package loginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	
	@Test
	@Parameters({"username","password"})
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


