package components;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateItemPDP extends Initialize{

    /************************************************************************
    //Method Name: employeeSearch
    //Description: component used to validate the search for an employee in the Employee search page
    //Created By: Cognizant Technology Solution
    //Date of Creation: 01/04/2017
   *************************************************************************/
    public static void validateItemPDP() throws SQLException 
    {
    	addStepDetails("", "component used to validate the search for an employee in the Employee search page", "COMMENT"); 
        System.out.println("Executing Business Component - employeeSearch ....");
        waiting(2000);
        
    }

}
