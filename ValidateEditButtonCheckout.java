package components;

import org.openqa.selenium.By;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateEditButtonCheckout extends Initialize{
	/************************************************************************
    //Method Name: ValidateEditButtonCheckout
    //Description: To validate the whether on clicking the edit button in checkout page navigates to Cart
    //Created By: Cognizant Technology Solution
    //Date of Creation: 31/05/2017
   *************************************************************************/
	public static void validateEditButtonCheckout() {
		addStepDetails("", "component used to whether on clicking the edit button in checkout page navigates to Cart", "COMMENT"); 
        System.out.println("Executing Business Component - validateEditButtonCheckout ....");
        waiting(2000);
        
        driver.findElement(By.xpath(Objects.checkout_Edit)).click();
        addStepDetails("Click Edit Button", "Clicked on Edit button in the Checkout Page", "PASS"); 
	    waiting(2000);
	
		if (GenericMethods.waitForObject("xpath", 20, Objects.cart_header).equals("true"))
		{
			addStepDetails("Validate Edit Button", "User successfully navigated to Cart", "PASS");
		}
		else
		{
			addStepDetails("Validate Edit Button", "Unable to find Cart Header in screen", "FAIL");
		}    
  
	}

}
