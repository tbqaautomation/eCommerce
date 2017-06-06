package components;

import java.io.IOException;

import org.openqa.selenium.By;

import objectrepository.Objects;
import startup.Initialize;

public class LaunchSI extends Initialize{

	 //***********************************************************************************
	 //Method Name: launchSI
	 //Description: Component used to launch the SI Application
	 //Created By: Cognizant Technology Solution
	 //Date of Creation: 03/07/2017
	 //***********************************************************************************

   public static void launchSI() throws IOException{
		addStepDetails("", "Component used to launch the Taco Bell SI application", "COMMENT");
		System.out.println("Executing Business Component - launchSI ....");
		
		//Launch the URL");
		driver.get(properties.getProperty("URL"));
		//waitTillObjectLoads(Objects.home_icon_Search,"xpath");
		
		if (GenericMethods.waitForObject("xpath", 20, Objects.home_icon_Search).equals("true"))
		{
			addStepDetails("Launch SI Application", "URL : [" + properties.getProperty("URL") + "] launched successfully", "PASS");
		}
		else
		{
			addStepDetails("Launch SI Application", "Search icon NOT Found after launching URL : [" + properties.getProperty("URL") + "]", "FAIL");
		}
		
		if (driver.findElement(By.xpath(Objects.home_icon_Cart + "/ancestor::div/preceding-sibling::i")) != null)
		{
			addStepDetails("Validate Cart Icon", "Cart Icon Found on Home Page", "PASS");
		}
		else
		{
			addStepDetails("Validate Cart Icon", "Cart Icon Found on Home Page", "FAIL");
		}
		
		
   		String strItemCount = driver.findElement(By.xpath(Objects.home_icon_Cart)).getAttribute("innerHTML");
   		System.out.println("First: " + strItemCount);
   		
   		if (strItemCount.length() != 0)
   		{
   			addStepDetails("Validate Cart Text", "One or more Item is Already Present in Cart", "FAIL");
   		}
		else
		{
			addStepDetails("Validate Cart Text", "No Item Present in Cart", "PASS");
		}
		
		
    }

}
