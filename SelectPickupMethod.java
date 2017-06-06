package components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import objectrepository.Objects;
import startup.Initialize;

public class SelectPickupMethod extends Initialize{
	
	// ***********************************************************************************
	// Method Name: SelectPickupMethod
	// Description: Component used to Select the Pickup Method
	// Created By: Cognizant Technology Solution
	// Date of Creation: 05/08/2017
	// ***********************************************************************************
	
	public static void selectPickupMethod()
	{
		addStepDetails("", "Component used to Select the Pickup Method", "COMMENT");
		System.out.println("Executing Business Component - selectPickupMethod ....");
		waiting(3000);
		
		boolean dtDisabled;
		try
		{
			driver.findElement(By.xpath("//button[@id='pickup-time-drive-thru' and @class='drive-thru btn-select-composite' and @disabled='disabled']"));
			dtDisabled = true;
		}
		catch (NoSuchElementException e)
		{
			dtDisabled = false;
		}
		
		boolean isDisabled;
		try
		{
			driver.findElement(By.xpath("//button[@id='pickup-time-in-store' and @class='in-store btn-select-composite' and @disabled='disabled']"));
			isDisabled = true;
		}
		catch (NoSuchElementException e)
		{
			isDisabled = false;
		}
		
		String strMethod = testDataSet.get("Method");
		
		if (strMethod.equals("Drive-Thru") || strMethod.equals("DriveThru") || strMethod.equals("Drive Thru"))
		{
			if (dtDisabled == false)
			{
				driver.findElement(By.xpath(Objects.checkout_drive_thru)).click();
				System.out.println("Successfully clicked on Drive-Thru option");
				addStepDetails("Checkout Page", "Successfully clicked on Drive-Thru option", "PASS");
			}
			else if (isDisabled == false)
			{
				driver.findElement(By.xpath(Objects.checkout_in_store)).click();
				System.out.println("'Drive-Thru' option in not available, clickin on 'In Store'");
				addStepDetails("Checkout Page", "'Drive-Thru' option in not available, clicked on 'In Store'", "FAIL");			
			}
			else
			{
				System.out.println("Any of the Pickup Method in not available");
				addStepDetails("Checkout Page", "Any of the Pickup Method in not available", "FAIL");
			}
		}
		else if (strMethod.equals("In-Store") || strMethod.equals("InStore") || strMethod.equals("In Store"))
		{
			if (isDisabled == false)
			{
				driver.findElement(By.xpath(Objects.checkout_in_store)).click();
				System.out.println("Successfully clicked on In Store option");
				addStepDetails("Checkout Page", "Successfully clicked on In Store option", "PASS");
			}
			else if (dtDisabled == false)
			{
				driver.findElement(By.xpath(Objects.checkout_drive_thru)).click();
				System.out.println("'In Store' option in not available, clickin on 'Drive-Thru'");
				addStepDetails("Checkout Page", "'In Store' option in not available, clickin on 'Drive-Thru'", "FAIL");
			}
			else
			{
				System.out.println("Any of the Pickup Method in not available");
				addStepDetails("Checkout Page", "Any of the Pickup Method in not available", "FAIL");
			}
		}
		else
		{
			addStepDetails("Checkout Page", "Wrong option selected for 'Method' in TestCase file", "FAIL");
			System.out.println("Wrong option selected for 'Method' in TestCase file");
		}
	}
}
