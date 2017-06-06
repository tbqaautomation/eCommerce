package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import objectrepository.Objects;
import startup.Initialize;

public class GuestCheckout extends Initialize{
	
	// ***********************************************************************************
	// Method Name: SelectPickupMethod
	// Description: Component used to Select the Pickup Method
	// Created By: Cognizant Technology Solution
	// Date of Creation: 05/08/2017
	// ***********************************************************************************
	
	public static void guestCheckout()
	{
		addStepDetails("", "Component used to test the Guest Checkout", "COMMENT");
		System.out.println("Executing Business Component - guestCheckout ....");
		waiting(1000);
		
		try
		{
			WebElement element = driver.findElement(By.xpath(Objects.checkout_guest_email));
			System.out.println("Checkout Page_Guest - Email ID field is present for Guest");
			addStepDetails("Checkout Page_Guest", "Email ID field is present for Guest", "PASS");
			String placeholder_text;
			placeholder_text = element.getAttribute("placeholder");
			if (placeholder_text.equals("ex: johnsmith@tb.com"))
			{
				System.out.println("Checkout Page_Guest - Email ID field have the suggested place holder text (ex: johnsmith@tb.com)");
				addStepDetails("Checkout Page_Guest", "Email ID field have the suggested place holder text (ex: johnsmith@tb.com)", "PASS");
			}
			else
			{
				System.out.println("Checkout Page_Guest - Email ID field doesn't have the suggested place holder text (ex: johnsmith@tb.com)");
				addStepDetails("Checkout Page_Guest", "Email ID field doesn't have the suggested place holder text (ex: johnsmith@tb.com)", "FAIL");				
			}
			
			String email = testDataSet.get("Email");
			element.sendKeys(email);
			
			String entered_value;
			entered_value = element.getAttribute("value");
			if (entered_value.equals(email))
			{
				System.out.println("Checkout Page_Guest - Email ID field is a free entry textbox");
				addStepDetails("Checkout Page_Guest", "Email ID field is a free entry textbox", "PASS");
			}
			else
			{
				System.out.println("Checkout Page_Guest - Email ID field is NOT a free entry textbox");
				addStepDetails("Checkout Page_Guest", "Email ID field is NOT a free entry textbox", "FAIL");
			}
		}
		catch (Exception e)
		{
			System.out.println("Checkout Page_Guest - Email ID field is not present for a Guest User");
			addStepDetails("Checkout Page_Guest", "Email ID field is not present for a Guest User", "FAIL");
		}
		
		
		try
		{
			WebElement element_m = driver.findElement(By.xpath(Objects.checkout_guest_mobile));
			System.out.println("Checkout Page_Guest - Mobile field is present for Guest");
			addStepDetails("Checkout Page_Guest", "Mobile field is present for Guest", "PASS");
			String placeholder_text_m;
			placeholder_text_m = element_m.getAttribute("placeholder");
			if (placeholder_text_m.equals("ex: 555-123-4567"))
			{
				System.out.println("Checkout Page_Guest - Mobile field have the suggested place holder text (ex: 555-123-4567m)");
				addStepDetails("Checkout Page_Guest", "Mobile field have the suggested place holder text (ex: 555-123-4567)", "PASS");
			}
			else
			{
				System.out.println("Checkout Page_Guest - Mobile field doesn't have the suggested place holder text (ex: 555-123-4567)");
				addStepDetails("Checkout Page_Guest", "Mobile field doesn't have the suggested place holder text (ex: 555-123-4567)", "FAIL");				
			}
			
			String strMobileNo = testDataSet.get("Mobile");

			for (int i = 0; i < strMobileNo.length(); i++){      
			    element_m.sendKeys(Character.toString(strMobileNo.charAt(i)));
			}
			
			String entered_value_m;
			entered_value_m = element_m.getAttribute("value").replace("-", "");
			if (entered_value_m.equals(strMobileNo))
			{
				System.out.println("Checkout Page_Guest - Mobile field is a free entry textbox");
				addStepDetails("Checkout Page_Guest", "Mobile field is a free entry textbox", "PASS");
			}
			else
			{
				System.out.println("Checkout Page_Guest - Mobile field is NOT a free entry textbox");
				addStepDetails("Checkout Page_Guest", "Mobile field is NOT a free entry textbox", "FAIL");
			}
		}
		catch (Exception e)
		{
			System.out.println("Checkout Page_Guest - Mobile field is not present for a Guest User");
			addStepDetails("Checkout Page_Guest", "Mobile field is not present for a Guest User", "FAIL");
		}
	}
}
