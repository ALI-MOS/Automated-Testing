package abber;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpTest {
	public static String url = "https://abber.co/";

	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public SignUpTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 	
		driver.get(url);
	}
	
	public void signUpByEmail() {
		WebElement loginSignUpButton = driver.findElement(By.xpath("/html/body/header/div/nav/a"));
		loginSignUpButton.click();
		WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[1]/div/form[4]/button")));
		signupButton.click();
		WebElement signup2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/a")));
		signup2Button.click();
		WebElement name = driver.findElement(By.cssSelector("#id_first_name"));
		name.sendKeys("My new Name");
		WebElement email = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[2]/div/input"));
		email.sendKeys("myemail@example.com");
		WebElement password = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[3]/div/input"));
		password.sendKeys("mypassword12");
		WebElement phoneNumber = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[4]/div[1]/div[1]/div/div/input"));
		phoneNumber.sendKeys("201255573490");	
		WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/form/fieldset/div[3]/div/input")));
		checkBox.click();
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/form/fieldset/div[6]/button")));
		submit.click();
		}
	
	public static void main(String[] args) throws InterruptedException {
		SignUpTest test = new SignUpTest();
		test.signUpByEmail();
	}
	
	

}
