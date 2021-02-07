package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.Songs;

public class TestYoutube {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver1\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1)
	public void testSearch() {
		driver.navigate().to("https://www.youtube.com/");
		
		Home.typeSong(driver);
		Home.pressSearch(driver);
		
		String current = driver.getCurrentUrl();
		String expected = Songs.URL;
		
		Assert.assertEquals(current, expected);
	}
	
	@Test(priority = 2)
	public void testPlay() {
		
		driver.navigate().to(Songs.URL);
		
		Songs.playSong(driver);
		
		String current = driver.getCurrentUrl();
		String expected = "https://www.youtube.com/watch?v=Yz9P4Lnulw0";
		
		Assert.assertEquals(current, expected);
	}
	
	
}
