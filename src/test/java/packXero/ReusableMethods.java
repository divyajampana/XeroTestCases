package packXero;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	
	/*Name of the method	:startReport
	 * Description			:Starting extentReport and logger	
	 * Arguments			:path, testcase
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void startReport(String path, String testCase)
	{
		report = new ExtentReports (System.getProperty("user.dir") +"/test-output/XEROExtentReport.html", false);
		logger = report.startTest(testCase);
	}
	
	/*Name of the method	:InitializeDriver
	 * Description			:Set Property of driver and initialize driver	
	 * Arguments			:no
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void InitializeDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Seleniumdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	/*Name of the method	:Launch
	 * Description			:Launching URL of application	
	 * Arguments			:url
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void Launch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO, "Firefox browser launched");
	}

	/*Name of the method	:enterText
	 * Description			:Sending text to text feild	
	 * Arguments			:WebElement, objName, textValue
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void enterText(WebElement obj, String objName, String textValue) {
		if(obj == null)
		{
			return;
		}
		if(obj.isDisplayed()) {
			obj.sendKeys(textValue);

			logger.log(LogStatus.PASS, textValue + " textValue " + " entered in "+ objName);

		}else
		{
			logger.log(LogStatus.FAIL, objName + " could not be found");
		}
	}

	/*Name of the method	:clickObject
	 * Description			:Clicking on the element 
	 * Arguments			:WebElement, objName
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void clickObject(WebElement obj, String objName)
	{
		if(obj == null)
		{
			return;
		}

		if(obj.isDisplayed()) {

			obj.click();

			logger.log(LogStatus.PASS, objName + " is Clicked");

		}else
		{
			logger.log(LogStatus.FAIL, objName + " could not be found ");
		}
	}
	
	/*Name of the method	:selectCheckBox
	 * Description			:Selecting check box
	 * Arguments			:WebElement, objName
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void selectCheckBox(WebElement obj, String objName)
	{
		if(obj == null)
		{
			return;
		}

		if(obj.isDisplayed()) {
			if(!obj.isSelected())
			{
				obj.click();
				logger.log(LogStatus.PASS, "checkbox "+objName + " is selected");
			}

		}else
		{
			logger.log(LogStatus.FAIL, objName + " could not be found ");
		}
	}
	
	/*Name of the method	:SelectByIndex
	 * Description			:Selecting  dropdown list
	 * Arguments			:WebElement, objName, index
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	
	public static void SelectByIndex(WebElement obj, String objName, int index) 
	{
		if(obj == null)
		{
			return;
		}
		if(obj.isDisplayed()) {
			Select select =new Select(obj);
			select.selectByIndex(index);;
			logger.log(LogStatus.PASS, "Dropdown "+ objName + " is selected");
		}else
		{
			logger.log(LogStatus.FAIL, objName + " could not be found ");
		}
	}
	
	/*Name of the method	:SelectByValue
	 * Description			:Selecting  dropdown list
	 * Arguments			:WebElement, objName, value
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void SelectByValue(WebElement obj, String objName, String value) 
	{
		if(obj == null)
		{
			return;
		}
		if(obj.isDisplayed()) {
			Select select =new Select(obj);
			select.selectByValue(value);
			logger.log(LogStatus.PASS, "Dropdown "+ objName + " is selected");
		}else
		{
			logger.log(LogStatus.FAIL, objName + " could not be found ");
		}
	}
	
	/*Name of the method	:SelectByVisibleText
	 * Description			:Selecting  dropdown list
	 * Arguments			:WebElement, objName, value
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void SelectByVisibleText(WebElement obj, String objName, String value) 
	{
		if(obj == null)
		{
			return;
		}
		if(obj.isDisplayed()) {
			Select select =new Select(obj);
			select.selectByVisibleText(value);
			logger.log(LogStatus.PASS, "Dropdown "+ objName + " is selected");
		}else
		{
			logger.log(LogStatus.FAIL, objName + " could not be found ");
		}

	}
	
	/*Name of the method	:mouseHover
	 * Description			:Mouse hover an object
	 * Arguments			:WebElement, objName
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	
	public static void mouseHover(WebElement obj, String objName)
	{
		if(obj.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(obj).build().perform();
			logger.log(LogStatus.PASS, "MouseHovered on "+objName);
		}else
		{
			logger.log(LogStatus.FAIL, objName + " could not be found ");
		}
	}
	
	/*Name of the method	:findElement
	 * Description			:Finding the location of the element in application
	 * Arguments			:location, objName
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static WebElement findElement(By location, String objName)
	{
		WebElement obj = null;
		try
		{
			obj=driver.findElement(location);
			logger.log(LogStatus.PASS, objName + " found on the page.");

		}catch(NoSuchElementException errMessage) {

			logger.log(LogStatus.FAIL, objName + " could not be found on the page.");
		}
		return obj;
	}
	
	/*Name of the method	:compareStrings
	 * Description			:Comparing two strings
	 * Arguments			:actual, expected
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void compareStrings(String Actual, String Expected)
	{
		 if(Actual.equals(Expected))
		    {
		    	logger.log(LogStatus.PASS, " Verified- Expected and actual message are equal");
		    }
		    else
		    {
		    	logger.log(LogStatus.FAIL, (" Verified- Expected and actual message are notequal"));
		    }
	}
	
	/*Name of the method	:endReport
	 * Description			:Ending testreport and flushing it
	 * Arguments			:no
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static void endReport()
	{
		driver.quit();
		report.endTest(logger);
		report.flush();
	}
	
	/*Name of the method	:readExcelData
	 * Description			:Reading exceldata into script
	 * Arguments			:dataTablePath, sheetName
	 * Created By			:Mohana
	 * Created Date			:29/mar/2019
	 * Last Modified		:
	 */
	public static String[][] readExcelData(String dataTablePath, String sheetName)throws IOException
	{
		/*Step1 get excel path*/
		File xlFile = new File(dataTablePath);//file object
		//step2 get the excel file
		FileInputStream xlDoc = new FileInputStream(xlFile);
		//step3 access workbook

		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);//HSSF is class in poi
		//Step4 access the sheet
		HSSFSheet Sheet = wb.getSheet(sheetName);
		wb.close();

		int iRowCount = Sheet.getLastRowNum()+1;
		int iColCount = Sheet.getRow(0).getLastCellNum();

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i=0; i<iRowCount; i++)
		{
			for(int j=0; j<iColCount; j++) {
				xlData[i][j]= Sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return xlData;
		
	}


}


