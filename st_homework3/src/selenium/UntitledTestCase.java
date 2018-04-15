package selenium;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  String driverPath = System.getProperty("user.dir")+"/geckodriver-v0.20.1-win64/geckodriver.exe";   
  
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver",driverPath); 
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	String temp = null;
	String link = null;
	File file = new File("D:/study/test/input.xlsx");
	InputStream inputStream = null;
	Workbook workbook = null;
	try {
		inputStream = new FileInputStream(file);
	    workbook = WorkbookFactory.create(inputStream);
	    inputStream.close();
	    Sheet sheet = workbook.getSheetAt(0);
	    int rowLength = sheet.getLastRowNum()+1;
	    Row row = sheet.getRow(0);
	    int colLength = row.getLastCellNum();
	    Cell cell = row.getCell(0);
	    CellStyle cellStyle = cell.getCellStyle();
	    for (int i = 0; i < rowLength; i++) {
	    	row = sheet.getRow(i);
	    	for (int j = 0; j < colLength; j++) {
	    		cell = row.getCell(j);
	    		if (cell != null){
	    			cell.setCellType(CellType.STRING);
	    		}    
	    		if (j == 0){
	    			temp = cell.getStringCellValue();
	    		}
	    		else{
	    			link = cell.getStringCellValue();
	    		}
	    	}
	    	driver.get("https://psych.liebes.top/st");
    	    driver.findElement(By.id("username")).click();
    	    driver.findElement(By.id("username")).clear();
    	    driver.findElement(By.id("username")).sendKeys(temp);
    	    driver.findElement(By.id("password")).click();
    	    driver.findElement(By.id("password")).clear();
    	    driver.findElement(By.id("password")).sendKeys(temp.substring(4));
    	    driver.findElement(By.id("submitButton")).click();
    	    assertEquals(link, driver.findElement(By.xpath("//p")).getText());
	    }
	} catch (Exception e) {
	  	e.printStackTrace();
	}
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}