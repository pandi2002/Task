package Test;

import org.testng.annotations.Test;

import Pages.Login_Page;

import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Run_Module {
	WebDriver driver=new ChromeDriver();
	Properties p=new Properties();
	@Test
	public void Log() throws IOException {
		Login_Page login= new Login_Page(driver);
		String Username=login.myName(p.getProperty("name"));
		String Usermail=login.mailid(p.getProperty("mail"));
		String Contact=login.teleno(p.getProperty("telephone"));
		String Usergender=login.gender(p.getProperty("Gender"));
		String userupload = login.upload(p.getProperty("image"));
		boolean userexperience = login.experience();
		boolean userskills = login.skills();
		String usertools =login.tools(p.getProperty("tools"));

		System.out.println(Username);
		System.out.println(Usermail);
		System.out.println(Contact);
		System.out.println(Usergender);
		System.out.println(userupload);
		System.out.println(userexperience);
		System.out.println(userskills);
		System.out.println(usertools);




	}
	@BeforeTest
	public void beforeTest() throws IOException, InterruptedException {

		FileReader fr=new FileReader("C:\\Users\\rajapandi.p\\Documents\\Selenium_TASK\\Task\\Utility\\Login_Properties");	 
		p.load(fr);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String first = driver.getWindowHandle();
		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();


		driver.switchTo().newWindow(WindowType.TAB);
		String second = driver.getWindowHandle();
		driver.get(p.getProperty("Urll"));
		driver.switchTo().window(first);


	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
