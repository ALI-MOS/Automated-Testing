package abber;

import java.time.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class PaymentTest {
	public static String url = "https://test.abber.co/";
	public static String email = "tapsomerki@gufum.com";
	public static String password = "Hh123456!";
	public static String cardNo = "2222420000001113";
	public static String cardDate = "0826";
	public static String cardCvv = "123";
	
	public WebDriver driver;

	public static void main(String[] args) {
		PaymentTest test = new PaymentTest();
		test.login();
		
		// click on request till payment
		test.driver.findElement(By.cssSelector("#sections > section:nth-child(1) > div > div.flex.flex-col.items-center.lg\\:items-start > div > button")).click();
		test.driver.findElement(By.cssSelector("#id_dream_title")).sendKeys("my dream");
		test.driver.findElement(By.cssSelector("#dream-form > fieldset > button")).click();
		
		// click on creditCard 
		test.driver.findElement(By.cssSelector("#choose-method > div > div > div:nth-child(3) > label")).click();
		test.driver.findElement(By.cssSelector("#choose-method > div > div > div:nth-child(3) > div > div > button")).click();
		
		// add details
		test.driver.switchTo().frame("card.number");
		WebElement cardNoTextbox = test.driver.findElement(By.cssSelector("body > form > input[type=tel]:nth-child(1)"));
		cardNoTextbox.sendKeys(cardNo);
		test.driver.switchTo().defaultContent();

	}
	
	public PaymentTest() {
		// setup
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		// open site
		driver.get(url);
	}
	
	public void login() {
		WebElement loginNavButton = driver.findElement(By.cssSelector("#innerSticky > a"));
		loginNavButton.click();
		
		WebElement emailMethodIcon = driver.findElement(By.cssSelector("#id_email_login > button"));
		emailMethodIcon.click();

		WebElement emailTextbox = driver.findElement(By.cssSelector("#id_login"));
		WebElement passwordTextbox = driver.findElement(By.cssSelector("#id_password"));	
		WebElement submitLoginButton = driver.findElement(By.cssSelector("#sections > div > form > fieldset > div.pt-2 > button"));
		emailTextbox.sendKeys(email);
		passwordTextbox.sendKeys(password);
		submitLoginButton.click();
	}
}
