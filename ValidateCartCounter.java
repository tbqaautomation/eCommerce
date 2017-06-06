package components;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Objects;
//import startup.Initial;
import startup.Initialize;

public class ValidateCartCounter extends Initialize{

    /************************************************************************
    //Method Name: employeeSearch
    //Description: component used to validate the search for an employee in the Employee search page
    //Created By: Cognizant Technology Solution
    //Date of Creation: 01/04/2017
   *************************************************************************/
    public static void validateCartCounter() throws SQLException 
    {
    	addStepDetails("", "component used to validate the item count in cart in Cart Icon", "COMMENT"); 
        System.out.println("Executing Business Component - validateCartCounter ....");
        waiting(2000);
        
        try
	   	{
	   		String strItemCount = driver.findElement(By.xpath(Objects.cart_indicator)).getText();
	   		System.out.println("Initial: " + strItemCount);
	   		
	   		int InitialCartCnt = Integer.parseInt(strItemCount);
	   		
	   		int ItemCnt = Integer.parseInt(testDataSet.get("ItemCount"));
	   				 		   		
		 	if (InitialCartCnt==ItemCnt)
   	 		{
   				System.out.println("CartScreen - Item Counter increased by 1");
   				addStepDetails("CartScreen", "Item Counter increased by 1", "PASS");
   	 		}
   	 		else
   	 		{
   				System.out.println("CartScreen - Counter increament Failed");
   				addStepDetails("CartScreen", "Counter increament Failed", "FAIL");
   	 		}
   	 	} 
		
		catch (Exception e) 
		{
			System.out.println("CartScreen - " + e.getMessage());
			addStepDetails("CartScreen", "An error occured in validating item count", "FAIL");
	   	}
    }

}
