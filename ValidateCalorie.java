package components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateCalorie extends Initialize{

    /*****************************************************************
    //Method Name: restoreCart
    //Description: component to restore the deleted item to the Cart 
    //Created By: Cognizant Technology Solution
    //Date of Creation: 04/11/2017
    /*****************************************************************/

    public void validateCalorie()
    {
    	addStepDetails("", "component to validate the calorie value of an item", "COMMENT");
   	 	System.out.println("Executing Business Component -  validate calorie....");
   	 	
   	    //WebElement TxtBoxContent=driver.findElement(By.xpath(Objects.find_Calorie));
   	   // System.out.println("Calorie value " + TxtBoxContent.getAttribute("value"));
}
    }