package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import objectrepository.Objects;
//import startup.Initial;
import startup.Initialize;

public class NutritionInfo extends Initialize{
	
	// ***********************************************************************************
		// Method Name: nutritionInfo
		// Description: Component used to identify nutrition Info of the product
		// Created By: Cognizant Technology Solution
		// Date of Creation: 05/12/2017
		// ***********************************************************************************
	
	
	public void nutritionInfo()
	{
		
	WebElement nutritionlink= driver.findElement(By.xpath(Objects.pdp_nutritionInfo));
	nutritionlink.click();
	nutritionlink.getText();
	
	waiting(5000);
	WebElement nutritionlinkpage=driver.findElement(By.xpath(Objects.pdp_nutritionlinkpage));
	if(nutritionlinkpage.isDisplayed()){
		nutritionlinkpage.getText();
		System.out.println("Text on nutrition link page=" +nutritionlinkpage.getText());
		
		addStepDetails("nutritionlinkpage", "nutrition link page displayed successfully", "PASS");
		System.out.println("nutrition link page displayedsuccessfully");
		
		}
	else
	{
		addStepDetails("nutritionlinkpage", "nutrition link page not displayed", "FAIL");
		System.out.println("nutrition link page not displayed");	
	}
	
	}
}
