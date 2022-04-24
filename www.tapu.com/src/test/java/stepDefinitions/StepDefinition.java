package stepDefinitions;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class StepDefinition {	
	WebDriver driver;
	String user_name= "Zeynep";
	String user_surname ="Selçok";
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zeynep Selçok\\eclipse-workspace\\www.tapu.com\\chromedriver.exe");
	}
	
	@Test
	@Given("^User is on \"https://www.tapu.com/\"$")
	public void user_is_on_homepage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tapu.com/");
	}
	
	@And("^User click \"Uye Ol\" button at homepage$")
	public void click_uye_ol_button_homepage() {
		driver.findElement(By.xpath("//a[@href='/kayit-ol']")).click();
	}
	
	@And("User enter name, surname, mobile phone information")
	public void fill_information() {
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(user_name);
		
		WebElement surname = driver.findElement(By.name("surname"));
		surname.sendKeys(user_surname);
		
		
		WebElement mobilephone = driver.findElement(By.xpath("//*[@id=\"signup\"]/div[2]/div/div[2]/input"));
		mobilephone.sendKeys("5001234568");
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"signup\"]/div[3]/div[1]/input"));
		password.sendKeys("123456");
	}
	
	@And("User select the checkboxs of campaignsoffers and membership agreement")
	public void select_checkboxs() {	
		JavascriptExecutor js =(JavascriptExecutor) driver;
		WebElement marketingPermit = driver.findElement(By.xpath("//*[@id=\"marketingPermit\"]"));
		js.executeScript("arguments[0].click();", marketingPermit);
		
		WebElement agreementApprove = driver.findElement(By.xpath("//*[@id=\"agreementApprove\"]"));
		js.executeScript("arguments[0].click();", agreementApprove);
		
	}
	
	@When("^User click \"Uye Ol\" button at uye ol modal$")
	public void click_uye_ol_button() {
		driver.findElement(By.xpath("//*[@id=\"signup\"]/button")).click();
	}
	
	@Then("Close verify modal")
	public void close_verify_modal() {
		JavascriptExecutor js1 =(JavascriptExecutor) driver;
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
		WebElement closeVerify = driver.findElement(By.xpath("//*[@id=\"otp\"]/div/div/header/button"));
		js1.executeScript("arguments[0].click();", closeVerify);
	}
	
	@And("User should be check name and surname")
	public void user_should_be_check_message() {
		String getNameSurname = driver.findElement(By.xpath("/html/body/div[6]/header[1]/div/nav/div[3]/div[2]/a/span")).getText();
		Assert.assertEquals(getNameSurname, user_name + " " + user_surname,"Name and surname matched.");
	}
	
	@And("^User click \"Bilgilerim\" menu$")
	public void click_bilgilerim_menu() {
		driver.findElement(By.xpath("/html/body/div[6]/header[1]/div/nav/div[3]/div[2]/a/svg/use")).click();
		driver.findElement(By.xpath("//*[@id=\"mobile_right_menu\"]/div/nav/ul/li[6]/a")).click();	
	}
	@And("User check name, surname, mobile phone information")
	public void check_information() {
		String name = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div/div/form/div[1]/div/input")).getText();
		Assert.assertEquals(name,"user_name","Name is matched.");
		
		String surname = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div/div/form/div[2]/div/input")).getText();
		Assert.assertEquals(surname,"user_surname","Surname is matched.");
		
		String mobilephone = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div/div/form/div[4]/div/div[2]/input")).getAttribute("value");
		Assert.assertEquals(mobilephone,"5001234568","Mobile phone number is matched.");
	}
	
	@AfterTest
	@And("Close browser")
	public void close_browser() {
	    driver.quit();
	}

}
