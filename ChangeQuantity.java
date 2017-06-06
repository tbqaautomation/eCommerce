package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;


public class ChangeQuantity extends Initialize {

	// ***********************************************************************************
	// Method Name: ChangeQuantity
	// Description: Component used to search an item from Home Screen
	// Created By: Cognizant Technology Solution
	// Date of Creation: 03/07/2017
	// ***********************************************************************************

	public void changeQuantity() {
		addStepDetails("", "Component used to change the item quantity in Cart Page", "COMMENT");
		System.out.println("Executing Business Component - changeQuantityCart ....");
		waiting(2000);
		String strQty = testDataSet.get("Qty");
		driver.findElement(By.xpath(Objects.cart_txtBox_Qty)).click();

		driver.findElement(By.xpath(Objects.cart_txtBox_Qty)).clear();		

		driver.findElement(By.xpath(Objects.cart_txtBox_Qty)).sendKeys(strQty);
		driver.findElement(By.xpath(Objects.cart_txtBox_Qty)).sendKeys(Keys.ENTER);

		if (strQty.equals(0)) {
			List<WebElement> element = driver.findElements(By.xpath(Objects.empty_cart));

			if (element.size() > 0) {
				System.out.println("Cart is Empty");
				addStepDetails("Change Item Quantity to Zero", "Items removed from cart succesfully", "PASS");
			} else {
				System.out.println("Cart is not Empty");
				addStepDetails("Change Item Quantity to Zero", "Items are not removed from cart", "FAIL");
			}
		} 
		else if(strQty.equals(50))
		{
			List<WebElement> element = driver.findElements(By.xpath(Objects.empty_cart));

			if (element.size() > 0) {
				System.out.println("Cart is Full");
				addStepDetails("Change Item Quantity to" + strQty, "Item Quantity is changed succesfully.Cart is Full", "PASS");
			} else {
				System.out.println("Item Quantity is not Changed to " + strQty);
				addStepDetails("Change Item Quantity to" + strQty, "Item Quantity is not changed", "FAIL");
			}	
		}
		else if(Integer.valueOf(strQty) > 0 && Integer.valueOf(strQty) <= 49)
		{
			String strValue = driver.findElement(By.xpath(Objects.cart_txtBox_Qty)).getAttribute("value");

			if (strValue.equals(strQty)) {
				System.out.println("Item Quantity is Changed to " + strQty);
				addStepDetails("Change Item Quantity to " + strQty, "Item Quantity is changed succesfully", "PASS");
			} else {
				System.out.println("Item Quantity is not Changed to " + strQty);
				addStepDetails("Change Item Quantity to " + strQty, "Item Quantity is not changed ", "FAIL");
			}
		}
	}
}