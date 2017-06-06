package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import objectrepository.Objects;
import startup.Initialize;

public class ValidateCrossSaleProduct extends Initialize {
	
	// ***********************************************************************************
	// Method Name: validatecrosssaleproduct
	// Description: Component used to validate cross sales item on the PDP page
	// Created By: Cognizant Technology Solution
	// Date of Creation: 05/15/2017
	// ***********************************************************************************	
	
	
public void validatecrosssaleproduct()
{
	
	addStepDetails("", "Component used to validate cross sales item on the PDP page", "COMMENT");
	System.out.println("Executing Business Component - validatecrosssaleproduct ....");
	
	WebElement crosssaleproducts= driver.findElement(By.xpath(Objects.pdp_crosssaleitem));
	
	//Scrolling till Pickup Details is Visible
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView(true);", crosssaleproducts);
	
	
	String strcrosssaleproducts= crosssaleproducts.getText();
	
	System.out.println("strcrosssaleproducts="+strcrosssaleproducts);
	
	
if (strcrosssaleproducts.equals("You Might Like"))
{
	addStepDetails("Cross sale product", "Cross sale products are present on the PDP page", "PASS");
	System.out.println("Cross sale products are present on the PDP page");
}
else
{
	addStepDetails("Cross sale product", "Cross sale products are not present on the PDP page", "FAIL");
	System.out.println("Cross sale products are not present on the PDP page");
}
	
}
}
