import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practes {
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
	public void AddallitemToTheCart() {
		driver.findElements(By.className(".btn.btn_primary.btn_small.btn_inventory"));

// static
		String[] mynames = { "ahmad", "ali", "anas", "omar" };

		System.out.println(mynames.length);

		List<WebElement> AllAddbuttons = driver.findElements(By.className("btn_primary"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AllThePrices = driver.findElements(By.className("inventory_item_price"));

		for (int i = 0; i < AllAddbuttons.size(); i++) {
			if (i % 2 == 0) {
				AllAddbuttons.get(i).click();
				System.out.println(
						ItemsNames.get(i).getText() + " has been added the price is " + AllThePrices.get(i).getText());

			}else {
				System.out.println(
						ItemsNames.get(i).getText() + " has not been added the price is " + AllThePrices.get(i).getText());	
			}
			
		}
		
	}

}
