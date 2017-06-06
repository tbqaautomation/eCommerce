package components;

import org.openqa.selenium.By;

import objectrepository.Objects;
import startup.Initialize;

public class NavToCart extends Initialize{

 	 /***********************************************************
    //Method Name: navToCart
    //Description: component to navigate to Cart Screen
    //Created By: Cognizant Technology Solution
    //Date of Creation: 03/22/2017
    //***********************************************************/
	
	public void navToCart() 
     {
   	  	addStepDetails("", "component to navigate to Cart Screen", "COMMENT"); 
	    System.out.println("Executing Business Component - navToCheckout ....");
	    
	    driver.findElement(By.xpath(Objects.home_icon_Cart)).click();
	    waiting(2000);

		if (GenericMethods.waitForObject("xpath", 10, Objects.cart_header).equals("true"))
		{
			addStepDetails("Cart Screen", "User successfully navigated to Cart", "PASS");
		}
		else
		{
			addStepDetails("Cart Screen", "Unable to find Cart Header in screen", "FAIL");
		}    
  
     }

}
