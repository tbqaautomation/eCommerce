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
import startup.Initialize;

public class ValidateCartCount extends Initialize{

    /************************************************************************
    //Method Name: validateCartCount
    //Description: To validate the item qty displayed in cart
    //Created By: Cognizant Technology Solution
    //Date of Creation: 01/04/2017
   *************************************************************************/
    public static void validateCartCount() throws SQLException 
    {
    	addStepDetails("", "component used to validate the item count in cart Screen", "COMMENT"); 
        System.out.println("Executing Business Component - validateCartCount ....");
        waiting(2000);
        
        try
	   	{
	   		
        	//*[@class='order-title']/a/span
        	int itemIndex = ValidateSearchResult.validateSearchResult();
        	
        	System.out.println(Objects.cart_txtBox_Qty + itemIndex + "']");
        	String strItemCount = driver.findElement(By.xpath(Objects.cart_txtBox_Qty + itemIndex + "']")).getAttribute("value");
	   		System.out.println("Initial: " + strItemCount);
	   		
	   		int InitialCartCnt = Integer.parseInt(strItemCount);
	   		
	   		int ItemCnt = Integer.parseInt(testDataSet.get("Qty"));
	   				 		   		
		 	if (InitialCartCnt==ItemCnt)
   	 		{
   				System.out.println("CartScreen - Item Count in Cart [" + strItemCount + "] Validated Successfully");
   				addStepDetails("CartScreen", "Item Count in Cart [" + strItemCount + "] Validated Successfully", "PASS");
   	 		}
   	 		else
   	 		{
   				System.out.println("CartScreen - Wrong Item Count [" + strItemCount + "] Displayed in Cart");
   				addStepDetails("CartScreen", "Wrong Item Count [" + strItemCount + "] Displayed in Cart", "FAIL");
   	 		}
   	 	} 
		
		catch (Exception e) 
		{
			//System.out.println("CartScreen - " + e.getMessage());
			e.printStackTrace();
			addStepDetails("CartScreen", "An error occured in validating item count", "FAIL");
	   	}
    }

}
