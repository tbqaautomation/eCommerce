package components;

import startup.Initialize;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import objectrepository.Objects;

public class ItemCount_Checkout extends Initialize{

	 //***********************************************************************************
	 //Method Name: decreaseItem_PDP
	 //Description: Component used to decrease item count from checkout Screen
	 //Created By: Cognizant Technology Solution
	 //Date of Creation: 03/22/2017
	 //***********************************************************************************
	
	public static void itemCount_Checkout()
	{
		addStepDetails("", "Component used to decrease item count from PDP Screen", "COMMENT");
		System.out.println("Executing Business Component - decreaseItem_Checkout ....");
		
		try
	   	{
	   		String strItemCount = driver.findElement(By.xpath(Objects.checkout_btn_qty)).getAttribute("value");
	   		System.out.println("Initial: " + strItemCount);
	   		
	   		int itemCountB4 = 0;
	   		
	   		if (strItemCount.length() != 0)
	   		{
	   				itemCountB4 = Integer.parseInt(strItemCount);
	   		}
	   		
   	 		
	   		String Itemcnt = testDataSet.get("ItemCount");
	   				
   	 		driver.findElement(By.xpath(Objects.checkout_btn_qtyinput)).click();
   	 		driver.findElement(By.xpath(Objects.checkout_btn_qtyinput)).clear();
   	 		driver.findElement(By.xpath(Objects.checkout_btn_qtyinput)).sendKeys(Itemcnt);
   	 		driver.findElement(By.xpath(Objects.checkout_btn_qtyinput)).sendKeys(Keys.ENTER);
   	 		//driver.findElement(By.xpath(Objects.checkout_btn_qtyinput1)).click();
   	 		   	 	
   	 		waiting(1000);
				
			int itemCountNew = Integer.parseInt(driver.findElement(By.xpath(Objects.checkout_btn_qty)).getAttribute("value"));
	 		System.out.println("Changed: " + itemCountNew);
	 		
	 		if (itemCountNew<itemCountB4)
   	 		{
   				System.out.println("CartScreen - Item decreased from Cart");
   				addStepDetails("CartScreen", "Item decreased from Cart", "PASS");
   	 		}
   	 		else if (itemCountNew>itemCountB4)
   	 		{
   				System.out.println("CartScreen - Item increased in Cart");
   				addStepDetails("CartScreen", "Item increased in Cart", "PASS");
   	 		}
   	 		else 
   	 		{
   	 			System.out.println("CartScreen - Error in increment/decrement");
				addStepDetails("CartScreen", "Error in increment/decrement", "FAIL");
   	 		}
	 		
   	 	} 
		
		catch (Exception e) 
		{
			System.out.println("CartScreen - " + e.getMessage());
			addStepDetails("CartScreen", "An error occured in adding the item to Cart", "PASS");
	   	}
	  }

}
