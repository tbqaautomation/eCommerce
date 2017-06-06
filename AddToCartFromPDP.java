package components;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import objectrepository.Objects;
import startup.Initialize;

public class AddToCartFromPDP extends Initialize{

    /*****************************************************************
    //Method Name: addToCartFromPDP
    //Description: component to add an item to Cart from Item PDP Screen
    //Created By: Cognizant Technology Solution
    //Date of Creation: 03/18/2017
    /*****************************************************************/

    public void addToCartFromPDP()
    {
    	addStepDetails("", "Component to Add Item to Cart from Item PDP Screen", "COMMENT");
   	 	System.out.println("Executing Business Component - addToCartFromPDP ....");
   	 	
   	 	try
	   	{
	   		String strItemCount = driver.findElement(By.xpath(Objects.home_icon_Cart)).getAttribute("innerHTML");
	   		System.out.println("Original: " + strItemCount);
	   		int itemCountB4 = 0;
	   		
	   		if (strItemCount.length() != 0)
	   		{
	   			itemCountB4 = Integer.parseInt(strItemCount);
	   		}
	   		System.out.println("itemCountB4: " + itemCountB4);
	   		
			String strInputQty = testDataSet.get("Qty");
			//System.out.println("Abc:" +strInputQty+ "Abc");
			int intQty = Integer.parseInt(strInputQty);
			
			if (intQty <= 0)
			{
				throw new IOException("Input Quantity Cannot be 0 or less");
			}
			else if (intQty == 1)
			{
	   	 		driver.findElement(By.xpath(Objects.cart_btn_AddToCart)).click();
			}
			else
			{
				WebElement element1 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown));
				System.out.println(element1.getSize());
				
				if (strPlatform.equalsIgnoreCase("Desktop"))
				{
					element1.click(); //Click on Dropdown icon
				}
				else
				{		    
				    Actions build = new Actions(driver);
			        int width = element1.getSize().getWidth();
			        build.moveToElement(element1).moveByOffset((width/2)-2, 0).click().perform();
				}
					
				waiting(3000);
				
				int sizeDrpDwn = driver.findElements(By.xpath(Objects.pdp_QtyDropdown + "//li[@selectid]")).size();
				if (sizeDrpDwn == 50)
				{
					System.out.println("Presence of Quantity Dropdown - Quantity Dropdown is Present with 50 values");
					addStepDetails("Presence of Quantity Dropdown", "Quantity Dropdown is Present with 50 values", "PASS");
				}
				else
				{
					System.out.println("Presence of Quantity Dropdown - Quantity Dropdown is NOT Present with 50 values");
					addStepDetails("Presence of Quantity Dropdown", "Quantity Dropdown is NOT Present with 50 values", "FAIL");
				}
				
				
				WebElement element2 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown + "/ul/li[@selectid='" + intQty + "']"));
				element2.click();	//Click on the required option from Dropdown
				
				WebElement addToOrder = driver.findElement(By.xpath(Objects.cart_btn_AddToCart));
				addToOrder.click();	//Click on the "Add to Order" button
			}
   	 		
   	 		if (GenericMethods.waitForObject("xpath", 5, Objects.modal_itemAdded).equals("true"))
   			{
	   	 		if (strPlatform.equalsIgnoreCase("Desktop"))
	   	 		{
	   	 			driver.findElement(By.xpath("//div[@class='title']/i[@class='icon-close']")).click();
	   	 			System.out.println("Item Added - [Item Added] Modal Window Appeared");
	   	 			addStepDetails("Item Added", "[Item Added] Modal Window Appeared", "PASS");
	   	 			
/*	   	 			while (GenericMethods.waitForObject("xpath", 1, Objects.modal_itemAdded).equals("true"))
	   				{
	   					waiting(1000);
	   					System.out.println("[Item Added] Modal window Still Present on Screen");
	   				}*/
	   	 		}
	   	 		else
	   	 		{
	   	 			System.out.println("Item Added - [Item Added] Modal window Appeared in Mobile");
	   	 			addStepDetails("Item Added", "[Item Added] Modal window Appeared in Mobile", "FAIL");
	   	 		}

   			}
   			else
   			{
   				if (strPlatform.equalsIgnoreCase("Desktop"))
   				{
   	   				System.out.println("Item Added - [Item Added] Modal window did NOT Appear");
   	   				addStepDetails("Item Added", "[Item Added] Modal window did NOT Appear", "FAIL");
   				}
   				else
   				{
   	   				System.out.println("Item Added - [Item Added] Modal window did NOT Appear in Mobile");
   	   				addStepDetails("Item Added", "[Item Added] Modal window did NOT Appear in Mobile", "PASS");
   				}
   			}   	 		
   	 		
   	 		int itemCountNew = Integer.parseInt(driver.findElement(By.xpath(Objects.home_icon_Cart)).getAttribute("innerHTML"));
   	 		System.out.println("New: " + itemCountNew);
   	 	
   	 		if (itemCountNew == (itemCountB4+intQty))
   	 		{
   				System.out.println("Add To Cart - " + strInputQty + " Item(s) Added To Cart");
   				addStepDetails("Add To Cart", strInputQty + " Item(s) Added To Cart", "PASS");
   	 		}
   	 		else
   	 		{
   				System.out.println("Add To Cart - Unable To Add Specified Quantity of Item To Cart");
   				addStepDetails("Add To Cart", "Unable To Add Specified Quantity of Item To Cart", "FAIL");
   	 		}


	   	} catch (Exception e) {
			System.out.println("Add To Cart - " + e.getMessage());
			addStepDetails("Add To Cart", "An error occured in adding the item to Cart", "FAIL");
	   	}
    }
}
