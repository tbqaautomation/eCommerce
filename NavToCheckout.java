package components;

import org.openqa.selenium.By;
import objectrepository.Objects;
import startup.Initialize;

public class NavToCheckout extends Initialize{

 	 /***********************************************************
    //Method Name: navToCheckout
    //Description: component to navigate to Checkout Screen
    //Created By: Cognizant Technology Solution
    //Date of Creation: 03/22/2017
    //***********************************************************/
	
	public void navToCheckout()
     {
   	  	addStepDetails("", "Component to Navigate to Checkout Screen", "COMMENT"); 
	    System.out.println("Executing Business Component - navToCheckout ....");
	    
	    //verifying presence of checkout btn of cart page and click accordingly
	    if (driver.findElements(By.xpath(Objects.cart_btn_Checkout)).size() > 0)
	    {
	    	driver.findElement(By.xpath(Objects.cart_btn_Checkout)).click();
	    }
	    else
	    {
	    	driver.findElement(By.xpath("//div[@class='buttons']/a[@class='btn btn-primary checkout']")).click();
	    }

		if (GenericMethods.waitForObject("xpath", 10, Objects.checkout_btn_Guest).equals("true"))
		{
			addStepDetails("Checkout Options", "User successfully navigated to Checkout Options Selection Screen", "PASS");
			System.out.println("User successfully navigated to Checkout Options Selection Screen");
		}
		else
		{
			System.out.println("Unable to find [Guest Checkout] button in screen");
			addStepDetails("Checkout Options", "Unable to find [Guest Checkout] button in screen", "FAIL");
		}
		
		String strType = testDataSet.get("Type").toLowerCase();
		
		switch(strType)
		{
		case "guest":
			
			driver.findElement(By.xpath(Objects.checkout_btn_Guest)).click();
			
			if (GenericMethods.waitForObject("xpath", 10, Objects.checkout_hdr_ReviewOrder).equals("true"))
			{
				addStepDetails("Checkout Screen", "Guest User successfully navigated to Checkout Screen", "PASS");
				System.out.println("Guest User successfully navigated to Checkout Screen");
			}
			else
			{
				System.out.println("Unable to find [Review Order] section in screen");
				addStepDetails("Checkout Screen", "Unable to find [Review Order] section in screen", "FAIL");
			}			
			break;
			
		case "reg":
			
			String strEmail = testDataSet.get("Email");
			String strPw = testDataSet.get("Password");
			
			driver.findElement(By.xpath(Objects.checkout_txtbox_email)).sendKeys(strEmail);
			addStepDetails("Email", "Email Address [" + strEmail + "] is entered", "PASS");
			System.out.println("Email Address [" + strEmail + "] is entered");
			
			driver.findElement(By.xpath(Objects.checkout_txtbox_pw)).sendKeys(strPw);
			addStepDetails("Password", "Password [" + strEmail + "] is entered", "PASS");
			System.out.println("Password [" + strEmail + "] is entered");
			
			driver.findElement(By.xpath(Objects.checkout_btn_SignIn)).click();
			
			break;
			
		case "fb":
			
			driver.findElement(By.xpath(Objects.checkout_btn_Fb)).click();
			System.out.println("Checkout using FB part is still not coded");
			break;
			
		case "else":
			
			addStepDetails("Checkout Options Selection", "Please specify correct Checkout Options in your test data", "FAIL");
			System.out.println("Please specify correct Checkout Options in your test data");
			break;
		}
  
     }

}
