package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import objectrepository.Objects;
import startup.Initialize;

public class Validatecalorieafterincreasingitem extends Initialize {

	// ***********************************************************************************
	// Method Name: validatecalorieafterincreasingitem
	// Description: Component used to check calorie after increasing the item's quantity
	// Created By: Cognizant Technology Solution
	// Date of Creation: 03/07/2017
	// *********************************************************************************** 

	
public void validatecalorieafterincreasingitem() 
{
	addStepDetails("", "Component used to check calorie after increasing the item's quantity", "COMMENT");
	System.out.println("Executing Business Component - ValidateCalorieafterdrinksizeseletection ....");
	
	WebElement initialcalrie=driver.findElement(By.xpath(Objects.pdp_select_calorie));
	String strtinitialcalrie=initialcalrie.getText();
	
	System.out.println("initialcalrie"+initialcalrie.getText());
	
	List<WebElement> element = driver.findElements(By.xpath(Objects.pdp_QtyDropdown + "//li[@selectid]"));
	if (element.size() == 50)
	{
		System.out.println("Quantity Dropdown is Present");
		addStepDetails("Check Quantity Dropdown", "Quantity Dropdown is Present with all the options", "PASS");
	}
	else
	{
		System.out.println("Quantity Dropdown is Not Present");
		addStepDetails("Check Quantity Dropdown", "Quantity Dropdown is Not Present or doesn't have all the options", "FAIL");
	}
	
	//String i = String.valueOf(GenericMethods.getRandomInteger(1,50));
	int r = GenericMethods.getRandomInteger(0,49);
	System.out.println("Random = " + r);
	
	WebElement element1 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown));
	element1.click();
	waiting(3000);
	WebElement element2 = driver.findElement(By.xpath(Objects.pdp_QtyDropdown + "/ul/li[@selectid='" + r + "']"));
	element2.click();
	
	WebElement calrieafterqtychange=driver.findElement(By.xpath(Objects.pdp_select_calorie));
	String strcalrieafterqtychange=calrieafterqtychange.getText();
	
	System.out.println("calrie after qtyc hange"+calrieafterqtychange.getText());
	
	
	if(strcalrieafterqtychange.equals(strtinitialcalrie))
	{
		addStepDetails("Calorie", "Calrie does not get updated after selecting the quantity", "PASS");
		System.out.println("Calrie does not get updated after selecting the quantity");
	}
	else
	{
	     addStepDetails("Calorie", "Calrie got updated after selecting the quantity", "FAIL");
	     System.out.println("Calrie got updated after selecting the quantity");
	
	}
}
}
