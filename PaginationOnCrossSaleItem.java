package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import objectrepository.Objects;
import startup.Initialize;


public class PaginationOnCrossSaleItem extends Initialize {

	// ***********************************************************************************
		// Method Name: paginationoncrossSaleItem
		// Description: Component used to validate pagination button under cross sales item on the PDP page
		// Created By: Cognizant Technology Solution
		// Date of Creation: 05/16/2017
		// ***********************************************************************************	
	
		
	public void paginationoncrossSaleItem()
	{
		
		addStepDetails("", "Component used to validate cross sales item on the PDP page", "COMMENT");
		System.out.println("Executing Business Component - validatecrosssaleproduct ....");
		
		try{
		WebElement crosssaleproducts= driver.findElement(By.xpath(Objects.pdp_crosssaleitem));		
		
			if (crosssaleproducts.isDisplayed())
				
			{
				//Scrolling till Pickup Details is Visible
			    JavascriptExecutor js=(JavascriptExecutor)driver;
			    js.executeScript("arguments[0].scrollIntoView(true);", crosssaleproducts);
				
				
				String strcrosssaleproducts= crosssaleproducts.getText();
				
				System.out.println("strcrosssaleproducts="+strcrosssaleproducts);
				
				//System.out.println("Cross sale items are present");
				System.out.println("Cross sale products are present on the PDP page");
				
				List<WebElement> element= driver.findElements(By.xpath(Objects.pdp_crosssaleitem_list));
				int strelement= element.size();
				
				System.out.println("strelement="+strelement);
				
				if(element.size()>=4)
					
				{
										
					//Check the pagination button	
					try{
					WebElement paginationbtn=driver.findElement(By.xpath(Objects.pdp_pagination_button_on_crosssale));
											
						if (paginationbtn.isEnabled())
						{
							paginationbtn.click();
							
							System.out.println("Pagination button is present and clickable under the cross sale product");
							addStepDetails("Pagination", "Pagination button is present and clickable under the cross sale product", "FAIL");
														
							}
						
						else
						{
							addStepDetails("Pagination on cross sale product", "No Pagination button is present and clickable under the cross sale product ", "PASS");
							System.out.println("No Pagination button is present and clickable under the cross sale product");	
							
						}}
						catch(NoSuchElementException e)
						{
							addStepDetails("Pagination on cross sale product", "No Pagination button is present and clickable under the cross sale product ", "PASS");
							System.out.println("Since less then 4 item present,No Pagination button is present and clickable under the cross sale product");
						}
				}
				
             
			}
			else
			{
			System.out.println("Cross sale products are not present on the PDP page");
			}
			}
			catch(NoSuchElementException e)
			{
				
				System.out.println("Cross sale products are not present on the PDP page");
			}
			
		}
		
	
}	
		
		
		
	


