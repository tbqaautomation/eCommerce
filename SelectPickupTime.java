package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import objectrepository.Objects;
import startup.Initialize;

public class SelectPickupTime extends Initialize{
	
	// ***********************************************************************************
	// Method Name: SelectPickupLocation
	// Description: Component used to Select the Pickup Time
	// Created By: Cognizant Technology Solution
	// Date of Creation: 05/02/2017
	// ***********************************************************************************
		
	public static void selectPickupTime()
	{
		addStepDetails("", "Component used to Select the Pickup Time", "COMMENT");
		System.out.println("Executing Business Component - selectPickupTime ....");
		waiting(3000);
		
		WebElement element = driver.findElement(By.xpath(Objects.checkout_Now));
        Actions action = new Actions(driver);
        
        //Scrolling till Pickup Details is Visible
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        
        action.moveToElement(element).perform();	//Hovering to the Button "NOW" so that the click-able link gets enabled
        driver.findElement(By.xpath(Objects.checkout_Now + "/i")).click();
        System.out.println("Test2");
        
		if (driver.findElement(By.xpath("//div[@id='choose-info-result']/div[contains(.,'Nice!')]")).isDisplayed())
		{
			addStepDetails("Checkout Page", "Pickup Time is Clicked successfully", "PASS");
			System.out.println("Pickup Time is Clicked successfully");
		}
		else
		{
			addStepDetails("Checkout Page", "Pickup Time is Not Available or is Not Clicked", "FAIL");
			System.out.println("Pickup Time is Not Available or is Not Clicked");
		}
	}
}
