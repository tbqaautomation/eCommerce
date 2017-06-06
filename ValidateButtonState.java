package components;

import org.openqa.selenium.By;


import objectrepository.Objects;
import startup.Initialize;

public class ValidateButtonState extends Initialize {
	// ***********************************************************************************
	// Method Name: validateButtonState
	// Description: Component used to validate Whether Add To Order button is enabled or disabled
	// Created By: Cognizant Technology Solution
	// Date of Creation: 04/24/2017
	// ***********************************************************************************
								
	public static void validateButtonState() {	
		addStepDetails("", "Component used to validate Whether the button is enabled or disabled","COMMENT");
		System.out.println("Executing Business Component - validateButtonState ....");
		
		String strActive = testDataSet.get("State");
		try
		{			
			if (strActive.equals("disabled"))
			{
				String strState = driver.findElement(By.xpath(Objects.cart_btn_AddToCart)).getAttribute(strActive);
				
				if (strActive.contentEquals(strState))
				{
					addStepDetails("Button state","The button is disabled","PASS");
					System.out.println("Button disabled");
				}
			}
			else
			{
				addStepDetails("Button state","The button is enabled","PASS");
				System.out.println("Button enabled");
			}
		}
		catch(Exception e)
		{
			addStepDetails("Button state","The button is not disabled","FAIL");
			System.out.println("Button enabled");
		}
	}

}
