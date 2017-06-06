package components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateNavigationMenu extends Initialize{

	public void validateNavigationMenu() {

    	addStepDetails("", "Component to Validate Presence Of Navigation Menu Component In Left Rail", "COMMENT");
   	 	System.out.println("Executing Business Component - validateNavigationMenu ....");
   	 	
   	 	try
   	 	{
   	 		
   	 		if (!strPlatform.equals("Desktop"))
   	 		{
   	 			driver.findElement(By.xpath("//a[@id='global-header-menu']")).click();
   	 			waiting(1000);
   	 		}   	 		
   	 		driver.findElement(By.xpath("//li[@title='Food']/a")).click();
   	 		waiting(1000);
   	 		if ("FOOD".equalsIgnoreCase(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getAttribute("innerHTML").trim()))
   	 		{
   	 			System.out.println("FOOD Screen - Successfully Navigated to [FOOD Screen] after clicking on FOOD link in Left Rail");
   	 			addStepDetails("FOOD Screen", "Successfully Navigated to [FOOD Screen] after clicking on FOOD link in Left Rail", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("FOOD Screen - Unable to Navigate to [FOOD Screen] after clicking on FOOD link in Left Rail");
   	 			addStepDetails("FOOD Screen", "Unable to Navigate to [FOOD Screen] after clicking on FOOD link in Left Rail", "FAIL");
   	 		}
   	 		
   	 		String strFoodUrl = driver.getCurrentUrl();
   	 		
   	 		if (!strPlatform.equals("Desktop"))
   	 		{
   	 			driver.findElement(By.xpath("//a[@id='global-header-menu']")).click();
   	 			waiting(1000);
   	 		}
   	 		driver.findElement(By.xpath("//li[@title='Locations']/a")).click();
   	 		waiting(1000);
   	 		if ("Search For Location".equals(driver.findElement(By.xpath("//div[@class='tb-container store-locator-lp']/div/h1")).getAttribute("innerHTML")))
   	 		{
   	 			System.out.println("Locations Screen - Successfully Navigated to [Locations Screen] after clicking on Locations link in Left Rail");
   	 			addStepDetails("Locations Screen", "Successfully Navigated to [Locations Screen] after clicking on Locations link in Left Rail", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("Locations Screen - Unable to Navigate to [Locations Screen] after clicking on Locations link in Left Rail");
   	 			addStepDetails("Locations Screen", "Unable to Navigate to [Locations Screen] after clicking on Locations link in Left Rail", "FAIL");
   	 		}
   	 		
   	 		String strLocationsUrl = driver.getCurrentUrl();   	
   	 		
   	 		if (!strPlatform.equals("Desktop"))
   	 		{
   	 			driver.findElement(By.xpath("//a[@id='global-header-menu']")).click();
   	 			waiting(1000);
   	 		}
   	 		driver.findElement(By.xpath("//li[@title='Blog']/a")).click();
   	 		waiting(1000);
   	 		if ("Blog".equals(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getText()))
   	 		{
   	 			System.out.println("Blog Screen - Successfully Navigated to [Blog Screen] after clicking on Blog link in Left Rail");
   	 			addStepDetails("Blog Screen", "Successfully Navigated to [Blog Screen] after clicking on Blog link in Left Rail", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("Blog Screen - Unable to Navigate to [Blog Screen] after clicking on Blog link in Left Rail");
   	 			addStepDetails("Blog Screen", "Unable to Navigate to [Blog Screen] after clicking on Blog link in Left Rail", "FAIL");
   	 		}
   	 		
   	 		String strBlogUrl = driver.getCurrentUrl();
   	 		
   	 		if (!strPlatform.equals("Desktop"))
   	 		{
   	 			driver.findElement(By.xpath("//a[@id='global-header-menu']")).click();
   	 			waiting(1000);
   	 		}
   	 		driver.findElement(By.xpath("//li[@title='About Us']/a")).click();
   	 		waiting(1000);   	 		
   	 		if ("About Us".equals(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getText()))
   	 		{
   	 			System.out.println("About Us Screen - Successfully Navigated to [About Us Screen] after clicking on About Us link in Left Rail");
   	 			addStepDetails("About Us Screen", "Successfully Navigated to [About Us Screen] after clicking on About Us link in Left Rail", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("About Us Screen - Unable to Navigate to [About Us Screen] after clicking on About Us link in Left Rail");
   	 			addStepDetails("About Us Screen", "Unable to Navigate to [About Us Screen] after clicking on About Us link in Left Rail", "FAIL");
   	 		}
   	 		
   	 		String strAboutUsUrl = driver.getCurrentUrl();
   	 		
   	 		if (!strPlatform.equals("Desktop"))
   	 		{
   	 			driver.findElement(By.xpath("//a[@id='global-header-menu']")).click();
   	 			waiting(1000);
   	 		}
   	 		driver.findElement(By.xpath("//li[@title='Taco Shop']/a")).click();
   	 		waiting(1000);   	 		
   	 		if ("Taco Shop".equals(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getText()))
   	 		{
   	 			System.out.println("Taco Shop Screen - Successfully Navigated to [Taco Shop Screen] after clicking on Taco Shop link in Left Rail");
   	 			addStepDetails("Taco Shop Screen", "Successfully Navigated to [Taco Shop Screen] after clicking on Taco Shop link in Left Rail", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("Taco Shop Screen - Unable to Navigate to [Taco Shop Screen] after clicking on Taco Shop link in Left Rail");
   	 			addStepDetails("Taco Shop Screen", "Unable to Navigate to [Taco Shop Screen] after clicking on Taco Shop link in Left Rail", "FAIL");
   	 		}
   	 		
   	 		String strTacoShopUrl = driver.getCurrentUrl();
   	 		
   	 		//Validating Deep Link Portions
   	 		
   	 		addStepDetails("", "Navigating to FOOD Screen via deep link ", "COMMENT");
   	 		driver.get(strFoodUrl);
   	 		waiting(1000);
   	 		
   	 		if ("Food".equals(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getText()))
   	 		{
   	 			System.out.println("FOOD Screen - Successfully Navigated to [FOOD Screen] via deep Link");
   	 			addStepDetails("FOOD Screen", "Successfully Navigated to [FOOD Screen] via deep Link", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("FOOD Screen - Unable to Navigate to [FOOD Screen] via deep Link");
   	 			addStepDetails("FOOD Screen", "Unable to Navigate to [FOOD Screen] via deep Link", "FAIL");
   	 		}
   	 		
   	 		addStepDetails("", "Navigating to Locations Screen via deep link ", "COMMENT");
   	 		driver.get(strLocationsUrl);
   	 		waiting(1000);
   	 		
   	 		if ("Search For Location".equals(driver.findElement(By.xpath("//div[@class='tb-container store-locator-lp']/div/h1")).getAttribute("innerHTML")))
   	 		{
   	 			System.out.println("Locations Screen - Successfully Navigated to [Locations Screen] via deep Link");
   	 			addStepDetails("Locations Screen", "Successfully Navigated to [Locations Screen] via deep Link", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("Locations Screen - Unable to Navigate to [Locations Screen] via deep Link");
   	 			addStepDetails("Locations Screen", "Unable to Navigate to [Locations Screen] via deep Link", "FAIL");
   	 		}
   	 		
/*   	 		addStepDetails("", "Navigating to Blog Screen via deep link ", "COMMENT");
   	 		driver.get(strBlogUrl);
   	 		waiting(1000);
   	 		
   	 		if ("Blog".equals(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getText()))
   	 		{
   	 			System.out.println("Blog Screen - Successfully Navigated to [Blog Screen] via deep Link");
   	 			addStepDetails("Blog Screen", "Successfully Navigated to [Blog Screen] via deep Link", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("Blog Screen - Unable to Navigate to [Blog Screen] via deep Link");
   	 			addStepDetails("Blog Screen", "Unable to Navigate to [Blog Screen] via deep Link", "FAIL");
   	 		}
   	 		
   	 		addStepDetails("", "Navigating to About Us Screen via deep link ", "COMMENT");
   	 		driver.get(strAboutUsUrl);
   	 		waiting(1000);
   	 		
   	 		if ("About Us".equals(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getText()))
   	 		{
   	 			System.out.println("About Us Screen - Successfully Navigated to [About Us Screen] via deep Link");
   	 			addStepDetails("About Us Screen", "Successfully Navigated to [About Us Screen] via deep Link", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("About Us Screen - Unable to Navigate to [About Us Screen] via deep Link");
   	 			addStepDetails("About Us Screen", "Unable to Navigate to [About Us Screen] via deep Link", "FAIL");
   	 		}
   	 		  	 		
   	 		addStepDetails("", "Navigating to Taco Shop Screen via deep link ", "COMMENT");
   	 		driver.get(strTacoShopUrl);
   	 		waiting(1000);
   	 		
   	 		if ("Taco Shop".equals(driver.findElement(By.xpath("//div[@class='cls-header']/h1/span")).getText()))
   	 		{
   	 			System.out.println("Taco Shop Screen - Successfully Navigated to [Taco Shop Screen] via deep Link");
   	 			addStepDetails("Taco Shop Screen", "Successfully Navigated to [Taco Shop Screen] via deep Link", "PASS");
   	 		}
   	 		else
   	 		{
   	 			System.out.println("Taco Shop Screen - Unable to Navigate to [Taco Shop Screen] via deep Link");
   	 			addStepDetails("Taco Shop Screen", "Unable to Navigate to [Taco Shop Screen] via deep Link", "FAIL");
   	 		}*/
   	 	}
   	 	catch (NoSuchElementException e)
   	 	{
	 		System.out.println("Error Occured - Separate Screen NOT Found for [Blog], [About US], [Taco Shop]");
	 		addStepDetails("Error Occured", "Separate Screen NOT Found for [Blog], [About US], [Taco Shop]", "FAIL");
   	 		
   	 	}
   	 	catch (Exception ex)
   	 	{
   	 		ex.printStackTrace();
   	 		
   	 	}
		
	}

}
