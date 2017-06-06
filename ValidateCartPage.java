package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectrepository.Objects;
import startup.Initialize;

public class ValidateCartPage extends Initialize{
	
	/************************************************************************
    //Method Name: validateCartPage
    //Description: To validate the presence of the fields displayed in cart
    //Created By: Cognizant Technology Solution
    //Date of Creation: 30/05/2017
   *************************************************************************/
	public static void validateCartPage() {
		addStepDetails("", "component used to validate the items in cart Screen", "COMMENT"); 
        System.out.println("Executing Business Component - validateCartPage ....");
        waiting(2000);
        
        // validate the presence of item images
        List<WebElement> listImages = driver.findElements(By.xpath(Objects.cart_Item_Image));
        
        if (listImages.size() >0)
        {
        	addStepDetails("Validate Cart Item Images", "Item images validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Image validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Item Images", "Item images validation in the Cart page failed", "FAIL"); 
        	System.out.println("Image validation in Cart Failed");
        }
        
        // validate the presence of item quantity
        List<WebElement> listQty = driver.findElements(By.xpath(Objects.cart_txtBox_Qty));
        
        if (listQty.size() >0)
        {
        	addStepDetails("Validate Cart Item Quantity", "Item Quantity validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Quantity validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Item Quantity", "Item Quantity validation in the Cart page failed", "FAIL"); 
        	System.out.println("Quantity validation in Cart Failed");
        }
        // validate the presence of item Name
        List<WebElement> listName = driver.findElements(By.xpath(Objects.cart_Item_Name));
        
        if (listName.size() >0)
        {
        	addStepDetails("Validate Cart Item Name", "Item Name validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Name validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Item Name", "Item Name validation in the Cart page failed", "FAIL"); 
        	System.out.println("Name validation in Cart Failed");
        }
        // validate the presence of customize or edit button
        List<WebElement> listEdit= driver.findElements(By.xpath(Objects.cart_Customize_Edit));
        
        if (listEdit.size() >0)
        {
        	addStepDetails("Validate Cart Customize Edit Option", "Customize Edit Option validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Customize Edit Option validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Customize Edit Option", "Customize Edit Option validation in the Cart page failed", "FAIL"); 
        	System.out.println("Customize Edit Option validation in Cart Failed");
        }
        
        // validate the presence of remove button
        List<WebElement> listRemove= driver.findElements(By.xpath(Objects.cart_Remove_Btn));
        
        if (listRemove.size() >0)
        {
        	addStepDetails("Validate Cart Remove button", "Remove button validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Remove button validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Remove button", "Remove button validation in the Cart page failed", "FAIL"); 
        	System.out.println("Remove button validation in Cart Failed");
        }
     // validate the presence of Show more and SHow less links
        
        List<WebElement> listShow= driver.findElements(By.xpath(Objects.cart_ShowMore_ShowLess));
        
        if (listShow.size() > 0)
        {
        	addStepDetails("Validate Cart Show More/Show Less Links", "Show More/Show Less Links validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Show More/Show Less Links validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Show More/Show Less Links", "Show More/Show Less Links validation in the Cart page failed", "FAIL"); 
        	System.out.println("Show More/Show Less Links validation in Cart Failed");
        }
        // validate the presence of Subtotal
        
        List<WebElement> listSubtotal=driver.findElements(By.xpath(Objects.cart_Subtotal));
        
        if (listSubtotal.size() > 0)
        {
        	addStepDetails("Validate Cart Subtotal", "Subtotal validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Subtotal validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Subtotal", "Subtotal validation in the Cart page failed", "FAIL"); 
        	System.out.println("Subtotal validation in Cart Failed");
        }
        // validate the presence of Tax
       
        List<WebElement> listTax= driver.findElements(By.xpath(Objects.cart_Tax));
        if (listTax.size() > 0)
        {
        	addStepDetails("Validate Cart Order Total", "Order Total validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Order Total validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Order Total", "Order Total validation in the Cart page failed", "FAIL"); 
        	System.out.println("Order Total validation in Cart Failed");
        }
        // validate the presence of Order total
    
        List<WebElement> listTotal= driver.findElements(By.xpath(Objects.cart_Total));
        
        if (listTotal.size() > 0)
        {
        	addStepDetails("Validate Cart Order Total", "Order Total validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Order Total validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Order Total", "Order Total validation in the Cart page failed", "FAIL"); 
        	System.out.println("Order Total validation in Cart Failed");
        }
        // validate the presence of cart disclaimer
        
        List<WebElement> listDisclaimer= driver.findElements(By.xpath(Objects.cart_Disclaimer));
        
        if (listDisclaimer.size() > 0)
        {
        	addStepDetails("Validate Cart Disclaimer", "Disclaimer validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Disclaimer validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Disclaimer", "Disclaimer validation in the Cart page failed", "FAIL"); 
        	System.out.println("Disclaimer validation in Cart Failed");
        }
 // validate the presence of cart Add Drinks
        
        List<WebElement> listAddDrinks= driver.findElements(By.xpath(Objects.cart_AddDrinks));
        
        if (listAddDrinks.size() > 0)
        {
        	addStepDetails("Validate Cart Add Drinks", "Add Drinks validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Add Drinks validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Add Drinks", "Add Drinks validation in the Cart page failed", "FAIL"); 
        	System.out.println("Add Drinks validation in Cart Failed");
        }
 // validate the presence of cart Add Sides
        
        List<WebElement> listAddSides= driver.findElements(By.xpath(Objects.cart_AddSides));
        
        if (listAddSides.size() > 0)
        {
        	addStepDetails("Validate Cart Add Sides", "Add Sides validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Add Sides validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Add Sides", "Add Sides validation in the Cart page failed", "FAIL"); 
        	System.out.println("Add Sides validation in Cart Failed");
        }
 // validate the presence of cart Might like Section
        
        List<WebElement> listMightLike= driver.findElements(By.xpath(Objects.cart_MightLike_Items));
        
        if (listMightLike.size() > 0)
        {
        	addStepDetails("Validate Cart Might like Section", "Might like Section validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Might like Section validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Might like Section", "Might like Section validation in the Cart page failed", "FAIL"); 
        	System.out.println("Might like Section validation in Cart Failed");
        }
        
        // validate the presence of Checkout button
        List<WebElement> listCheckoutBtn= driver.findElements(By.xpath(Objects.cart_btn_Checkout));
        
        if (listCheckoutBtn.size() > 0)
        {
        	addStepDetails("Validate Cart Checkout button", "Checkout button validation in the Cart page Successfull", "PASS"); 
        	System.out.println("Checkout button validation in Cart Successfull");
        }
        else
        {
        	addStepDetails("Validate Cart Checkout button", "Checkout button validation in the Cart page failed", "FAIL"); 
        	System.out.println("Checkout button validation in Cart Failed");
        }
	}
}

	


