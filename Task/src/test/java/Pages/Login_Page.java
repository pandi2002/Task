package Pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Login_Page {
	WebDriver driver;
	By myname=By.id("username");
	By mail=By.id("email");
	By telephone=By.id("tel");
	By file=By.xpath("//input[@type='file']");
	By upload = By.name("datafile");

	public Login_Page(WebDriver driver) {
		this.driver=driver;
	}

	@Test
	public String myName(String input) {
		driver.findElement(myname).sendKeys(input);
		return driver.findElement(myname).getAttribute("value");

	}
	public String mailid(String input) {
		driver.findElement(mail).sendKeys(input);
		return driver.findElement(mail).getAttribute("value");

	}
	public String teleno(String input) {
		driver.findElement(telephone).sendKeys(input);
		return driver.findElement(telephone).getAttribute("value");

	}
	public String upload(String input) {
		driver.findElement(upload).sendKeys(input);
		return driver.findElement(upload).getAttribute("value");
	}
	public String gender(String input) {
		Select gender=new Select(driver.findElement(By.name("sgender")));
		gender.selectByVisibleText(input);
		return driver.findElement(By.name("sgender")).getAttribute("value");
	}
	public boolean experience() {
		driver.findElement(By.xpath("//input[@value='one']")).click();
		return driver.findElement(By.xpath("//input[@value='one']")).isSelected();
	}

	public boolean skills() {
		driver.findElement(By.xpath("//input[@value='testng']")).click();
		return driver.findElement(By.xpath("//input[@value='testng']")).isSelected();
	}
	public String tools(String input) {
		Select tools = new Select(driver.findElement(By.id("tools")));
		tools.selectByVisibleText(input);
		return driver.findElement(By.id("tools")).getAttribute("value");
	}


}
