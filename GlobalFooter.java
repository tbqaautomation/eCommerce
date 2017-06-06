package components;

import org.openqa.selenium.By;
import objectrepository.Objects;
import startup.Initialize;

public class GlobalFooter extends Initialize{

    /*****************************************************************
    //Method Name: globalFooter
    //Description: Component to verify the Global page Footer
    //Created By: Cognizant Technology Solution
    //Date of Creation: 05/24/2017
    /*****************************************************************/
	
	public void globalFooter() {
		
		try
		{		
			
			addStepDetails("", "Component to verify the Global page Footer", "COMMENT");
			System.out.println("Executing Business Component - globalFooter ....");
			
			//Checking the Special Offers, App Download Links and Delivery Page Link
			try
			{
				String spclOffrLinkText = driver.findElement(By.xpath(Objects.footer_signup)).getAttribute("innerHTML");
		   		System.out.println("1. Links to Special Offers (" + spclOffrLinkText + ") is found.");
		   		addStepDetails("Global Footer", "Links to Special Offers is found", "PASS");
			}
			catch (Exception e1)
			{
				System.out.println("1. Links to Special Offers is not found.");
				addStepDetails("Global Footer", "Links to Special Offers is not found or is having a different link", "FAIL");
			}
			
			try
			{
				String appleAppLinkText = driver.findElement(By.xpath(Objects.footer_ios_download)).getAttribute("innerHTML");
		   		System.out.println("1-i(a). Apple App Download Link (" + appleAppLinkText + ") is found.");
		   		addStepDetails("Global Footer", "Apple App Download Link is found", "PASS");
			}
			catch (Exception e2)
			{
				System.out.println("1-i(a). Apple App Download Link is not found.");
				addStepDetails("Global Footer", "Apple App Download Link is not found or is having a different link", "FAIL");
			}
			
			try
			{
				String androidAppLinkText = driver.findElement(By.xpath(Objects.footer_apk_download)).getAttribute("innerHTML");
		   		System.out.println("1-i(b). Android App Download Link (" + androidAppLinkText + ") is found.");
		   		addStepDetails("Global Footer", "Android App Download Link is found", "PASS");
			}
			catch (Exception e3)
			{
				System.out.println("1-i(b). Android App Download Link is not found.");
				addStepDetails("Global Footer", "Android App Download Link is not found or is having a different link", "FAIL");
			}
			
			try
			{
				String deliveryToolLinkText = driver.findElement(By.xpath(Objects.footer_delivery)).getAttribute("innerHTML");
		   		System.out.println("1-ii. Delivery Availability Tool Link (" + deliveryToolLinkText + ") is found.");
		   		addStepDetails("Global Footer", "Delivery Availability Tool Link is found", "PASS");
			}
			catch (Exception e4)
			{
				System.out.println("1-ii. Delivery Availability Tool Link is not found.");
				addStepDetails("Global Footer", "Delivery Availability Tool Link is not found or is having a different link", "FAIL");
			}
			
			//Checking the Social Links
			
			try
			{
				String socialToutLinkText = driver.findElement(By.xpath("//div[@class='footer-global__share']//div[@class = 'headline' and contains(.,'Stay Connected')]")).getAttribute("innerHTML");
		   		if (socialToutLinkText.equals("Stay Connected"))
		   		{
					System.out.println("2. Title tout for the Taco Bell Social Platform Links (" + socialToutLinkText + ") is found.");
			   		addStepDetails("Global Footer", "Title tout for the Taco Bell Social Platform Links (Stay Connected) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("2. Title tout for the Taco Bell Social Platform Links is having a different text than 'Stay Connected'");
		   			addStepDetails("Global Footer", "Title tout for the Taco Bell Social Platform Links is having a different text than 'Stay Connected'", "FAIL");
		   		}
			}
			catch (Exception e5)
			{
				System.out.println("2. Title tout for the Taco Bell Social Platform Links is not found.");
				addStepDetails("Global Footer", "Title tout for the Taco Bell Social Platform Links is not found", "FAIL");
			}
			
			try
			{
				driver.findElement(By.xpath(Objects.footer_snapchat));
		   		System.out.println("2-i. Snapchat Link is found.");
		   		addStepDetails("Global Footer", "Snapchat Link is found", "PASS");
			}
			catch (Exception e6)
			{
				System.out.println("2-i. Snapchat Link is not found or is having a different link");
				addStepDetails("Global Footer", "Snapchat Link is not found or the icon is having a different link", "FAIL");
			}
			
			try
			{
				driver.findElement(By.xpath(Objects.footer_twitter));
		   		System.out.println("2-ii. Twitter Link is found.");
		   		addStepDetails("Global Footer", "Twitter Link is found", "PASS");
			}
			catch (Exception e7)
			{
				System.out.println("2-ii. Twitter Link is not found or is having a different link");
				addStepDetails("Global Footer", "Twitter Link is not found or the icon is having a different link", "FAIL");
			}
			
			try
			{
				driver.findElement(By.xpath(Objects.footer_facebook));
		   		System.out.println("2-iii. Facebook Link is found.");
		   		addStepDetails("Global Footer", "Facebook Link is found", "PASS");
			}
			catch (Exception e8)
			{
				System.out.println("2-iii. Facebook Link is not found or is having a different link");
				addStepDetails("Global Footer", "Facebook Link is not found or the icon is having a different link", "FAIL");
			}
			
			try
			{
				driver.findElement(By.xpath(Objects.footer_youtube));
		   		System.out.println("2-iv. YouTube Link is found.");
		   		addStepDetails("Global Footer", "YouTube Link is found", "PASS");
			}
			catch (Exception e9)
			{
				System.out.println("2-iv. YouTube Link is not found or is having a different link");
				addStepDetails("Global Footer", "YouTube Link is not found or the icon is having a different link", "FAIL");
			}
			
			try
			{
				driver.findElement(By.xpath(Objects.footer_instagram));
		   		System.out.println("2-v. Instagram Link is found.");
		   		addStepDetails("Global Footer", "Instagram Link is found", "PASS");
			}
			catch (Exception e10)
			{
				System.out.println("2-v. Instagram Link is not found or the icon is having a different link");
				addStepDetails("Global Footer", "Instagram Link is not found or is having a different link", "FAIL");
			}
			
			//Checking the Links for General TacoBell Information
			
			try
			{
				String tacoShopLinkText = driver.findElement(By.xpath(Objects.footer_taco_shop)).getAttribute("innerHTML");
		   		if (tacoShopLinkText.equals("Live Más Store"))
		   		{
					System.out.println("3-i. Taco Shop Link (" + tacoShopLinkText + ") is found.");
			   		addStepDetails("Global Footer", "Taco Shop Link (Live Más Store) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("3-i. Taco Shop Link is having a different text than 'Live Más Store'");
			   		addStepDetails("Global Footer", "Taco Shop Link is having a different text than 'Live Más Store'", "FAIL");
		   		}
			}
			catch (Exception e11)
			{
				System.out.println("3-i. Taco Shop Link is not found.");
				addStepDetails("Global Footer", "Taco Shop Link is not found", "FAIL");
			}
			
			try
			{
				String giftCardsLinkText = driver.findElement(By.xpath(Objects.footer_gift_cards)).getAttribute("innerHTML");
		   		if (giftCardsLinkText.equals("Gift Cards"))
		   		{
					System.out.println("3-ii. Gift Cards Link (" + giftCardsLinkText + ") is found.");
			   		addStepDetails("Global Footer", "Gift Cards Link (Gift Cards) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("3-ii. Gift Cards Link is having a different text than 'Gift Cards'");
			   		addStepDetails("Global Footer", "Gift Cards Link is having a different text than 'Gift Cards'", "FAIL");
		   		}
			}
			catch (Exception e12)
			{
				System.out.println("3-ii. Gift Cards Link is not found.");
				addStepDetails("Global Footer", "Gift Cards Link is not found", "FAIL");
			}
			
			try
			{
				String contactUsLinkText = driver.findElement(By.xpath(Objects.footer_contact_us)).getAttribute("innerHTML");
		   		if (contactUsLinkText.equals("Contact Us"))
		   		{
					System.out.println("3-iii. Contact Us Link (" + contactUsLinkText + ") is found.");
			   		addStepDetails("Global Footer", "Contact Us Link (Contact Us) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("3-iii. Contact Us Link is having a different text than 'Contact Us'");
			   		addStepDetails("Global Footer", "Contact Us Link is having a different text than 'Contact Us'", "FAIL");
		   		}
			}
			catch (Exception e13)
			{
				System.out.println("3-iii. Contact Us Link is not found.");
				addStepDetails("Global Footer", "Contact Us Link is not found", "FAIL");
			}
			
			try
			{
				String companyLinkText = driver.findElement(By.xpath(Objects.footer_company)).getAttribute("innerHTML");
		   		if (companyLinkText.equals("Company"))
		   		{
					System.out.println("3-iv. Company Link (" + companyLinkText + ") is found.");
			   		addStepDetails("Global Footer", "Company Link (Company) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("3-iv. Company Link is having a different text than 'Company'");
			   		addStepDetails("Global Footer", "Company Link is having a different text than 'Company'", "FAIL");
		   		}
			}
			catch (Exception e14)
			{
				System.out.println("3-iv. Company Link is not found.");
				addStepDetails("Global Footer", "Company Link is not found", "FAIL");
			}
			
			try
			{
				String nutritionLinkText = driver.findElement(By.xpath(Objects.footer_nutrition)).getAttribute("innerHTML");
		   		if (nutritionLinkText.equals("Nutrition"))
		   		{
					System.out.println("3-v. Nutrition Link (" + nutritionLinkText + ") is found.");
			   		addStepDetails("Global Footer", "Nutrition Link (Nutrition) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("3-v. Nutrition Link is having a different text than 'Nutrition'");
			   		addStepDetails("Global Footer", "Nutrition Link is having a different text than 'Nutrition'", "FAIL");
		   		}
			}
			catch (Exception e15)
			{
				System.out.println("3-v. Nutrition Link is not found.");
				addStepDetails("Global Footer", "Nutrition Link is not found", "FAIL");
			}
			
			try
			{
				String careersLinkText = driver.findElement(By.xpath(Objects.footer_careers)).getAttribute("innerHTML");
		   		if (careersLinkText.equals("Careers"))
		   		{
					System.out.println("3-vi. Careers Link (" + careersLinkText + ") is found.");
			   		addStepDetails("Global Footer", "Careers Link (Careers) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("3-vi. Careers Link is having a different text than 'Careers'");
			   		addStepDetails("Global Footer", "Careers Link is having a different text than 'Careers'", "FAIL");
		   		}
			}
			catch (Exception e16)
			{
				System.out.println("3-vi. Careers Link is not found.");
				addStepDetails("Global Footer", "Careers Link is not found", "FAIL");
			}
			
			try
			{
				String faqsLinkText = driver.findElement(By.xpath(Objects.footer_faqs)).getAttribute("innerHTML");
		   		if (faqsLinkText.equals("FAQs"))
		   		{
					System.out.println("3-vii. FAQs Link (" + faqsLinkText + ") is found.");
			   		addStepDetails("Global Footer", "FAQs Link (FAQs) is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("3-vii. FAQs Link is having a different text than 'FAQs'");
			   		addStepDetails("Global Footer", "FAQs Link is having a different text than 'FAQs'", "FAIL");
		   		}
			}
			catch (Exception e17)
			{
				System.out.println("3-vii. FAQs Link is not found.");
				addStepDetails("Global Footer", "FAQs Link is not found", "FAIL");
			}
			
			//Checking the Links to TacoBell Legal Pages
			
			try
			{
				String aboutLinkText = driver.findElement(By.xpath(Objects.footer_about)).getAttribute("innerHTML");
				if (aboutLinkText.equals("About Our Ads"))
		   		{
					System.out.println("4-i. ABOUT OUR ADS Link (" + aboutLinkText + ") is found.");
			   		addStepDetails("Global Footer", "ABOUT OUR ADS Link is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("4-i. ABOUT OUR ADS Link is having a different text than 'ABOUT OUR ADS'");
			   		addStepDetails("Global Footer", "ABOUT OUR ADS Link is having a different text than 'ABOUT OUR ADS'", "FAIL");
		   		}
			}
			catch (Exception e18)
			{
				System.out.println("4-i. ABOUT OUR ADS Link is not found.");
				addStepDetails("Global Footer", "ABOUT OUR ADS Link is not found", "FAIL");
			}
			
			try
			{
				String legalLinkText = driver.findElement(By.xpath(Objects.footer_legal)).getAttribute("innerHTML");
		   		if (legalLinkText.equals("Legal Notices"))
		   		{
					System.out.println("4-ii. LEGAL NOTICES Link (" + legalLinkText + ") is found.");
			   		addStepDetails("Global Footer", "LEGAL NOTICES Link is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("4-ii. LEGAL NOTICES Link is having a different text than 'LEGAL NOTICES'");
			   		addStepDetails("Global Footer", "LEGAL NOTICES Link is having a different text than 'LEGAL NOTICES'", "FAIL");
		   		}
			}
			catch (Exception e19)
			{
				System.out.println("4-ii. LEGAL NOTICES Link is not found.");
				addStepDetails("Global Footer", "LEGAL NOTICES Link is not found", "FAIL");
			}
			
			try
			{
				String privacyLinkText = driver.findElement(By.xpath(Objects.footer_privacy)).getAttribute("innerHTML");
		   		if (privacyLinkText.equals("Privacy Policy"))
		   		{
					System.out.println("4-iii. PRIVACY POLICY Link (" + privacyLinkText + ") is found.");
			   		addStepDetails("Global Footer", "PRIVACY POLICY Link is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("4-iii. PRIVACY POLICY Link is having a different text than 'PRIVACY POLICY'");
			   		addStepDetails("Global Footer", "PRIVACY POLICY Link is having a different text than 'PRIVACY POLICY'", "FAIL");
		   		}
			}
			catch (Exception e20)
			{
				System.out.println("4-iii. PRIVACY POLICY Link is not found.");
				addStepDetails("Global Footer", "PRIVACY POLICY Link is not found", "FAIL");
			}
			
			try
			{
				String termsLinkText = driver.findElement(By.xpath(Objects.footer_terms)).getAttribute("innerHTML");
		   		if (termsLinkText.equals("Terms Of Use"))
		   		{
					System.out.println("4-iv. TERMS OF USE Link (" + termsLinkText + ") is found.");
			   		addStepDetails("Global Footer", "TERMS OF USE Link is found", "PASS");
		   		}
		   		else
		   		{
		   			System.out.println("4-iv. TERMS OF USE Link is having a different text than 'TERMS OF USE'");
			   		addStepDetails("Global Footer", "TERMS OF USE Link is having a different text than 'TERMS OF USE'", "FAIL");
		   		}
			}
			catch (Exception e21)
			{
				System.out.println("4-iv. TERMS OF USE Link is not found.");
				addStepDetails("Global Footer", "TERMS OF USE Link is not found", "FAIL");
			}
			
			//Checking the Statements Related to Nutrition
			
			try
			{
				driver.findElement(By.xpath("//p[@class='footer-global__disclaimer' and contains(.,'At participating locations. Prices and items may vary. Tax extra.')]"));
		   		System.out.println("5-i. Succinct statement is Present");
		   		addStepDetails("Global Footer", "Succinct statement is Present", "PASS");
			}
			catch (Exception e22)
			{
				System.out.println("5-i. Succinct statement is Not Present");
				addStepDetails("Global Footer", "Succinct statement is Not Present", "FAIL");
			}
			
			try
			{
				driver.findElement(By.xpath("//p[@class='footer-global__disclaimer' and contains(.,'2,000 calories a day is used for general nutrition advice, but calorie needs vary.')]"));
		   		System.out.println("5-ii. Nutrition statement is Present");
		   		addStepDetails("Global Footer", "Nutrition statement is Present", "PASS");
			}
			catch (Exception e23)
			{
				System.out.println("5-ii. Nutrition statement is Not Present");
				addStepDetails("Global Footer", "Nutrition statement is Not Present", "FAIL");
			}
			
			try
			{
				driver.findElement(By.xpath("//p[@class='footer-global__disclaimer' and contains(.,'Additional nutrition information available upon request.')]"));
		   		System.out.println("5-iii. Additional Nutrition statement is Present");
		   		addStepDetails("Global Footer", "Additional Nutrition statement is Present", "PASS");
			}
			catch (Exception e24)
			{
				System.out.println("5-iii. Additional Nutrition statement is Not Present");
				addStepDetails("Global Footer", "Additional Nutrition statement is Not Present", "FAIL");
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
