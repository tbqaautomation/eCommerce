package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;


public class ValidateTextOnScreen extends Initialize {
	// ***********************************************************************************
		// Method Name: ValidateTextOnScreen
		// Description: Component used to validate the Text on screen
		// Created By: Cognizant Technology Solution
		// Date of Creation: 04/13/2017
		// ***********************************************************************************
		
		
	public void validateTextOnScreen() {
		addStepDetails("", "Component used to validate the Text on screen", "COMMENT");
		System.out.println("Executing Business Component - ValidateTextOnScreen ....");
		
		String strText = testDataSet.get("Text");
		
		String strXpath = "//*[text()='"+strText+"']";
		
		//System.out.println(strXpath);
		
		List<WebElement> xpathList = driver.findElements(By.xpath(strXpath));
		if (xpathList.size() >0)
		{
		
			for (int i =0 ; i<xpathList.size(); i++)
			{
				String strTemp = xpathList.get(0).getText();
				System.out.println("Xpath Text:" + strTemp);
				if (strTemp.contentEquals(strText))
				{
					System.out.println("Validated Text on Screen :"+strText);
					addStepDetails("Validate Text -"+strText,"Text validated on screen succcessfully","PASS");				
				}
				else
				{
					System.out.println("Text not found :"+strText);
					addStepDetails("Validate Text -"+strText,"Text not validated on screen","FAIL");				
				}
				
			}
		}
		else
		{
			System.out.println("Text not found :"+strText);
			addStepDetails("Validate Text -"+strText,"Text not validated on screen","FAIL");				
		}
	}
	
}
