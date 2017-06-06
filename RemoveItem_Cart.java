package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class RemoveItem_Cart extends Initialize{
	
    /*****************************************************************
    //Method Name: addToCartFromPDP
    //Description: component to add an item to Cart from Item PDP Screen
    //Created By: Cognizant Technology Solution
    //Date of Creation: 03/18/2017
    /*****************************************************************/

    public void removeItem_Cart()
    {
    	addStepDetails("", "component to remove item from Cart", "COMMENT");
   	 	System.out.println("Executing Business Component - removeItem_Cart ....");
   	 	
   	 	if (properties.getProperty("Platform").equalsIgnoreCase("Desktop"))
   	 	{
   	 		driver.findElement(By.xpath(Objects.cart_icon_RemoveItem_Desktop)).click();
   	 	}
   	 	else
   	 	{
   	   	 	int itemQty = Integer.parseInt(testDataSet.get("Qty"));
   	   	 	String itemIndex = Integer.toString(itemQty-1);
   	 		driver.findElement(By.xpath(Objects.cart_txtBox_Qty + itemIndex + "']")).click();
   	   	 	
   	   	 	List<WebElement> element = driver.findElements(By.xpath(Objects.cart_btn_Remove));
   	   	 	
   	   	 	if (element.size() > 0)
   	   	 	{
   	   	 		System.out.println("Remove Icon present on screen");
   	   	 		element.get(0).click();   	   	 		
   	   	 	}
   	   	 	else
   	   	 	{
   		 		System.out.println("Remove Icon - [Remove Icon] Modal window Appeared");
   		 		addStepDetails("Remove Icon", "Unable to find [Remove Icon] on the screen", "PASS");
   	   	 	}
   	 	}
   	 	
   	 	try
  	 	{
  	 		waiting(5000);
   	 		WebElement deletedBar = driver.findElement(By.xpath(Objects.cart_Empty_Msg));
  	 		if (deletedBar != null)
  	 		{
  	   			System.out.println("Remove Item - Item successfully Deleted from Cart");
  	   			addStepDetails("Remove Item", "Item successfully Deleted from Cart", "PASS");
  	 		}
  	 		else
  	 		{
  	   			System.out.println("Remove Item - Empty Cart Message did not Appear while deleting item from cart");
  	   			addStepDetails("Remove Item", "Empty Cart Message did not Appear while deleting item from cart", "FAIL");
  	 		}
  	 	}
  	 	catch (Exception e)
  	 	{
	   		System.out.println("Remove Item - An error occured in deleting item from cart");
	   		addStepDetails("Remove Item", "An error occured in deleting item from cart", "FAIL");
  	 	}   	 	

   	
    }
}
