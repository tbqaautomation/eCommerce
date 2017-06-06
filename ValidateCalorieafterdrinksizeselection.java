package components;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateCalorieafterdrinksizeselection extends Initialize {

	// ***********************************************************************************
	// Method Name: ValidateCalorieafterdrinksizeseletection
	// Description: Component used to check calorie after selecting drink size
	// Created By: Cognizant Technology Solution
	// Date of Creation: 03/07/2017
	// *********************************************************************************** 

	public void validatecalorieafterdrinksizeselection()
	{
	
		addStepDetails("", "Component used to check calorie after selecting drink size", "COMMENT");
		System.out.println("Executing Business Component - ValidateCalorieafterdrinksizeseletection ....");
		
		WebElement initialcalrie=driver.findElement(By.xpath(Objects.pdp_select_calorie));
		String strtinitialcalrie=initialcalrie.getText();
		
		System.out.println("initialcalrie"+initialcalrie.getText());
	
		WebElement updatesize=driver.findElement(By.xpath(Objects.pdp_drink_size_selection));
		String strupdatesize=updatesize.getText();
		updatesize.click();
		
		System.out.println("updatedsize is = "+updatesize.getText());
		
		
		WebElement calrieaftersizeselection=driver.findElement(By.xpath(Objects.pdp_select_calorie));
		String strcalrieaftersizeselection=calrieaftersizeselection.getText();
		
		System.out.println("calrieaftersizeselection is = "+calrieaftersizeselection.getText());
		
		if(strcalrieaftersizeselection.equals(strtinitialcalrie))
		{
			addStepDetails("Calorie", "Calrie does not get updated after selecting the size", "FAIL");
			System.out.println("Calrie does not get seleted after selecting the size");
		}
		else
		{
			addStepDetails("Calorie", "Calrie got updated successfully after selecting the size", "PASS");
			System.out.println("Calorie got updated successfully after selecting the size");
		}
		}
		
		
	}
	






