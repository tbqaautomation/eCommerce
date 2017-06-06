package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateAddToOrderShelf extends Initialize{

	// ***********************************************************************************
			// Method Name: validateAddToOrderShelf
			// Description: Component used to validate whether Add to Order Shelf is present in PDP screen
			// Created By: Cognizant Technology Solution
			// Date of Creation: 04/13/2017
			// ***********************************************************************************
			
			
		public static void validateAddToOrderShelf() 
		{
			addStepDetails("", "Component used to validate whether Add to Order Shelf is present in PDP screen", "COMMENT");
			System.out.println("Executing Business Component - validateAddToOrderShelf ....");
			
			List<WebElement> element = driver.findElements(By.xpath(Objects.pdf_add_to_order_shelf));
			
			if (element.size() >0)
			{
				addStepDetails("Presence of Add to Order Shelf"," Add to Order Shelf is present in the PDP screen", "PASS");
				System.out.println("Add To Order Shelf is present");
			}
			else
			{
				addStepDetails("Presence of Add to Order Shelf"," Add to Order Shelf is not present in the PDP screen", "FAIL");
				System.out.println("Add To Order Shelf is not present");
			}
		}
		
}
