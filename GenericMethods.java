package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Objects;
import startup.Initialize;

public class GenericMethods extends Initialize{
	static String empdetails[] = new String [6];
	static String strNewTimecard = "";
	static String strNewWage = "";
	static String strNewResDate = "";

	public GenericMethods() {
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************
	//Method Name: validateDataEntered
	//Description: component used to validate Data entered in DropDown and TextBox
	//Created By: Cognizant Technology Solution
	//Date of Creation: 12/22/2016
	//*************************************************************************/
       
	public static boolean validateDataEntered(String strDataPassed,WebElement strObjectName,String strElementType)
	{
		boolean blnDataValidation = false;
		String strDataEntered = "";
		
		switch (strElementType)
		{
		case "TextBox":
			strDataEntered = strObjectName.getAttribute("value");
			
			//if data entered & passed matched, reset blnDataValidation to true, else it remains false
			if (strDataEntered.equals(strDataPassed))                    
				blnDataValidation = true;
			
			break;
			
		case "DropDown":
			//System.out.println(strDataPassed);
			Select selectItem = new Select(strObjectName);
			strDataEntered = selectItem.getFirstSelectedOption().getText();
			//System.out.println(strDataEntered);
			//if data entered & passed matched, reset blnDataValidation to true, else it remains false
			if (strDataEntered.contains(strDataPassed))
				blnDataValidation = true;  
			break;
		}
		
        	return blnDataValidation;
        	
        }
	
	//******************************************************************************************
	//Method Name: waitForObject
	//Description: Halts the execution until the specified time and handle alerts
	//Created By: Cognizant Technology Solution
	//Date of Creation: 12/01/2017
	//******************************************************************************************	
	
	public static String waitForObject(String strType, int inPutTime, String strValue) {
		int TimeLagMultiplier = 1;
		try
		{
			//FileInputStream objFile = new FileInputStream(relativePath + "\\startup\\Settings.properties");
			//properties.load(objFile);
			TimeLagMultiplier = Integer.parseInt(properties.getProperty("TimeLagMultiplier"));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage().toString());
		}		

		int waitTime = TimeLagMultiplier * inPutTime;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		
	    if(strType.contains("Alert"))
	    {
		    try {		        
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        String strText = alert.getText();
		        if(strText.contains(strValue))
		        {
					alert.accept();
					System.out.println("Alert Text: " +strText);
					return "true";
		        }
		        else
		        {
		        	alert.accept();
					System.out.println("Alert Text does not match : " + strText);
					return strText;
		        }

		    } catch (Exception e) {
		        System.out.println(e.getMessage());
				addStepDetails("Alert Not Found","Page is taking long time to load.", "FAIL");
				return e.getMessage().toString();
		    }
	    }
	    else
	    {
			try
			{
		    	if(strType.contains("id"))
				{
					//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
					//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(strValue)));
		    		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(strValue)));
					System.out.println("element found with given id");
					
					/*if(driver.findElements(By.xpath(Objects.processingPrompt)).size() > 0)
					{
						System.out.println("Processing Prompt found..Waiting");
						while (driver.findElements(By.xpath(Objects.processingPrompt)).size() > 0)
						{
							waiting(1000);
							
						}
						System.out.println("Processing Prompt Gone.");
					}*/

					return "true";
				}
				else if(strType.contains("xpath"))
				{
					//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strValue)));
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strValue)));
					System.out.println("element found with given xpath");
					/*if(driver.findElements(By.xpath(Objects.processingPrompt)).size() > 0)
					{
						System.out.println("Processing Prompt found..Waiting");
						while (driver.findElements(By.xpath(Objects.processingPrompt)).size() > 0)
						{
							waiting(1000);
							
						}
						System.out.println("Processing Prompt Gone.");
					}*/
					return "true";
				}
				else
				{
					System.out.println("Error in calling [waitForObject] function..Please check the parameters");
					return "false";
				}
		    	
			} catch (Exception e) {        
				System.out.println("Loading took too much time..Unable to find element within the specified time");
				System.out.println(e.getMessage());
				return "false";
			}
	    	

	    }
		
	}
	
	/***********************************************************
	//Method Name: getBusinessDate
	//Description: Returns the current businessday (For IST timezone, it takes the date from settings.properties file)
	//Created By: Cognizant Technology Solution
	//Date of Creation: 08/24/2016
	/***********************************************************/	
    public static String getBusinessDate()throws SQLException, IOException
    {
		FileInputStream objFile = new FileInputStream(relativePath + "\\startup\\Settings.properties");
		properties.load(objFile);
    	
    	Date date = new Date();           
        Integer intHour = Integer.parseInt(date.toString().substring((date.toString().indexOf(':')-2),(date.toString().indexOf(':'))));
        //Integer intMinutes = Integer.parseInt(date.toString().substring((date.toString().indexOf(':')+1), date.toString().lastIndexOf(':')));
        //Integer intSeconds = Integer.parseInt(date.toString().substring((date.toString().lastIndexOf(':')+1), (date.toString().lastIndexOf(':')+3)));
        
        String strBusinessDate =  new SimpleDateFormat("MM/dd/YYYY").format(date);
        
    	if(date.toString().contains("IST"))
    	{
    		strBusinessDate = properties.getProperty("BusinessDate");
    	}
    	else
    	{
            if (intHour<04)
                strBusinessDate = modifyDay(strBusinessDate, -1);
            else
                strBusinessDate = modifyDay(strBusinessDate, 0);
    	}
        
        System.out.println("Current Business Date: "+strBusinessDate);
        return strBusinessDate;
    }

	/***********************************************************
	//Method Name: modifyDay
	//Description: Function for increasing/decreasing the date
	//Created By: Cognizant Technology Solution
	//Date of Creation: 08/24/2016
	/***********************************************************/
	public static String modifyDay(String strDate, int iChange){
		
		String dt="";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
		Calendar c = Calendar.getInstance();
		try {
		    c.setTime(sdf.parse(strDate));
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} 
		c.add(Calendar.DAY_OF_MONTH, iChange);  // number of days to add
		dt = sdf.format(c.getTime());
		//System.out.println("The date has been changed to : " + dt);		
		return dt;
		
	}
	
	/*************************************************************
	//Method Name: modifyYear
	//Description: Function for increasing/decreasing the month
	//Created By: Cognizant Technology Solution
	//Date of Creation: 08/24/2016
	/*************************************************************/
	public static String modifyYear(String strDate, int iChange){
		
		String dt="";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
		Calendar c = Calendar.getInstance();
		try {
		    c.setTime(sdf.parse(strDate));
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} 
		c.add(Calendar.YEAR, iChange);  // number of days to add
		dt = sdf.format(c.getTime());
		//System.out.println("The date has been changed to : " + dt);		
		return dt;
		
	}
	
	/***********************************************************************************
	//Method Name: getRandomInteger
	//Description: component used to select a random Integer value within the range
	//Created By: Cognizant Technology Solution
	//Date of Creation: 11/23/2016
	//***********************************************************************************/
	public static int getRandomInteger(int max, int min){
		return ((int) (Math.random()*(max - min))) + min; 
	}
	
	/***********************************************************************************
	//Method Name: getRandomFloat
	//Description: component used to select a random float value within the range
	//Created By: Cognizant Technology Solution
	//Date of Creation: 12/22/2016
	//***********************************************************************************/
	public static float getRandomFloat(int max, int min){
		float a =(float) (Math.random()*(max - min)) + min ;
		//round up to 2 decimal places
		a = (float) (Math.round(a* 100.0) / 100.0);
		return a;
	}
	
	//******************************************************************************************
	//Method Name: isAlertPresent
	//Description: component used to validate the presence of the alert
	//Created By: Cognizant Technology Solution
	//Date of Creation: 07/12/2016
	//******************************************************************************************
	//@Parameters()
	//@Test()
	public static boolean isAlertPresent() 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex)
		{ 
			return false;
		}   // catch 
	}
	
	//***********************************************************
	//Method Name: getRandomString
	//Description: component used to generate a random String
	//Created By: Cognizant Technology Solution
	//Date of Creation: 12/21/2016
	//***********************************************************
	//@Parameters({"username","password"})
	//@Test()
	public static String getRandomString(){
	
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;		
	}

	//***********************************************************
	//Method Name: validateSearchResult
	//Description: component used to validate the item Name from the Search Result
	//Created By: Cognizant Technology Solution
	//Date of Creation: 05/16/2017
	//***********************************************************	
	
/*	public static int validateSearchResult(String strXpath, String strText){
		
		try
		{
			List<WebElement> element = driver.findElements(By.xpath(strXpath));
			
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
						System.out.println("Search item - Item [" + strText + "] is found from the Search Result");
						addStepDetails("Search item", "Item [" + strText + "] is found from the Search Result", "PASS");
						
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
		
		
	}*/
    
}
