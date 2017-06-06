package components;

import java.text.Normalizer;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateSearchResult extends Initialize{

	public static int validateSearchResult() {
		
		try
		{
			String strCallerMethod = new Exception().getStackTrace()[1].getMethodName();
			System.out.println(strCallerMethod);
			
			List<WebElement> element;
			
			if(!strCallerMethod.equalsIgnoreCase("validateCartCount"))
			{
				addStepDetails("", "Component used to Validate Search Results", "COMMENT");
				System.out.println("Executing Business Component - validateSearchResult ....");
				
				element = driver.findElements(By.xpath(Objects.item_Srch));
			}
			else
			{
				element = driver.findElements(By.xpath("//*[@class='order-title']/a/span"));
			}
			
			
			String strText = testDataSet.get("Item");
			//String strXpath = testDataSet.get("ObjectName");
			
			String tmp = "";
			Boolean tmpFlag = false;
			int elementCount = element.size();
			
			if (elementCount > 0)
			{
				for (int i=0; i<elementCount; i++)
				{
					tmp = element.get(i).getText();
					
					if (tmp.matches(".*[^\\x20-\\x7E].*"))
					{
						tmp = Normalizer.normalize(tmp, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");		
					}
					
					System.out.println(tmp);
					if (tmp.equals(strText))
					{
						System.out.println("Item Search - Item [" + strText + "] is found in the screen");
						addStepDetails("Item Search", "Item [" + strText + "] is found in the screen", "PASS");
						
						//element.get(i).click();
						tmpFlag = true;
						return i;
						//break;
					}
				}
			}
			
			if (tmpFlag == false)
			{
				addStepDetails("Search item", "Item [" + strText + "] NOT found from the Search Result", "FAIL");
				System.out.println("Search item - Item [" + strText + "] NOT found from the Search Result");
				return 0;
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage().toString());
		}
		
		return 0;
		
		
	}

}
