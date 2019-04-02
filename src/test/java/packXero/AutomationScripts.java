package packXero;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class AutomationScripts extends Module{
	//Navigate to XERO
	public  void testID01_A() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID01_A.html", "testID01_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		endReport();


	}

	//Incorrect Password
	public  void testID01_B() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID01_B.html", "testID01_B");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[2][1];
		String UserName2 = data[2][2];
		String Password2 = data[2][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName2, Password2);
		WebElement errmsg =findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "Error message");
		logger.log(LogStatus.PASS, errmsg.getText());
		String s1 = errmsg.getText();
		String s2 = "Your email or password is incorrect";
		compareStrings(s1, s2);
		endReport();
	}

	//Incorrect Email
	public  void testID01_C() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID01_C.html", "testID01_C");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[3][1];
		String UserName3 = data[3][2];
		String Password3 = data[3][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName3, Password3);
		WebElement errmsg =findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "Error message");
		logger.log(LogStatus.PASS, errmsg.getText());
		String s1 = errmsg.getText();
		String s2 = "Your email or password is incorrect";
		compareStrings(s1, s2);
		endReport();
	}
	//Navigate to XERO forgotPasswordLink
	public  void testID01_D() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID01_D.html", "testID01_D");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		WebElement ForgotPwd = findElement(By.xpath("//a[@class='forgot-password-advert']"), "ForgotPassword");
		clickObject(ForgotPwd, "ForgotPassword");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");

		WebElement userName = findElement(By.id("UserName"), "UserName");
		userName.clear();
		enterText(userName, "UserName", UserName1);
		WebElement sendLink = findElement(By.xpath("//span[contains(@class,'text')]"), "SendLink");
		clickObject(sendLink, "SendLink");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		WebElement msg =findElement(By.xpath("//p[contains(text(),'A link to reset your password has been sent to:')]"), "Message");
		logger.log(LogStatus.PASS, msg.getText()+ " is displayed");
		Thread.sleep(4000);
		endReport();


	}
	
	//signup to XDC
	public  void testID02_A() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID02_A.html", "testID02_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet2");
		String URL = data[1][0];

		String FirstName = data[1][1];
		String LastName = data[1][2];
		String emailAdd = data[1][3];
		String PhoneNum = data[1][4];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");

		WebElement TryForFreeLink = findElement(By.partialLinkText("Try Xero for fr"), "Try Xero for free");
		clickObject(TryForFreeLink, "Try Xero for free");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");

		WebElement firstName = findElement(By.xpath("//input[@name='FirstName']"), "FirstName");
		firstName.clear();
		enterText(firstName, "FirstName", FirstName);
		WebElement lastName = findElement(By.xpath("//input[@name='LastName']"), "LastName");
		lastName.clear();
		enterText(lastName, "LastName", LastName);
		WebElement email = findElement(By.xpath("//input[@name='EmailAddress']"), "EmailAddress");
		email.clear();
		enterText(email, "EmailAddress", emailAdd);
		WebElement PhNo = findElement(By.xpath("//input[@name='PhoneNumber']"), "PhoneNumber");
		PhNo.clear();
		enterText(PhNo, "PhoneNumber", PhoneNum);
		Thread.sleep(2000);
		WebElement country = findElement(By.name("LocationCode"), "Country");
		Thread.sleep(4000);
		//SelectByValue(country, "Country", "US");
		WebElement TPcheckBox = findElement(By.xpath("//input[@value='true']"), "Terms&PolicyCheckBox");
		selectCheckBox(TPcheckBox, "Terms&PolicyCheckBox");

		WebElement getStarted = findElement(By.xpath("//span[@class='g-recaptcha-submit']"), "GetStarted");
		clickObject(getStarted, "GetStarted");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		endReport();

	}
	public  void testID02_B() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID02_B.html", "testID02_B");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet2");
		String URL = data[2][0];

		String emailAdd = data[2][3];

		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");

		WebElement TryForFreeLink = findElement(By.partialLinkText("Try Xero for fr"), "Try Xero for free");
		clickObject(TryForFreeLink, "Try Xero for free");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		WebElement getStarted = findElement(By.xpath("//span[@class='g-recaptcha-submit']"), "GetStarted");
		clickObject(getStarted, "GetStarted");
		WebElement ErrMsg1 = findElement(By.id("signup-form-error-message-1"), "error Message1");
		logger.log(LogStatus.PASS, ErrMsg1.getText()+ " is displayed");

		WebElement ErrMsg2 = findElement(By.id("signup-form-error-message-2"), "error Message2");
		logger.log(LogStatus.PASS, ErrMsg2.getText()+ " is displayed");
		WebElement ErrMsg3 = findElement(By.id("signup-form-error-message-3"), "error Message3");
		logger.log(LogStatus.PASS, ErrMsg3.getText()+ " is displayed");
		WebElement ErrMsg4 = findElement(By.id("signup-form-error-message-4"), "error Message4");
		logger.log(LogStatus.PASS, ErrMsg4.getText()+ " is displayed");

		WebElement email = findElement(By.xpath("//input[@name='EmailAddress']"), "EmailAddress");
		email.clear();
		enterText(email, "EmailAddress", emailAdd);
		WebElement ErrMsg5 = findElement(By.id("signup-form-error-message-3"), "error Message5");
		logger.log(LogStatus.PASS, ErrMsg5.getText()+ " is displayed");
		WebElement getStarted1 = findElement(By.xpath("//span[@class='g-recaptcha-submit']"), "GetStarted");
		clickObject(getStarted1, "GetStarted");
		WebElement ErrMsg6 = findElement(By.xpath("//label[@class='form-label text']"), "Text Highlighted");
		logger.log(LogStatus.PASS, ErrMsg6.getText()+ " is unchecked");
		endReport();



	}
	public  void testID02_C() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID02_C.html", "testID02_C");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet2");
		String URL = data[2][0];

		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");

		WebElement TryForFreeLink = findElement(By.partialLinkText("Try Xero for fr"), "Try Xero for free");
		clickObject(TryForFreeLink, "Try Xero for free");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		WebElement termsOfUse = findElement(By.xpath("//a[contains(text(),'Terms of Use')]"), "TermsOfUse");
		clickObject(termsOfUse, "TermsOfUse");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		WebElement privacy = findElement(By.xpath("//a[contains(text(),'Privacy')]"), "Privacy Notice");
		clickObject(privacy, "Privacy Notice");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		Thread.sleep(2000);
		
		endReport();
		
	}
	public  void testID02_E() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID02_E.html", "testID02_E");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet2");
		String URL = data[2][0];

		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");

		WebElement TryForFreeLink = findElement(By.partialLinkText("Try Xero for fr"), "Try Xero for free");
		clickObject(TryForFreeLink, "Try Xero for free");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		WebElement A_B_Link = findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"), "accountant & bookkeeper Link");
		clickObject(A_B_Link, "accountant & bookkeeper Link");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		endReport();
	}
	
	//test all tabs page
	public  void testID03_A() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID03_A.html", "testID03_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		WebElement msg1 = findElement(By.xpath("//span[@class='xrh-banner--text']"), "message");
		logger.log(LogStatus.PASS, msg1.getText()+" is displayed");
		
		WebElement dashBoard = findElement(By.partialLinkText("Dashboard"), "DashBoard");
		clickObject(dashBoard, "DashBoard");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		WebElement accounts = findElement(By.xpath("//button[contains(text(),'Accounting')]"), "accounts");
		clickObject(accounts, "accounts");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, " you are now in accounts dropdown page");
		
		WebElement reports = findElement(By.linkText("Reports"), "reports");
		clickObject(reports, "reports");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		WebElement contacts = findElement(By.xpath("//button[contains(text(),'Contacts')]"), "Contacts");
		clickObject(contacts, "Contacts");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, " you are now in contacts dropdown page");
		
		WebElement appButton = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton, "appButton");
		WebElement settings = findElement(By.linkText("Settings"), "Settings");
		clickObject(settings, "Settings");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		WebElement createnew = findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[1]/button[1]/div[1]"), "CreateNew");
		clickObject(createnew, "CreateNew");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, " you are now in new dropdown page");
		
		WebElement appButton1 = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton1, "appButton");
		WebElement files = findElement(By.linkText("Files"), "Files");
		clickObject(files, "Files");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		WebElement notification = findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[3]/button[1]/div[1]"), "Notification");
		clickObject(notification, "Notification");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "notification page is displayed");
		
		WebElement search = findElement(By.xpath("//button[@title='Search']//*[@class='xrh-icon xrh-icon-svg']"), "Search");
		clickObject(search, "Search");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "search field area is displayed");
		
		WebElement help = findElement(By.xpath("//button[@title='Help']//*[@class='xrh-icon xrh-icon-svg']"), "Help");
		clickObject(help, "Help");
		Thread.sleep(3000);
		WebElement msg2 = findElement(By.xpath("//input[@id='menu_help']"), "message");
		logger.log(LogStatus.PASS, msg2.getAttribute("placeholder")+" is displayed");
		
		Thread.sleep(5000);
		
		
		endReport();
	}
	
	//test logout functionality
	public  void testID04_A() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID04_A.html", "testID04_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		
		WebElement usermenu = findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-10']"), "userMenu");
		clickObject(usermenu, "userMenu");
		WebElement logOut = findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[5]/div[1]/div[2]/div[1]/ol[1]/li[5]/a[1]"), "LogOut");
		clickObject(logOut, "LogOut");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		endReport();
	}
	
	//test upload profile image
	public  void testID06_A() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID06_A.html", "testID06_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet3");
		String URL = data[1][0];
		String UserName1 = data[1][1];
		String Password1 = data[1][2];
		String photoadd = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		
		WebElement usermenu = findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-10']"), "userMenu");
		clickObject(usermenu, "userMenu");
		WebElement profile = findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//li[1]//a[1]"), "Profile button");
		clickObject(profile, "Profile button");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		Thread.sleep(4000);
		WebElement uploadImg = findElement(By.xpath("//span[@id='button-1041-btnInnerEl']"), "Upload Image");
		clickObject(uploadImg, "Upload Image");
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//WebElement frame1=findElement(By.tagName("iframe"), "frame");
		//driver.switchTo().frame(frame1);
		//String oldWindow = driver.getWindowHandle();
		//Set<String> getallWindows = driver.getWindowHandles();
		//String[] getWindow = getallWindows.toArray(new String[getallWindows.size()]);
		Thread.sleep(5000);
		//WebElement photoframe=findElement(By.xpath("//div[@id='ext-comp-1209']"), "Upload photo");
		//driver.switchTo().frame(photoframe);
		WebElement browsePhoto=findElement(By.id("filefield-1188-button-fileInputEl"), "browsephoto");
		browsePhoto.sendKeys(photoadd);
		////input[@id='filefield-1230-button-fileInputEl']
		//WebElement browseImg = findElement(By.xpath("//td[@id='filefield-1216-browseButtonWrap']"), "Browse Image");
		//enterText(browseImg, "Browse Image", "C:\\Users\\satishraju\\Desktop\\pic1.jpg");
		Thread.sleep(3000);
		WebElement upload = findElement(By.xpath("//span[@id='button-1178-btnInnerEl']"), "Upload");
		clickObject(upload, "Upload");
		Thread.sleep(3000);
		endReport();
	
	
	}
	
	//Add another organisation
	public  void testID08_A() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID08_A.html", "testID08_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement appButton = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton, "appButton");
		WebElement myXero = findElement(By.linkText("My Xero"), "MyXero");
		clickObject(myXero, "MyXero");
		Thread.sleep(5000);
		
		//WebElement addOrg =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ext-gen1042']")));
		//addOrg.click();
		WebElement addOrg = findElement(By.partialLinkText("Add an organizati"), "AddOrganisation");
		//mouseHover(addOrg, "AddOrganisation");
		clickObject(addOrg, "AddOrganisation");
		Thread.sleep(4000);
		WebElement nameOfOrg = findElement(By.name("OrganisationName"), "NameOfOrganisation");
		enterText(nameOfOrg, "NameOfOrganisation", "self");
		WebElement orgTaxes = findElement(By.name("CountryCode"), "payTaxes");
		SelectByVisibleText(orgTaxes, "payTaxes", "United States");
		WebElement timeZone = findElement(By.name("TimeZone"), "TimeZone");
		SelectByVisibleText(timeZone, "TimeZone", "(UTC-05:00) Eastern Time (US & Canada)");
		WebElement business = findElement(By.name("IndustryFreeText"), "business");
		enterText(business, "business", "Accounting");
		
		WebElement startTrial = findElement(By.linkText("Start Trial"), "StartTrial");
		clickObject(startTrial, "StartTrial");
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		endReport();
		
	}
		
	public  void testID08_B() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID08_B.html", "testID018_B");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		
		WebElement appButton = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton, "appButton");
		WebElement myXero = findElement(By.linkText("My Xero"), "MyXero");
		clickObject(myXero, "MyXero");
		Thread.sleep(4000);
		WebElement addOrg = findElement(By.xpath("/html[1]/body[1]/div[4]/form[1]/div[1]/section[2]/div[1]/a[1]"), "AddOrganisation");
		clickObject(addOrg, "AddOrganisation");
		Thread.sleep(4000);
		WebElement nameOfOrg = findElement(By.name("OrganisationName"), "NameOfOrganisation");
		enterText(nameOfOrg, "NameOfOrganisation", "self");
		WebElement orgTaxes = findElement(By.name("CountryCode"), "payTaxes");
		SelectByVisibleText(orgTaxes, "payTaxes", "United States");
		WebElement timeZone = findElement(By.name("TimeZone"), "TimeZone");
		SelectByVisibleText(timeZone, "TimeZone", "(UTC-05:00) Eastern Time (US & Canada)");
		WebElement business = findElement(By.name("IndustryFreeText"), "business");
		enterText(business, "business", "Accounting");
		
		WebElement buy = findElement(By.linkText("Buy Now"), "BuyNow");
		clickObject(buy, "BuyNow");
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		endReport();
		
	}
	public  void testID08_F() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID08_F.html", "testID018_F");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		
		WebElement appButton = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton, "appButton");
		WebElement myXero = findElement(By.linkText("My Xero"), "MyXero");
		clickObject(myXero, "MyXero");
		Thread.sleep(4000);
		WebElement addOrg = findElement(By.xpath("/html[1]/body[1]/div[4]/form[1]/div[1]/section[2]/div[1]/a[1]"), "AddOrganisation");
		clickObject(addOrg, "AddOrganisation");
		Thread.sleep(4000);
		WebElement nameOfOrg = findElement(By.name("OrganisationName"), "NameOfOrganisation");
		enterText(nameOfOrg, "NameOfOrganisation", "self");
		WebElement orgTaxes = findElement(By.name("CountryCode"), "payTaxes");
		SelectByVisibleText(orgTaxes, "payTaxes", "United States");
		WebElement timeZone = findElement(By.name("TimeZone"), "TimeZone");
		SelectByVisibleText(timeZone, "TimeZone", "(UTC-05:00) Eastern Time (US & Canada)");
		WebElement business = findElement(By.name("IndustryFreeText"), "business");
		enterText(business, "business", "Accounting");
		WebElement convertDataLink = findElement(By.linkText("Move from QuickBooks for free."), "Move from QuickBooks for free");
		clickObject(convertDataLink, "Move from QuickBooks for free");
		WebElement checkBox = findElement(By.id("conversionCheckbox-inputEl"), "Want to convert your data");
		selectCheckBox(checkBox, "Want to convert your data");
		WebElement page = findElement(By.xpath("#toolbar-1044-innerCt"), "page");
		logger.log(LogStatus.PASS, page.getText()+" is displayed");
		
		WebElement buy = findElement(By.linkText("Buy Now"), "BuyNow");
		clickObject(buy, "BuyNow");
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		endReport();
		
	}
	
	//check if users can look for their subscription and billing
	public  void testID010_A() throws IOException, InterruptedException
	{
		startReport("C:\\Data\\xeroReports\\testID010_A.html", "testID10_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		//login to xero app
		login(UserName1, Password1);
		WebElement businessButton = findElement(By.xpath("//button[contains(text(),'Business')]"), "business");
		clickObject(businessButton, "business");
		WebElement billToPay = findElement(By.linkText("Bills to pay"), "Bills to pay");
		clickObject(billToPay, "Bills to pay");
		WebElement paid = findElement(By.linkText("Paid"), "paid");
		clickObject(paid, "paid");
		
		WebElement repeating = findElement(By.xpath("//a[@href='/AccountsPayable/SearchRepeating.aspx']"), "Repeating");
		clickObject(repeating, "Repeating");
		WebElement all = findElement(By.xpath("//a[@href='/AccountsPayable/Search.aspx']"), "All");
		clickObject(all, "All");
		endReport();
		
		
		
	


	}



}
