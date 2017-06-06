package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class SelectPickupLocation extends Initialize{
	// ***********************************************************************************
	// Method Name: SelectPickupLocation
	// Description: Component used to Select the pickup location
	// Created By: Cognizant Technology Solution
	// Date of Creation: 04/25/2017
	// ***********************************************************************************
	
	
	public static void selectPickupLocation()
	{
		addStepDetails("", "Component used to Select the pickup location","COMMENT");
		System.out.println("Executing Business Component - selectPickupLocation ....");
		
		String strSearch = testDataSet.get("Search");
		char[] chFavorite = testDataSet.get("FavoriteStatus").toCharArray();		
		
		
		//click on the pickup restaurant icon
		driver.findElement(By.xpath(Objects.pickup_location)).click();
		
		if (GenericMethods.waitForObject("xpath", 40, Objects.search_zip).equals("true"))
		{
			addStepDetails("Search Location Page", "Navigated to Search Location Page", "PASS");
			System.out.println(" navigated to search location page");
		}
		else 
		{
			addStepDetails("Search Location Page", "Not Navigated to Search Location Page", "FAIL");
			System.out.println("Not navigated to search location page");
			return;
		}

		//Search Zip or City
		driver.findElement(By.xpath(Objects.search_zip)).click();
		driver.findElement(By.xpath(Objects.search_zip)).clear();
		driver.findElement(By.xpath(Objects.search_zip)).sendKeys(strSearch);
		driver.findElement(By.xpath(Objects.search_zip)).sendKeys(Keys.ENTER);
		waiting(3000);
		// get the store list
		List<WebElement> storeList = driver.findElements(By.xpath(Objects.store_zip));
		String strStore = null;
		if(storeList.size() > 0)
		{
			for(int i = 0; i<storeList.size() ;i++)
			{
				String strStoreAddress = storeList.get(i).getText();
				// check if the address has the zip code
				if(strStoreAddress.contains(strSearch))
				{
					System.out.println("Store Address:"+strStoreAddress);
					
					//if favorite status is Y 
					if (chFavorite[0] == 'Y' || chFavorite[0] == 'N'){
						
						if (driver.findElement(By.xpath(Objects.login)).getText().contains("LOG")){						
							//System.out.println("Guest user: "+driver.findElement(By.xpath(Objects.login)).getText());
							addStepDetails("Store Favorite Status", "Favorite Store is currently not selected", "PASS");
							driver.findElement(By.xpath(Objects.default_favoriteicon_location)).click();
							System.out.println("Clicked on favorite icon in default state");
							
							if (driver.findElement(By.xpath(Objects.login_username)).isDisplayed() == true){
								addStepDetails("Store Favorite Status", "Guest user cannot select store favorite option", "PASS");
								driver.findElement(By.xpath(Objects.login_username)).sendKeys(Keys.ESCAPE);
								break;
							}
							else{
								addStepDetails("Store Favorite Status", "Guest user should receive prompt to sign in", "FAIL");
								break;
							}
						}
						//for registered user
						else{
																			
							if (driver.findElement(By.xpath(Objects.default_favoriteicon_location)).isDisplayed() == true){
								addStepDetails("Store Favorite Status", "Favorite Store is currently not selected", "PASS");
								driver.findElement(By.xpath(Objects.default_favoriteicon_location)).click();
								System.out.println("Clicked on favorite icon in default state");							
										
								if (GenericMethods.waitForObject("xpath", 40, Objects.active_favoriteicon_location).equals("true"))
									addStepDetails("Store Favorite Selection", "Favorite Store is selected successfully", "PASS");
								else
									addStepDetails("Store Favorite Selection", "Favorite Store is not selected successfully", "FAIL");								
							}
							
							else{
								
								addStepDetails("Store Favorite Status", "Favorite Store is currently selected", "PASS");
								driver.findElement(By.xpath(Objects.active_favoriteicon_location)).click();
								System.out.println("Clicked on favorite icon in selected state");
								waiting(2000);
									
								if (GenericMethods.waitForObject("xpath", 10, Objects.active_favoriteicon_location).equals("true"))
									addStepDetails("Store Favorite Selection", "Favorite Store is not successfully unselected", "FAIL");
								else
									addStepDetails("Store Favorite Selection", "Favorite Store is successfully unselected", "PASS");						
								}						
							
						}							
					}

					//click on start your order
					strStore = driver.findElements(By.xpath(Objects.store_address)).get(i).getText();
					driver.findElement(By.xpath(Objects.btn_start_your_order)).click();			
					System.out.println("clicked Pickup Location ");
										
					if(GenericMethods.waitForObject("xpath", 40, Objects.pickup_location).equals("true"))
					{
						String strSelectedStore = driver.findElement(By.xpath(Objects.pickup_location)).getText();
						
						if(strSelectedStore.toLowerCase().contains(strStore.toLowerCase()))
						{
							addStepDetails("Select Pickup Location", "Pickup Location is selected successfully", "PASS");
							System.out.println("Pickup Location is selected successfully");
							break;
						}
						else							
						{
							addStepDetails("Select Pickup Location", "Pickup Location is not selected ", "FAIL");
							System.out.println("Pickup Location is not selected");
						}
					}
					else
					{
						addStepDetails("Select Pickup Location", "Page took too long for loading", "FAIL");
						System.out.println("Page took too long for loading");
					}					
				}
				
			}
		}
		else
		{
			addStepDetails("Select Pickup Location", "No stores displayed", "FAIL");
			System.out.println("No stores displayed");
		}
	}

}
