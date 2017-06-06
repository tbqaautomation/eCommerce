package components;

import org.openqa.selenium.By;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateExitCheckoutModal extends Initialize{
	/************************************************************************
    //Method Name: ValidateExitCheckoutModal
    //Description: To validate the exit checkout modal in checkout page
    //Created By: Cognizant Technology Solution
    //Date of Creation: 31/05/2017
   *************************************************************************/
	public static void validateExitCheckoutModal() {
		addStepDetails("", "component used To validate the exit checkout modal in checkout page", "COMMENT"); 
        System.out.println("Executing Business Component - validateExitCheckoutModal ....");
        waiting(2000);
        
        driver.findElement(By.xpath(Objects.checkout_TBlogo)).click();
        addStepDetails("Click Tacobell logo", "Clicked on Tacobell logo in the Checkout Page", "PASS"); 
	    waiting(2000);
	    
		if (GenericMethods.waitForObject("xpath", 20, Objects.exit_checkout_Modal).equals("true"))
		{
			addStepDetails("Validate Exit Checkout Modal", "Modal is displayed on the screen", "PASS");
			
		    String strTemp = driver.findElement(By.xpath(Objects.exit_checkout_Modal_Content)).getText();
		    if(strTemp.contains("If you leave your pack won't be saved."))
		    {
		    	  addStepDetails("Exit Checkout Modal Content", "Modal content is validated successfully", "PASS");
		    	  driver.findElement(By.id(Objects.checkout_KeepBuilding_btn)).click();
		    	  waiting(2000);
		    	  addStepDetails("Click Keep Building", "Clicked on Keep Building in the Exit Checkout Modal", "PASS"); 
		    }
		    else
		    	 addStepDetails("Exit Checkout Modal Content", "Modal content is not as expected"+strTemp, "FAIL");
		  
		}
		else
		{
			addStepDetails("Validate Exit Checkout Modal", "Unable to find Cart Header in screen", "FAIL");
		}  
	}

}
