package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateNutritionInfo extends Initialize{
	
	// ***********************************************************************************
		// Method Name: nutritionInfo
		// Description: Component used to identify nutrition Info of the product
		// Created By: Cognizant Technology Solution
		// Date of Creation: 05/12/2017
		// ***********************************************************************************
	
	
	public void validateNutritionInfo()
	{
		
		WebElement nutritionlink= driver.findElement(By.xpath(Objects.pdp_nutritionInfo));
		nutritionlink.click();
		nutritionlink.getText();
		
		waiting(5000);
		WebElement nutritionlinkpage=driver.findElement(By.xpath(Objects.nutrition_header));
		if(nutritionlinkpage.isDisplayed())
		{		
			addStepDetails("Nutrition Modal", "Nutrition Modal Window Displayed Successfully", "PASS");
			System.out.println("Nutrition Modal - Nutrition Modal Window Displayed Successfully");
			
			String strHeader = nutritionlinkpage.getText();
			
			if (strHeader.contains("Nutrition"))
			{
				addStepDetails("Validate Header", "Header of Nutrition Modal Validated Successfully", "PASS");
				System.out.println("Validate Header - Header of Nutrition Modal Validated Successfully");
			}
			else
			{
				addStepDetails("Validate Header", "Header of Modal does NOT match with text [Nutrition]", "FAIL");
				System.out.println("Validate Header - Header of Modal does NOT match with text [Nutrition]");
			}
			
			WebElement el = driver.findElement(By.xpath(Objects.nutrition_detailComponents));
			
			String strItemName = driver.findElement(By.xpath(Objects.nutrition_detailComponents)).getAttribute("innerHTML");
			String strinputItem = testDataSet.get("Item");
			
			if (strinputItem.equals(strItemName))
			{
				addStepDetails("Validate Product Name", "Product Name in Nutrition Detail Validated Successfully", "PASS");
				System.out.println("Validate Header - Product Name in Nutrition Detail Validated Successfully");
			}
			else
			{
				addStepDetails("Validate Header", "Product Name in Nutrition Detail is NOT Present", "FAIL");
				System.out.println("Validate Header - Product Name in Nutrition Detail is NOT Present");
			}
			
			System.out.println("Closing Nutrition Info Modal Window");
			driver.findElement(By.xpath(Objects.nutrition_icon_Close)).click();
			
		}
		else
		{
			addStepDetails("Nutrition Modal", "Nutrition Modal Window is NOT Displayed", "FAIL");
			System.out.println("Nutrition Modal - Nutrition Modal Window is NOT Displayed");
		}
	
	}
}
