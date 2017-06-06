package components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class Validate_Addon extends Initialize {

	/*****************************************************************
    //Method Name: validate addon
    //Description: component to find and the add on items 
    //Created By: Cognizant Technology Solution
    //Date of Creation: 04/25/2017
    /*****************************************************************/
	
	
	public void validate_Addon()
	{
		
		addStepDetails("", "component to find and the add on items ", "COMMENT");
		System.out.println("Executing Business Component - validate_Addon ....");
		
   WebElement itemprice=driver.findElement(By.xpath(Objects.pdp_itemprice));
   String strItemPrice = itemprice.getText();
   
   System.out.println("itemprice " + itemprice.getText());
   
		    
   	WebElement AddonItem=driver.findElement(By.xpath(Objects.pdp_addon_fresco));
   	AddonItem.click();
   	
   	System.out.println("AddonItem " + AddonItem.getText());
   	
   	WebElement updateditemprice=driver.findElement(By.xpath(Objects.pdp_itemprice));
    String strUpdatedItemPrice = updateditemprice.getText();
    
    System.out.println("updateditemprice " + updateditemprice.getText());
    
    if(strUpdatedItemPrice.equals(strItemPrice))
    {
    	addStepDetails("Item Price", "Items price does not get updated", "FAIL");
		System.out.println("Items price does not get updated");
    }
    else
    {
    	addStepDetails("Item Price", "Items price got updated successfully", "PASS");
		System.out.println("Items price got updated successfully");
    	
    }
   	
		
	}

}