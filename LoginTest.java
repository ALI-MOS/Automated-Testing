package abber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	public static String url = "https://abber.co/";

	private static WebDriver driver;
	private static WebDriverWait wait;
	
	
	public LoginTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 	
		driver.get(url);
	}
	
	public void loginByEmail() {
		WebElement loginSignUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/nav/a")));
		loginSignUpButton.click();
		WebElement loginByEmail = driver.findElement(By.xpath("/html/body/main/div/div[1]/div/form[4]/button"));
		loginByEmail.click();	
		WebElement email = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[1]/div/input"));
		email.sendKeys("myemail@example.com");	
		WebElement password = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[2]/div/input"));
		password.sendKeys("mypassword12");	
		WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/form/fieldset/div[3]/div/input")));
		checkBox.click();
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/form/fieldset/div[4]/button")));
		loginButton.click();			
	}
	
	public void logout() {
		WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/nav/div/button[2]")));
		list.click();
		WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#drawer > div.sticky.bottom-0.z-40.flex.w-full.items-center.justify-between.bg-primary.px-4.py-4 > a.text-secondary.hover\\:text-gray-100 > svg")));
		signOut.click();
	}
	
	public void loginByWhatsApp() {
		WebElement loginSignUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/nav/a")));
		loginSignUpButton.click();
		WebElement whatsAppButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[1]/div/form[3]/button/img")));
		whatsAppButton.click();
		WebElement whatsAppNumber = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[1]/div[1]/input"));
		whatsAppNumber.sendKeys("1177893489");
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/main/div/form/fieldset/div[4]/button")));
		submit.click(); 
	}
	
	public void loginByApple() {
		WebElement loginSignUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/nav/a")));
		loginSignUpButton.click();
		WebElement appleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[1]/div/form[2]/button/img")));
		appleButton.click();
		WebElement appleNumber = driver.findElement(By.xpath("/html/body/div[1]/oauth-init/div[1]/div/oauth-signin/div/apple-auth/div/div[1]/div/sign-in/div/div[1]/div[1]/div/div/div[1]/div/div/input"));
		appleNumber.sendKeys("2154165165160");
	}
	
	public void loginByGoogle() {
		WebElement loginSignUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/nav/a")));
		loginSignUpButton.click();	
		WebElement googleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[1]/div/form[1]/button/img")));
		googleButton.click();	
		WebElement googleNumber = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input"));
		googleNumber.sendKeys("2154165165160");
		WebElement googleSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button")));
		googleSubmit.click();
	}
		
	public static void main(String[] args) throws InterruptedException {
		LoginTest test = new LoginTest();
		test.loginByEmail();
		Thread.sleep(5000);
		test.logout();
		Thread.sleep(5000);	
		test.loginByWhatsApp();
		Thread.sleep(5000);
		driver.get(url);
		test.loginByApple();
		Thread.sleep(5000);
		driver.get(url);
		test.loginByGoogle();
	}
	
}
