package SouravSingh.Capstone_Project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CapstoneProject {

    public static void main(String[] args) throws Exception {

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        System.out.println("Browser launched successfully.");

        // Maximize the browser window
        driver.manage().window().maximize();
        System.out.println("Browser window maximized.");

        // Navigate to the test automation practice website
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("Navigated to: https://testautomationpractice.blogspot.com/");


        // ================= PAGE TITLE ASSERTION =================

        System.out.println("Page Title Validation Started.");

        // Getting Actual Title
        String actualTitle = driver.getTitle();

        // Expected Title
        String expectedTitle = "Automation Testing Practice";

        // Applying Assertion
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Page Title Validation Passed: " + actualTitle);


        // ================= FORM FIELDS =================

        System.out.println("Text Field Automation Started.");

        // Enter Name
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']"))
                .sendKeys("Sourav Singh");
        System.out.println("Name entered: Sourav Singh");
        Thread.sleep(2000);

        // Enter Email
        driver.findElement(By.id("email")).sendKeys("heaveneater@gmail.com");
        System.out.println("Email entered: heaveneater@gmail.com");
        Thread.sleep(2000);

        // Enter Phone Number
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        System.out.println("Phone entered: 1234567890");
        Thread.sleep(2000);

        // Enter Address in Textarea
        driver.findElement(By.id("textarea")).sendKeys("Jharsugda,Odisha");
        System.out.println("Address entered: Jharsugda,Odisha");
        Thread.sleep(2000);


        // ================= RADIO BUTTON =================

        System.out.println("Radio Button Automation Started.");

        // Select Gender: Male
        driver.findElement(By.id("male")).click();
        System.out.println("Radio Button selected: Male");
        Thread.sleep(2000);


        // ================= CHECKBOXES =================

        System.out.println("Checkbox Automation Started.");

        // Select Sunday
        driver.findElement(By.id("sunday")).click();
        System.out.println("Checkbox checked: Sunday");
        Thread.sleep(2000);


        // ================= DROPDOWNS =================

        System.out.println("Dropdown Automation Started.");

        // Select Country: India
        Select country = new Select(driver.findElement(By.xpath("//select[contains(@id,'country')]")));
        country.selectByVisibleText("India");
        System.out.println("Country selected: India");
        Thread.sleep(2000);

        // Select Color: White
        Select colors = new Select(driver.findElement(By.xpath("//select[contains(@id,'colors')]")));
        colors.selectByVisibleText("White");
        System.out.println("Color selected: White");
        Thread.sleep(2000);

        // Select Animal: Rabbit
        Select animals = new Select(driver.findElement(By.id("animals")));
        animals.selectByVisibleText("Rabbit");
        System.out.println("Animal selected: Rabbit");
        Thread.sleep(2000);


        // ================= DATE PICKERS =================

        System.out.println("Date Picker Automation Started.");

        // Date Picker 1: Standard input
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.id("datepicker")).sendKeys("03/25/2026");
        System.out.println("Date Picker 1 (datepicker) set to: 03/25/2026");
        Thread.sleep(2000);

        // Click label to dismiss calendar popup
        driver.findElement(By.xpath("//label[contains(text(),'Date Picker 3')]")).click();
        System.out.println("Clicked elsewhere to close the calendar popup.");

        // Date Picker 2: JS Executor (read-only field)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = driver.findElement(By.id("txtDate"));
        js.executeScript("arguments[0].value='09/09/2021';", date);
        System.out.println("Date Picker 2 (txtDate) set via JavaScript: 09/09/2021");
        Thread.sleep(2000);

        // Date Picker 3: Start Date
        driver.findElement(By.id("start-date")).sendKeys("12-05-2004");
        System.out.println("Start Date entered: 12-05-2004");
        Thread.sleep(2000);

        // Date Picker 3: End Date
        driver.findElement(By.id("end-date")).sendKeys("12-05-2005");
        System.out.println("End Date entered: 12-05-2005");
        Thread.sleep(2000);

        // Click Submit button for date range
        driver.findElement(By.xpath("//button[@class='submit-btn']")).click();
        System.out.println("Submit button clicked for date range.");
        Thread.sleep(2000);


        // ================= FILE UPLOAD =================

        System.out.println("File Upload Automation Started.");

        String singleFilePath = new File("C:\\Users\\SOURAV SINGH\\OneDrive\\Desktop\\Wipro Assignments\\1776959736860-Assignment SDET - Day 1.pdf").getAbsolutePath();
        String file1Path = new File("C:\\Users\\SOURAV SINGH\\OneDrive\\Desktop\\Wipro Assignments\\1778330467761-Assignment APRIL SDET - Day 15.pdf").getAbsolutePath();
        String file2Path = new File("C:\\Users\\SOURAV SINGH\\OneDrive\\Pictures\\images.jpg").getAbsolutePath();

        // Single File Upload
        WebElement singleInput = driver.findElement(By.id("singleFileInput"));
        singleInput.sendKeys(singleFilePath);
        System.out.println("Single file selected: " + singleFilePath);

        WebElement singleSubmitBtn = driver.findElement(By.xpath("//form[@id='singleFileForm']/button"));
        singleSubmitBtn.click();
        System.out.println("Single file upload form submitted.");

        // Multiple Files Upload
        WebElement multipleInput = driver.findElement(By.id("multipleFilesInput"));
        String multipleFilesPaths = file1Path + "\n" + file2Path;
        multipleInput.sendKeys(multipleFilesPaths);
        System.out.println("Multiple files selected: \n  File1: " + file1Path + "\n  File2: " + file2Path);

        WebElement multipleSubmitBtn = driver.findElement(By.xpath("//form[@id='multipleFilesForm']/button"));
        multipleSubmitBtn.click();
        System.out.println("Multiple files upload form submitted.");


        // ================= ACTIONS CLASS =================

        Actions act = new Actions(driver);

        // Mouse Hover
        System.out.println("Mouse Hover Automation Started.");
        WebElement pointMe = driver.findElement(By.xpath("//button[text()='Point Me']"));
        act.moveToElement(pointMe).perform();
        Thread.sleep(2000);
        System.out.println("Action performed: Mouse Hover on 'Point Me' button.");

        // Clear field1 and enter text before double click
        driver.findElement(By.id("field1")).clear();
        driver.findElement(By.id("field1")).sendKeys("Sourav Singh");
        System.out.println("Text entered in field1: Sourav Singh");

        // Double Click on Copy Text button
        System.out.println("Double Click Automation Started.");
        WebElement copyBtn = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        act.doubleClick(copyBtn).perform();
        System.out.println("Action performed: Double Click on 'Copy Text' button.");
        Thread.sleep(2000);

        // ================= COPY TEXT VALIDATION =================

        System.out.println("Copy Text Validation Started.");

        // Get field1 value
        String firstFieldText = driver.findElement(By.id("field1")).getAttribute("value");

        // Get field2 value (should be copied)
        String secondFieldText = driver.findElement(By.id("field2")).getAttribute("value");

        // Assert both fields are equal
        Assert.assertEquals(firstFieldText, secondFieldText);
        System.out.println("Copy Text Validation Passed: field1='" + firstFieldText + "' field2='" + secondFieldText + "'");

        // Drag and Drop
        System.out.println("Drag and Drop Automation Started.");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        act.dragAndDrop(source, target).perform();
        Thread.sleep(2000);
        System.out.println("Action performed: Drag and Drop — source dropped onto target.");

        // Slider
        System.out.println("Slider Automation Started.");
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scrolled to Slider section.");
        WebElement slider = driver.findElement(
                By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        act.dragAndDropBy(slider, 100, 0).perform();
        Thread.sleep(2000);
        System.out.println("Action performed: Slider moved 100px to the right.");


        // ================= SCROLLING DROPDOWN (COMBOBOX) =================

        System.out.println("Scrolling Dropdown Automation Started.");

        // Click the comboBox input
        driver.findElement(By.id("comboBox")).click();
        System.out.println("Scrolling Dropdown clicked.");

        // Enter item name
        driver.findElement(By.id("comboBox")).sendKeys("Item 5");
        System.out.println("Item 5 entered in Scrolling Dropdown.");
        Thread.sleep(2000);
      
        
        
        // ================= WIKIPEDIA SEARCH =================

        // Type "Selenium" and press Enter in Wikipedia search widget
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium" + Keys.ENTER);
        System.out.println("Wikipedia search: typed 'Selenium' and pressed Enter.");
        Thread.sleep(2000);


        // ================= DYNAMIC BUTTON =================

        System.out.println("Dynamic Button Automation Started.");

        // Click START button
        WebElement dynamicBtn = driver.findElement(By.xpath("//button[@name='start']"));
        System.out.println("Dynamic Button current text: " + dynamicBtn.getText());
        dynamicBtn.click();
        Thread.sleep(2000);
        System.out.println("Clicked START button → now changed to: " + dynamicBtn.getText());

        // Click STOP button (same element, text toggled)
        dynamicBtn.click();
        Thread.sleep(2000);
        System.out.println("Clicked STOP button → now changed to: " + dynamicBtn.getText());



        // ================= ALERTS =================

        System.out.println("Alert Automation Started.");
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scrolled to Alert section.");

        // Simple Alert
        driver.findElement(By.id("alertBtn")).click();
        System.out.println("Simple Alert opened.");

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am an alert box!";
        Assert.assertEquals(actualAlertText, expectedAlertText);
        System.out.println("Simple Alert text validation passed: " + actualAlertText);

        driver.switchTo().alert().accept();
        System.out.println("Simple Alert accepted.");
        Thread.sleep(2000);

        // Confirm Alert — Dismiss first, then Accept
        driver.findElement(By.id("confirmBtn")).click();
        Alert b = driver.switchTo().alert();
        System.out.println("Confirm Alert text: " + b.getText());
        Thread.sleep(2000);
        b.dismiss();
        System.out.println("Confirm Alert dismissed.");
        Thread.sleep(2000);

        driver.findElement(By.id("confirmBtn")).click();
        Alert b2 = driver.switchTo().alert();
        System.out.println("Confirm Alert opened again: " + b2.getText());
        Thread.sleep(2000);
        b2.accept();
        System.out.println("Confirm Alert accepted.");
        Thread.sleep(2000);

        // Prompt Alert
        driver.findElement(By.id("promptBtn")).click();
        Alert c = driver.switchTo().alert();
        System.out.println("Prompt Alert text: " + c.getText());
        c.sendKeys("Sourav Singh");
        System.out.println("Prompt Alert input entered: Sourav Singh");
        Thread.sleep(2000);
        c.accept();
        System.out.println("Prompt Alert accepted.");


        // ================= PAGE SCROLL =================

        System.out.println("Page Scroll Automation Started.");

        // Scroll Down to bottom
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        System.out.println("JavaScript Scroll: Scrolled DOWN to bottom of the page.");
        Thread.sleep(3000);

        // Scroll Up to top
        js.executeScript("window.scrollTo(0,0)");
        System.out.println("JavaScript Scroll: Scrolled UP to top of the page.");
        Thread.sleep(3000);        


        // ================= HYPERLINK COUNT =================

        System.out.println("Hyperlink Count Automation Started.");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total hyperlinks found on page: " + links.size());

        

        // ================= NEW TAB =================

        System.out.println("New Tab Automation Started.");
        driver.findElement(By.xpath("//button[text()='New Tab']")).click();
        System.out.println("New Tab button clicked successfully.");
        Thread.sleep(2000);


        // ================= POPUP WINDOW =================

        System.out.println("Popup Window Automation Started.");
        driver.findElement(By.xpath("//button[text()='Popup Windows']")).click();
        System.out.println("Popup Window button clicked successfully.");
        Thread.sleep(2000);
        
        
        // ================= SCREENSHOT =================

        System.out.println("Screenshot Capture Started.");

        // Scroll to top before screenshot
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);

        // Take Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        // Save to your project workspace folder
        File destinationFile = new File(
                "C:\\Users\\SOURAV SINGH\\eclipse-workspace\\Capstone_Project\\ProjectScreenshot.png");
        FileHandler.copy(sourceFile, destinationFile);
        System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());


        // ================= BROWSER CLOSE =================

        driver.quit();
        System.out.println("Browser closed. Test execution completed successfully.");
    }
}