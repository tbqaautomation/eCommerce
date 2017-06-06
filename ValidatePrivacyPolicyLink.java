package components;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import objectrepository.Objects;
import startup.Initialize;

public class ValidatePrivacyPolicyLink extends Initialize{
	/************************************************************************
    //Method Name: validatePrivacyPolicyLink
    //Description: To validate the privacy policy link in Checkout page
    //Created By: Cognizant Technology Solution
    //Date of Creation: 01/06/2017
   *************************************************************************/
	public static void validatePrivacyPolicyLink() {
		ArrayList<String> tabHandle = null; 
		addStepDetails("", "component used to validate the privacy policy link ", "COMMENT"); 
        System.out.println("Executing Business Component - validatePrivacyPolicyLink ....");
        waiting(2000);
        
        WebElement element = driver.findElement(By.xpath(Objects.checkout_Privacy_Link));
        scrollToElement(element);
        waiting(2000);
     
       	addStepDetails("Presence of privacy policy ", "Privacy policy link is present ", "PASS"); 
   
       	element.click();
    	addStepDetails("Click on privacy policy ", "Privacy policy link is clicked", "PASS"); 
    	if(GenericMethods.waitForObject("xpath", 60, Objects.privacy_Link_Page).equals("true"))   
    	{		tabHandle = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabHandle.get(1));
				addStepDetails("Validate Privacy Policy Page", "Privacy policy Page is validated successfully", "PASS"); 
				driver.close();
				driver.switchTo().window(tabHandle.get(0));
    	}
    	else
    		addStepDetails("Validate Privacy Policy Page", "Privacy policy Page validation failed ", "FAIL");          	       	
        	
        	
	}

}
