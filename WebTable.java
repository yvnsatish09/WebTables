package ShoppingCart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	
		public WebDriver driver;
	
		// Test Case#1
		String StringXpath= "//table[@id='example']";
		String xPath="//table";
		
		// TestCase #2
		List<WebElement> column; // (headers)
		List<WebElement> rows;
		
		
		
		// TestCase#3
		
		String empRole="Software Engineer"; 
		
		int emPosColumn= 2;   //table//tbody/thead/tr/td[2]
		int empNameColumn= 1;   //table//tbody/thead/tr/td[1] // if this condition is Satisfied fetch the name of employee
		
		// Test Case #4
		
		int empAge=40;
		int empAgeColumn=4; //it is located in 4th Column
	
		
		
		
	public  void startBrowser() {
			
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//js.executeScript("window.scrollBy(0,500)");
			
			column=driver.findElements(By.xpath(""+ StringXpath+"/thead/tr/th")); // Count all  Columns of Table
			rows=driver.findElements(By.xpath(""+ StringXpath+"//tbody/tr")); // Count  all Rows of Table
			
			
		}

	
	public String getColumnValue(int row,int column) {
		
		WebElement colValue=driver.findElement(By.xpath(""+ xPath+"/tbody/tr["+ row +"]/td["+ column +"]"));
		return  colValue.getText();
	}

	}


