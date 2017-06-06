package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import objectrepository.Objects;
import startup.Initialize;

public class CheckMaxCartQty extends Initialize {

	// *************************************************************************************************
	// Method Name: CheckMaxCartQty
	// Description: Component used to check the maximum item that can be added to Cart (Multiple Items)
	// Created By: Cognizant Technology Solution
	// Date of Creation: 04/25/2017
	// *************************************************************************************************

	public static void checkMaxCartQty() {
		addStepDetails("", "Component used to check the maximum item that can be added to Cart (Multiple Items)", "COMMENT");
		System.out.println("Executing Business Component - checkMaxCartQty ....");
		waiting(2000);
		
		WebElement element1 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown));
		element1.click();	//Click on Dropdown icon
		waiting(3000);
		WebElement element2 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown + "/ul/li[@selectid='50']"));
		element2.click();	//Click on the required option from Dropdown
		
		WebElement addToOrder = driver.findElement(By.xpath(Objects.cart_btn_AddToCart));
		addToOrder.click();	//Click on the "Add to Order" button
		
		int iteration = Integer.parseInt(testDataSet.get("Iteration"));
		System.out.println("Iteration = " + iteration);
		
		if (iteration == 2)
		{
			try
			{
				driver.findElement(By.xpath("//span[@class='js-mini-cart-count' and contains(.,'50')]"));
				System.out.println("Unable to add more than 50 items in cart (Multiple Items)");
				addStepDetails("Check Max Cart Quantity (Multiple Items)", "User is unable to add more than 50 items in cart (Multiple Items)", "PASS");
			}
			catch (Exception e)
			{
				System.out.println("Able to add more than 50 items in cart (Multiple Items)");
				addStepDetails("Check Max Cart Quantity (Multiple Items)", "User is able to add more than 50 items in cart (Multiple Items)", "FAIL");
			}
		}
		waiting(3000);
	}
}