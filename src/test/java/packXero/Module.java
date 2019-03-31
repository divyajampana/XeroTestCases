package packXero;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class Module extends ReusableMethods{
	
	public static void login(String UserName, String Password) throws IOException, InterruptedException
	{
	
		WebElement userName = findElement(By.id("email"), "UserName");
		userName.clear();
		enterText(userName, "UserName", UserName);
		WebElement password = findElement(By.id("password"), "Password");
		password.clear();
		enterText(password, "Password", Password);
		WebElement login = findElement(By.id("submitButton"), "Login");
		clickObject(login, "Login");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
	}

}
