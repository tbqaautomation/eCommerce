package components;

import java.text.Normalizer;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import objectrepository.Objects;
import startup.Initialize;

public class SearchItem extends Initialize{

	 //***********************************************************************************
	 //Method Name: searchItem
	 //Description: Component used to search an item from Home Screen
	 //Created By: Cognizant Technology Solution
	 //Date of Creation: 03/07/2017
	 //***********************************************************************************

  public static void searchItem() {
		addStepDetails("", "Component used to search an item from Home Screen", "COMMENT");
		System.out.println("Executing Business Component - searchItem ....");
		
		String strItem = testDataSet.get("Item");
		
		WebElement searchIcon = driver.findElement(By.xpath(Objects.home_icon_Search));
		String strSearchText = "";
		
		if (strPlatform.equalsIgnoreCase("Desktop"))
		{
			strSearchText = driver.findElement(By.xpath(Objects.home_icon_Search+"/following-sibling::span")).getText();
			//System.out.println(strSearchText);
			if ("SEARCH OUR FOOD MENU".equals(strSearchText))
			{
				System.out.println("Search TextBox Default Text - Search Text box has default text as [SEARCH OUR FOOD MENU]");
				addStepDetails("Search TextBox Default Text", "Search Text box has default text as [SEARCH OUR FOOD MENU]", "PASS");
			}
			else
			{
				System.out.println("Search TextBox Default Text - Search Text box did NOT have the default text as [SEARCH OUR FOOD MENU]");
				addStepDetails("Search TextBox Default Text", "Search Text box did NOT have the default text as [SEARCH OUR FOOD MENU]", "FAIL");
			}
		}
		
		searchIcon.click();
		WebElement searchTxtBox = driver.findElement(By.xpath(Objects.home_txt_Search));
		searchTxtBox.sendKeys(strItem);
		strSearchText = searchTxtBox.getAttribute("value");
		
		if (strItem.equals(strSearchText))
		{
			System.out.println("Search TextBox Value - Text [" + strItem + "] entered on Search Text Box");
			addStepDetails("Search TextBox Value", "Text [" + strItem + "] entered on Search Text Box", "PASS");
		}
		else
		{
			System.out.println("Search TextBox Value - Text [" + strItem + "] is NOT entered on Search Text Box");
			addStepDetails("Search TextBox Value", "Text [" + strItem + "] is NOT entered on Search Text Box", "FAIL");
		}
		
		driver.findElement(By.xpath(Objects.home_txt_Search)).sendKeys(Keys.ENTER);
		
		//GenericMethods.validateSearchResult(Objects.item_Srch, strItem);
		
   }

}
