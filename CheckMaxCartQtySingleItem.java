package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import objectrepository.Objects;
import startup.Initialize;

public class CheckMaxCartQtySingleItem extends Initialize {

	// *************************************************************************************************
	// Method Name: CheckMaxCartQtySingleItem
	// Description: Component used to check the maximum item that can be added to Cart (Single Item)
	// Created By: Cognizant Technology Solution
	// Date of Creation: 04/26/2017
	// *************************************************************************************************

	public static void checkMaxCartQtySingleItem() {
		addStepDetails("", "Component used to check the maximum item that can be added to Cart (Single Item)", "COMMENT");
		System.out.println("Executing Business Component - checkMaxCartQtySingleItem ....");
		waiting(2000);
		
		int r = GenericMethods.getRandomInteger(10,25);
		System.out.println("Random = " + r);
		
		WebElement element1 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown));
		element1.click();		//Click on Dropdown icon
		waiting(3000);
		WebElement element2 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown + "/ul/li[@selectid='" + r + "']"));
		element2.click();		//Click on the required option from Dropdown
		
		int totalCart = 0;
		
		while (totalCart < 51)
		{
			WebElement addToOrder = driver.findElement(By.xpath(Objects.cart_btn_AddToCart));
			addToOrder.click();		//Click on the "Add to Order" button
			
			totalCart = totalCart + r;
			System.out.println("TotalCart = " + totalCart);
			
			if (totalCart < 51)
			{
				try
				{
					waiting(10000);
					driver.findElement(By.xpath("//span[@class='js-mini-cart-count' and contains(.,'" + totalCart + "')]"));
					System.out.println("Item quantity is successfully added to cart");
					addStepDetails("Check Max Cart Quantity (Single Item)", "Item quantity is successfully added to cart (Single Item)", "PASS");
					waiting(10000);
				}
				catch (Exception e)
				{
					System.out.println("Item quantity is not added properly to cart");
					addStepDetails("Check Max Cart Quantity (Single Item)", "Item quantity is not added properly to cart (Single Item)", "FAIL");
				}
			}
			else
			{
				try
				{
					driver.findElement(By.xpath(Objects.max_cart_error));
					System.out.println("Unable to add more than 50 items in cart (Single Item)");
					addStepDetails("Check Max Cart Quantity (Single Item)", "User is unable to add more than 50 items in cart (Single Item)", "PASS");
				}
				catch (Exception e)
				{
					System.out.println("Able to add more than 50 items in cart (Single Item)");
					addStepDetails("Check Max Cart Quantity (Single Item)", "User is able to add more than 50 items in cart (Single Item)", "FAIL");
				}
			}
		}
	}
}