package components;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class FB_Twit_Share extends Initialize{

    /*****************************************************************
    //Method Name: fb_Twit_Share
    //Description: Component to verify the Facebook and Twitter Share
    //Created By: Cognizant Technology Solution
    //Date of Creation: 05/25/2017
    /*****************************************************************/
	
	public void fb_Twit_Share() {
		
		try
		{		
			
			addStepDetails("", "Component to verify the Facebook and Twitter Share", "COMMENT");
			System.out.println("Executing Business Component - fb_Twit_Share ....");
			
			//Checking the FB Sharing Link
			try
			{
				WebElement fbLink = driver.findElement(By.xpath(Objects.fb_Share_Link));
				fbLink.click();
				
				//Get Window Handlers as List
				List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
				//Switch to New Tab
				driver.switchTo().window(browserTabs.get(1));
				//Check if Correct Page Opened or Not (Page's Title)
				String actualTitle = driver.getTitle();
				if (actualTitle.contains("Facebook"))
				{
					System.out.println("FB/Twitter Share - Facebook Sharing Link is found and is redirected to proper page.");
			   		addStepDetails("FB/Twitter Share", "Facebook Sharing Link is found and is redirected to proper page", "PASS");
				}
				else
				{
					System.out.println("FB/Twitter Share - Facebook Sharing Link is found but is not redirected to proper page.");
			   		addStepDetails("FB/Twitter Share", "Facebook Sharing Link is found but is not redirected to proper page", "FAIL");
				}
				//Close the New Tab
				driver.close();
				//Switch Back to Old Tab
				driver.switchTo().window(browserTabs.get(0));
				
				//Checking ToolTip Text
				String fbToolTipText = fbLink.getAttribute("title");
				if (fbToolTipText.equals("Facebook"))
				{
					System.out.println("FB/Twitter Share - Facebook ToolTip Text is Present.");
			   		addStepDetails("FB/Twitter Share", "Facebook ToolTip Text is Present", "PASS");
				}
				else
				{
					System.out.println("FB/Twitter Share - Facebook ToolTip Text is Not Present or is having different text.");
			   		addStepDetails("FB/Twitter Share", "Facebook ToolTip Text is Not Present or is having different text", "FAIL");
				}
			}
			catch (Exception e1)
			{
				System.out.println("FB/Twitter Share - Facebook Sharing Link is not found.");
				addStepDetails("FB/Twitter Share", "Facebook Sharing Link is not found.", "FAIL");
			}
			
			try
			{
				WebElement twitLink = driver.findElement(By.xpath(Objects.twitter_Share_Link));
				twitLink.click();
				
				//Get Window Handlers as List
				List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
				//Switch to New Tab
				driver.switchTo().window(browserTabs.get(1));
				//Check if Correct Page Opened or Not (Page's Title)
				String actualTitle = driver.getTitle();
				if (actualTitle.contains("Twitter"))
				{
					System.out.println("FB/Twitter Share - Twitter Sharing Link is found and is redirected to proper page.");
			   		addStepDetails("FB/Twitter Share", "Twitter Sharing Link is found and is redirected to proper page", "PASS");
				}
				else
				{
					System.out.println("FB/Twitter Share - Twitter Sharing Link is found but is not redirected to proper page.");
			   		addStepDetails("FB/Twitter Share", "Twitter Sharing Link is found but is not redirected to proper page", "FAIL");
				}
				//Close the New Tab
				driver.close();
				//Switch Back to Old Tab
				driver.switchTo().window(browserTabs.get(0));
				
				//Checking ToolTip Text
				String twitToolTipText = twitLink.getAttribute("title");
				if (twitToolTipText.equals("Twitter"))
				{
					System.out.println("FB/Twitter Share - Twitter ToolTip Text is Present.");
			   		addStepDetails("FB/Twitter Share", "Twitter ToolTip Text is Present", "PASS");
				}
				else
				{
					System.out.println("FB/Twitter Share - Twitter ToolTip Text is Not Present or is having different text.");
			   		addStepDetails("FB/Twitter Share", "Twitter ToolTip Text is Not Present or is having different text", "FAIL");
				}
			}
			catch (Exception e2)
			{
				System.out.println("FB/Twitter Share - Twitter Sharing Link is not found.");
				addStepDetails("FB/Twitter Share", "Twitter Sharing Link is not found.", "FAIL");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
