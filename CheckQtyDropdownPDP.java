package components;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import objectrepository.Objects;
import startup.Initialize;
//import startup.Initial;

public class CheckQtyDropdownPDP extends Initialize {

	// ***********************************************************************************
	// Method Name: CheckQtyDropdownPDP
	// Description: Component used to check the Quantity Dropdown in the PDP Screen
	// Created By: Cognizant Technology Solution
	// Date of Creation: 04/20/2017
	// ***********************************************************************************

	public static void checkQtyDropdownPDP() {
		addStepDetails("", "Component used to check the Quantity Dropdown in the PDP Screen", "COMMENT");
		System.out.println("Executing Business Component - checkQtyDropdownPDP ....");
		waiting(2000);
		
		List<WebElement> element = driver.findElements(By.xpath(Objects.pdp_QtyDropdown + "//li[@selectid]"));
		if (element.size() == 50)
		{
			System.out.println("Quantity Dropdown is Present");
			addStepDetails("Check Quantity Dropdown", "Quantity Dropdown is Present with all the options", "PASS");
		}
		else
		{
			System.out.println("Quantity Dropdown is Not Present");
			addStepDetails("Check Quantity Dropdown", "Quantity Dropdown is Not Present or doesn't have all the options", "FAIL");
		}
		
		int r = GenericMethods.getRandomInteger(0,49);
		System.out.println("Random = " + r);
		testDataSet.put("Qty", Integer.toString(r));
		AddToCartFromPDPMultipleQty.addToCartFromPDPMultipleQty();
		
/*		WebElement element1 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown));
		element1.click();	//Click on Dropdown icon
		waiting(3000);
		WebElement element2 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown + "/ul/li[@selectid='" + r + "']"));
		element2.click();	//Click on the required option from Dropdown
		
		WebElement addToOrder = driver.findElement(By.xpath(Objects.cart_btn_AddToCart));
		addToOrder.click();	//Click on the "Add to Order" button
		waiting(10000);

		WebElement goToCart = driver.findElement(By.xpath(Objects.home_icon_Cart));
		goToCart.click();
		
		int quantityAdded = Integer.parseInt(driver.findElement(By.xpath(Objects.cart_txtBox_Qty)).getAttribute("value"));
		
		if (quantityAdded == r)
		{
			System.out.println("User is able to add order quantity successfully");
			addStepDetails("Check Quantity Dropdown", "User is able to add order quantity successfully from PDP screen", "PASS");
		}
		else
		{
			System.out.println("User is unable to add order quantity");
			addStepDetails("Check Quantity Dropdown", "User is unable to add order quantity from PDP screen", "FAIL");
		}*/
		
	}
}