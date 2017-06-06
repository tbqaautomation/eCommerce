package components;

import java.text.Normalizer;

import org.openqa.selenium.By;

import objectrepository.Objects;
import startup.Initialize;

public class NavToItemPDP extends Initialize{

	public void navToItemPDP() {

		try
		{		
			
			//int index = GenericMethods.validateSearchResult(Objects.item_Srch, strItem);
			int index = ValidateSearchResult.validateSearchResult();
			
			addStepDetails("", "Component used to Navigate to Item PDP Screen from Search Screen", "COMMENT");
			System.out.println("Executing Business Component - navToItemPDP ....");
						
			String strItem = testDataSet.get("Item");

			driver.findElements(By.xpath(Objects.item_Srch)).get(index).click();
			
			waiting(2000);
			
			String strItemname = driver.findElement(By.xpath(Objects.pdp_ItemName)).getAttribute("innerHTML");
			
			if (strItemname.matches(".*[^\\x20-\\x7E].*"))
			{
				strItemname = Normalizer.normalize(strItemname, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");	
			}			
   	 		
   	 		if (strItem.equals(strItemname))
   	 		{
   				System.out.println("Item Name in PDP Screen - Item Name in PDP Screen is Validated");
   				addStepDetails("Item Name in PDP Screen", "Item Name in PDP Screen is Validated", "PASS");
   	 		}
   	 		else
   	 		{
   				System.out.println("Item Name in PDP Screen - Unable To Validate Item Name in PDP Screen");
   				addStepDetails("Item Name in PDP Screen", "Unable To Validate Item Name in PDP Screen", "FAIL");
   	 		}
   	 		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
