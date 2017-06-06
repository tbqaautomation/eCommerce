package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateUpsellItemOnCart extends Initialize {

	// ***********************************************************************************
		// Method Name: validateupsellitemoncart
		// Description: Component used to validate upsall item on the cart page
		// Created By: Cognizant Technology Solution
		// Date of Creation: 05/18/2017
		// ***********************************************************************************	
	
		
	public void validateupsellitemoncart()
	{
		
		addStepDetails("", "Component used to validate up-sales item on the cart page", "COMMENT");
		System.out.println("Executing Business Component - validateupsellitemoncart ....");
		
		WebElement addtoorder=driver.findElement(By.xpath(Objects.cart_btn_AddToCart));
		
		addtoorder.click();
		
		waiting(10000);
		
		//WebElement cart=driver.findElement(By.xpath("//div[@class='userbar-container']/ul/li/a/div/span[@class='js-mini-cart-count']"));
		
		WebElement cart=driver.findElement(By.xpath(Objects.home_icon_Cart));
		cart.click();
		waiting(2000);
		
		WebElement upsaleproducts= driver.findElement(By.xpath(Objects.cart_upsellitem));
		
		//Scrolling till Pickup Details is Visible
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", upsaleproducts);
		
		
		String strupsaleproducts= upsaleproducts.getText();
		
		System.out.println("strcrosssaleproducts="+strupsaleproducts);
		
		if (strupsaleproducts.equals("You Might Like"))
		{
			addStepDetails("Upsell product", "Upsell products are present on the PDP page", "PASS");
			System.out.println("Upsell products are present on the PDP page");
		}
		else
		{
			addStepDetails("Upsell product", "Upsell products are not present on the PDP page", "FAIL");
			System.out.println("Upsell products are not present on the PDP page");
		}
			
		}
		
	
}
