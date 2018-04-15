package test;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	String temp = null;
	int mid = 0;
	Workbook wb = null;
    Sheet sheet = null;
    Row row = null;
    List<Map<String,String>> list = null;
    String cellData = null;
    String filePath = "D:\\study\\st\\test.xlsx";
    String columns[] = {"name","age","score"};
    wb = readExcel(filePath);
    if(wb != null){
        list = new ArrayList<Map<String,String>>();
        sheet = wb.getSheetAt(0);
        int rownum = sheet.getPhysicalNumberOfRows();
        row = sheet.getRow(0);
        int colnum = row.getPhysicalNumberOfCells();
        for (int i = 1; i<rownum; i++) {
            Map<String,String> map = new LinkedHashMap<String,String>();
            row = sheet.getRow(i);
            for (int j=0;j<colnum;j++){
                cellData = (String) getCellFormatValue(row.getCell(j));
                map.put(columns[j], cellData);
            }
            list.add(map);
        }
    }
    for (Map<String,String> map : list) {
        for (Entry<String,String> entry : map.entrySet()) {
        	if (mid == 1) {
        		mid = 2;
        		temp = entry.getValue();
        		break;
        	}
            if (entry.getValue().equals("3015218144")) {
              	mid = 1;
            }
        }
        if (mid == 2) {
        	break;
        }
    }
    driver.get("https://psych.liebes.top/st");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("3015218144");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("218144");
    driver.findElement(By.id("submitButton")).click();
    assertEquals(temp, driver.findElement(By.xpath("//p")).getText());
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
  public static Workbook readExcel(String filePath){
    Workbook wb = null;
    if(filePath==null){
        return null;
    }
    String extString = filePath.substring(filePath.lastIndexOf("."));
    InputStream is = null;
    try {
        is = new FileInputStream(filePath);
        return wb = new XSSFWorkbook(is);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return wb;
  }
  public static Object getCellFormatValue(Cell cell){
    Object cellValue = cell.getRichStringCellValue().getString();
    return cellValue;
  }
}