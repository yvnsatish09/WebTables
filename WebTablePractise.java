package ShoppingCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTablePractise extends WebTable {

	
	  @Test(priority=1,description="Get the all Table Headers") public void
	  getTableHeaders() {
	  
	  startBrowser();
	  
	  System.out.println("Get all Table Headers"); List<WebElement> allHeaders =
	  driver.findElements(By.xpath(""+ StringXpath+"/thead/tr/th"));
	  System.out.println(" Total Headers found "+allHeaders.size()); 
        
          for(WebElement eachHeader:allHeaders) { 
	  System.out.println(eachHeader.getText()); // Fetch the each header of the table
	  
	  } 
	 
      }
	  
	  
	  @Test(priority=2,description="Get the all Table Headers and Rows")
	  
	  public void RowsAndHeaders() {
	  
	  System.out.println("Get the all Headers and all Rows of the Table");
	  
	  Total columns are System.out.println("Total Columns are  " + column.size());
	 
	  System.out.println("Total Rows are " + rows.size()); 
          System.out.println("==========================================================================================");
	 
	  driver.close(); 
       }
	  
	  
	  
	  
	  @Test(priority=3,
	  description="Get the employee whose position is Software Engineer")
	   public  void getEmployeePosition() { startBrowser();
	  System.out.println("Fetch the employee Whose name is Software Engineer"); 
         //  First we need to locate the Second column of the Table and search for Software Engineer 
	 System.out.println("Get All emp Names of " + empRole + " Position===== ");
	 for(int i=1;i<rows.size();i++) {
	 
	  //Fetch the EmployeePosition Column of the Table, here we are iterating the 2nd Column 
         WebElement posColumn=driver.findElement(By.xpath(""+StringXpath+"/tbody/tr["+ i+"]/td["+ emPosColumn +"]")); //here EmployeePositionColumn=2
         
          // empRole = SoftwareEngineer
	  if(posColumn.getText().equalsIgnoreCase(empRole)) { 
	  
	  //Fetch the First Column Employe Name of Table & empNameColumn= 1 
           WebElement empNameColumn1 = driver.findElement(By.xpath(""+StringXpath+"/tbody/tr["+ i+"]/td[" + empNameColumn + "]"));
	  System.out.println(empNameColumn1.getText());

	 } // if
     } // for 
 }
	 
	@Test(priority = 4, description = "Get the name of the employees Age>40")
	public void getAge() {
		startBrowser();
		System.out.println("Get All  employee Names whose  Age>40 ");
		for (int i = 1; i < rows.size(); i++) {

			// Fetch the Employee Age Column of the Table, here we are iterating the 4th
			// Column
			WebElement ageColumn = driver
					.findElement(By.xpath("" + StringXpath + "/tbody/tr[" + i + "]/td[" + empAgeColumn + "]"));
			// here we are Convert the String in to the text type & it is greater than 40
			if (Integer.parseInt(ageColumn.getText()) >= empAge) { // int empAge=40;

				// fetch the 1st Column Employee Names of the table
				WebElement empName = driver
						.findElement(By.xpath("" + StringXpath + "/tbody/tr[" + i + "]/td[" + empNameColumn + "]"));
				System.out.println(empName.getText());

			}
			System.out.println("**********************************************************************************");
		}

	}

	@Test(priority = 4, description = "Get the name of the employees Age>40")
	public void getLastRow() {

		System.out.println("Fetch the last row of the Table");
		// Fetch the lastRow of the WebTable
		List<WebElement> lastRow = driver.findElements(By.xpath("" + StringXpath + "/tbody/tr[last()]/td"));
		for (WebElement e : lastRow) {
			System.out.print(e.getText() + " "); // Fetch the text of lastrow
		}
		System.out.println();
		System.out.println("**********************************************************************************");
	}

	// Test Case :5 get the Particular Cell Value

	@Test(priority = 5, description = "Get the Particular Cell Value")
	public void getParticularCellValue() {
		System.out.println("Get the Particular Cell Value");
		String xPath = "//table";
		int rowNum = 2;
		int coluNum = 3;

		WebElement value = driver.findElement(By.xpath("" + xPath + "/tbody/tr[" + rowNum + "]/td[" + coluNum + "]"));
		System.out.println("Fetch the Cell Value  is :" + value.getText());
		System.out.println("**********************************************************************************");
	}

	// Test Case :6 get the Particular Cell Value by Generic Method
	@Test(priority = 6, description = "Get the Particular Cell Value using Generic Method")
	public void getCellGenericMethod() {
		System.out.println("Fetch the value using Generic Method");

		System.out.println("Retrive the Providing Cell Value ");
		System.out.println("Generic Text is: " + getColumnValue(3, 3)); // generic Method row=3,Column=3
		System.out.println("**********************************************************************************");
	}

	@Test(priority = 7, description = "Get the All Rows and Columns in the Table")
	public void getAllTableData() {
		System.out.println("Get All the table Data");

		for (int i = 1; i < rows.size(); i++) {

			for (int j = 1; j <= column.size(); j++) {

				String tableData = driver.findElement(By.xpath(" " + xPath + "/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText() + "  ";
				System.out.println(tableData);
			}
			
			System.out.println();
			System.out.println();
			System.out.println("**********************************************************************************");
		}
	}
}
