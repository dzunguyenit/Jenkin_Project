package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class api_05_button_radio_checkbox_alert {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void Test06_jsConfirm() throws Exception {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS prompt", alert.getText());
		String textInput = "Vu Nguyen";
		alert.sendKeys(textInput);
		alert.accept();
		String textResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals("You entered: " + textInput, textResult);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
