package components;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.*;

import objectrepository.Objects;
//import startup.Initial;
import startup.Initialize;

public class AddToCartFromPDPMultipleQty extends Initialize {

	public static void addToCartFromPDPMultipleQty() {
		addStepDetails("", "Component used to add multiple Quantity from Dropdown in the PDP Screen", "COMMENT");
		System.out.println("Executing Business Component - addToCartFromPDPMultipleQty ....");
		waiting(2000);
		
		String abc = testDataSet.get("Qty");
		System.out.println("Abc:" +abc+ "Abc");
		int intQty = Integer.parseInt(abc);
		
		WebElement element1 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown));
		System.out.println(element1.getSize());
		
		if (strPlatform.equalsIgnoreCase("Desktop"))
		{
			element1.click(); //Click on Dropdown icon
		}
		else
		{		
			//Actions action = new Actions(driver);
			//action.moveToElement(element1).doubleClick().build().perform();
			//action.moveToElement(element1).doubleClick(element1).build().perform();
			//TouchActions tap = new TouchActions(driver).singleTap(element1);
			//tap.perform();
		    Actions build = new Actions(driver);
		    build.moveToElement(element1, 0, 0).click().build().perform();

		}
			
		waiting(3000);
		WebElement element2 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown + "/ul/li[@selectid='" + intQty + "']"));
		element2.click();	//Click on the required option from Dropdown
		
		WebElement addToOrder = driver.findElement(By.xpath(Objects.cart_btn_AddToCart));
		addToOrder.click();	//Click on the "Add to Order" button
		waiting(10000);
		
	 	int itemCount = Integer.parseInt(driver.findElement(By.xpath(Objects.home_icon_Cart)).getAttribute("innerHTML"));
	 	//System.out.println("New: " + itemCount);
	 	
	 	if (intQty == itemCount)
	 	{
			System.out.println("Add Multiple Items To Cart - Specified Qty of Items Added To Cart");
			addStepDetails("Add Multiple Items To Cart", "Specified Qty of Items Added To Cart", "PASS");
	 	}
	 	else
	 	{
			System.out.println("Add Multiple Items To Cart - Unable To Add Specified Qty of Items To Cart");
			addStepDetails("Add Multiple Items To Cart", "Unable To Add Specified Qty of Items To Cart", "FAIL");
	 	}
	}

}
