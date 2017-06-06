package components;


import org.openqa.selenium.By;

import objectrepository.Objects;
import startup.Initialize;

public class AddToCartFromSearchResult extends Initialize{

	public void addToCartFromSearchResult() {
		
		try
		{		
			
			//int index = GenericMethods.validateSearchResult(Objects.item_Srch, strItem);
			int index = ValidateSearchResult.validateSearchResult();
			
			addStepDetails("", "Component used to Add Item to Cart from Search Screen", "COMMENT");
			System.out.println("Executing Business Component - addToCartFromSearchResult ....");
			
			String strItemCount = driver.findElement(By.xpath(Objects.home_icon_Cart)).getAttribute("innerHTML");
	   		System.out.println("First: " + strItemCount);
	   		int itemCountB4 = 0;
	   		
	   		if (strItemCount.length() != 0)
	   		{
	   			itemCountB4 = Integer.parseInt(strItemCount);
	   		}
	   		System.out.println("Current: " + itemCountB4);
			
			String strItem = testDataSet.get("Item");
			
			//SearchItem.searchItem();
			
			
			
			String strItemPrice = driver.findElements(By.xpath(Objects.item_Srch_Price)).get(index).getAttribute("innerHTML");
			System.out.println(strItemPrice);
			driver.findElements(By.xpath(Objects.itemSrch_btn_AddToCart)).get(index).click();
			waiting(10000);
			
   	 		int itemCountNew = Integer.parseInt(driver.findElement(By.xpath(Objects.home_icon_Cart)).getAttribute("innerHTML"));
   	 		System.out.println("New: " + itemCountNew);
   	 		
   	 		if (itemCountNew>itemCountB4)
   	 		{
   				System.out.println("Add To Cart From Search Result - Item Added To Cart from Search Results Screen");
   				addStepDetails("Add To Cart From Search Result", "Item Added To Cart from Search Results Screen", "PASS");
   	 		}
   	 		else
   	 		{
   				System.out.println("Add To Cart From Search Result - Unable To Add Item To Cart from Search Results Screen");
   				addStepDetails("Add To Cart From Search Result", "Unable To Add Item To Cart from Search Results Screen", "FAIL");
   	 		}
   	 		
	   	 	if (strPlatform.equalsIgnoreCase("Desktop"))
			{
	   	 		String strCartAmount = driver.findElement(By.xpath(Objects.home_icon_CartAmount)).getAttribute("innerHTML");
	   	 		
	   	 		if (("$"+strItemPrice).equals(strCartAmount))
	   	 		{
	   				System.out.println("CartAmount - Item Price displayed and validated beside Cart Icon");
	   				addStepDetails("CartAmount", "Item Price displayed and validated beside Cart Icon", "PASS");
	   	 		}
	   	 		else
	   	 		{
	   				System.out.println("CartAmount - Item Price is NOT correctly displayed beside Cart Icon");
	   				addStepDetails("CartAmount", "Item Price is NOT correctly displayed beside Cart Icon", "FAIL");
	   	 		}
			}
   	 		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
