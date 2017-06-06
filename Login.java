package components;

import org.openqa.selenium.By;

import objectrepository.Objects;
import startup.Initialize;

public class Login extends Initialize{
	// ***********************************************************************************
	// Method Name: Login
	// Description: Component used to login
	// Created By: Cognizant Technology Solution
	// Date of Creation: 05/31/2017
	// ***********************************************************************************
	
	
	public static void login()
	{
		addStepDetails("", "Component used to login","COMMENT");
		System.out.println("Executing Business Component - Login ....");
		
		String strUsername = testDataSet.get("Username");
		String strPassword = testDataSet.get("Password");
		
		System.out.println("Username & Password"+ strUsername + " " + strPassword);
		
		driver.findElement(By.xpath(Objects.login)).click();
		
		driver.findElement(By.xpath(Objects.login_username)).click();
		driver.findElement(By.xpath(Objects.login_username)).clear();
		driver.findElement(By.xpath(Objects.login_username)).sendKeys(strUsername);
		
		if (driver.findElement(By.xpath(Objects.login_username)).getText().equals(strUsername))
			addStepDetails("Enter Username", "Username [ "+ strUsername +" ] is entered successfully", "PASS");
				
		driver.findElement(By.xpath(Objects.login_password)).click();
		driver.findElement(By.xpath(Objects.login_password)).clear();
		driver.findElement(By.xpath(Objects.login_password)).sendKeys(strPassword);
		
		if (driver.findElement(By.xpath(Objects.login_password)).getText().equals(strPassword))
			addStepDetails("Enter Password", "Password [ "+ strPassword +" ] is entered successfully", "PASS");
		
		
		driver.findElement(By.xpath(Objects.signin_button)).click();
		waiting(5000);
		
		System.out.println("Text after login: "+driver.findElement(By.xpath(Objects.login)).getText());
		
		if (!driver.findElement(By.xpath(Objects.login)).getText().contains("LOG"))
			addStepDetails("User login", "User logged in successfully", "PASS");
		else
			addStepDetails("User login", "User not logged in successfully", "FAIL");
		
	}
	
}

