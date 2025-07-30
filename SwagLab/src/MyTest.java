import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest {

	private static final boolean False = false;
	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void mysetup() {

		driver.get("https://www.saucedemo.com/");
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() {
		
		driver.navigate().back();

		// Elements
		WebElement UesrNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputFild = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		// Action
		UesrNameInputField.sendKeys("standard_user");

		PasswordInputFild.sendKeys("secret_sauce");

		LoginButton.click();

	}

	@Test(priority = 2)
	public void addToCard() {
		// Elements
		WebElement FirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement SecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

		// Action
		FirstItem.click();
		SecondItem.click();
	}

	@Test(priority = 3)
	public void ChekeOutProcess() {
		driver.navigate().to("https://www.saucedemo.com/cart.html");
		WebElement ChekeOutButton = driver.findElement(By.id("checkout"));
		ChekeOutButton.click();
		// Element
		WebElement FirstName = driver.findElement(By.id("first-name"));
		WebElement lastName = driver.findElement(By.id("last-name"));
		WebElement PostalCode = driver.findElement(By.id("postal-code"));
		// Action
		FirstName.sendKeys("omar");
		lastName.sendKeys("hatem");
		PostalCode.sendKeys("11950");

		WebElement ContinueButton = driver.findElement(By.name("continue"));

		ContinueButton.click();

		WebElement finishButton = driver.findElement(By.name("finish"));
		finishButton.click();

	}

	@Test(priority = 4, enabled = False)
	public void logout() throws InterruptedException {

		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
		BurgerMenu.click();
		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.id("logout_sidebar_link"));
		Logout.click();

	}

}
