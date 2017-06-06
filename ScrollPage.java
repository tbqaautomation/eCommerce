package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import startup.Initialize;

public class ScrollPage extends Initialize {
	// ***********************************************************************************
		// Method Name: ScrollPage
		// Description: Component used to Scroll the page up or down
		// Created By: Cognizant Technology Solution
		// Date of Creation: 04/24/2017
		// ***********************************************************************************
			
	public static void scrollPage ()
	{
		addStepDetails("", "Component used to Scroll the page up or down","COMMENT");
		System.out.println("Executing Business Component - scrollPage ....");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		String scroll = testDataSet.get("Scroll");
		String[] arrScroll = scroll.split("_");
		String strScroll = arrScroll[0];
		String strValue = arrScroll[1];
		String value = "20";
		WebElement dropdown = driver.findElement(By.xpath("//form[@id='addToCartForm']//ul[@class='jsAmount']"));
		
		//dropdown.findElement(By.cssSelector("li[selectid=" + value + "]")).click();
		//WebElement switchLabel = driver.findElement(By.cssSelector(".divselect"));
		//dropdown.click(); // assuming you have to click the "dropdown" to open it
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		System.out.println(options.size());
		for (WebElement option : options)
		{
			System.out.println("text:" +option.getAttribute("selectid"));
		    if (option.getAttribute("selectid").equals(value))
		    {
		        option.sendKeys(Keys.ENTER); // click the desired option
		        break;
		    }
		}
		//String borderValue = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('content');",switchLabel)).to;
		//System.out.println(borderValue);
		waiting(10000);
		
		if (strScroll.equalsIgnoreCase("Down"))
		{
			addStepDetails("Scroll Down", "Page is scrolled down","PASS");
			System.out.println("Scroll down");
			jse.executeScript("window.scrollBy(0,"+strValue+")", "");
		}
		else
		{
			addStepDetails("Scroll UP", "Page is scrolled up","PASS");
			System.out.println("Scroll Up");
			jse.executeScript("window.scrollBy(0,-"+strValue+")", "");
		}
	}	

}
