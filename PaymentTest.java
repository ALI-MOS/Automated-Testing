package abber;

import java.time.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;



public class PaymentTest {
	public static String url = "https://test.abber.co/";
	public static String email = "tapsomerki@gufum.com";
	public static String password = "Hh123456!";
	public static String cardNo = "2222420000001113";
	public static String cardDate = "0826";
	public static String cardCvv = "123";
	
	private WebDriver driver;
	private WebDriverWait wait;

	public static void main(String[] args) {
		PaymentTest test = new PaymentTest();
		test.login();
		test.requestDream();
		test.creditPay();
	}
	
	public PaymentTest() {
		// setup
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		
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
	
	public void requestDream() {
		WebElement requestButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sections > section:nth-child(1) > div > div.flex.flex-col.items-center.lg\\:items-start > div > button")));
		requestButton.click();
		
		WebElement dreamTitleTextbox = driver.findElement(By.cssSelector("#id_dream_title"));
		dreamTitleTextbox.sendKeys("my dream");
		
		WebElement continueButton = driver.findElement(By.cssSelector("#dream-form > fieldset > button"));
		continueButton.click();
	}
	
	public void creditPay() {
		WebElement creditCardOption = driver.findElement(By.cssSelector("#choose-method > div > div > div:nth-child(3) > label"));
		creditCardOption.click();
		
		WebElement continueButton = driver.findElement(By.cssSelector("#choose-method > div > div > div:nth-child(3) > div > div > button"));
		continueButton.click();
		
		driver.switchTo().frame("card.number");
		WebElement cardNoTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > form > input[type=tel]:nth-child(1)")));
		cardNoTextbox.sendKeys(cardNo);
		driver.switchTo().defaultContent();
		
		WebElement cardDateTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div/form/div[3]/div[2]/input")));
		cardDateTextbox.sendKeys(cardDate);
		
		driver.switchTo().frame("card.cvv");
		WebElement cardCVVTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > form > input[type=tel]")));
		cardCVVTextbox.sendKeys(cardCvv);
		driver.switchTo().defaultContent();
		
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div/form/div[10]/div/button")));
		submitButton.click();
		
	}
}
