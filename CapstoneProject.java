package SouravSingh.Capstone_Project;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
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

        // Verify page heading is present
        WebElement wb = driver.findElement(
                By.xpath("//h1[contains(text(),'Automation Testing Practice')]"));
        System.out.println("Page Heading Found: " + wb.getText());
        
       
        // ── FORM FIELDS ──────────────────────────────────────────────

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

        // ── RADIO BUTTON ─────────────────────────────────────────────

        // Select Gender: Male
        driver.findElement(By.id("male")).click();
        System.out.println("Radio Button selected: Male");
        Thread.sleep(2000);

        // ── CHECKBOX ─────────────────────────────────────────────────

        // Select Day: Sunday
        driver.findElement(By.id("sunday")).click();
        System.out.println("Checkbox checked: Sunday");
        Thread.sleep(2000);

        // ── DROPDOWNS ────────────────────────────────────────────────

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

        // ── DATE PICKERS ─────────────────────────────────────────────

        // Date Picker 1: Standard input type date
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.id("datepicker")).sendKeys("03/25/2026");
        System.out.println("Date Picker 1 (datepicker) set to: 03/25/2026");
        Thread.sleep(2000);

        // Click label to dismiss calendar popup
        driver.findElement(By.xpath("//label[contains(text(),'Date Picker 3')]")).click();
        System.out.println("Clicked elsewhere to close the calendar popup.");

        // Date Picker 2: JS Executor used (read-only field)
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

        // ── FILE UPLOAD ───────────────────────────────────────────────

        // Define file paths for upload
        String singleFilePath = new File("C:\\Users\\SOURAV SINGH\\OneDrive\\Desktop\\Wipro Assignments\\1776959736860-Assignment SDET - Day 1.pdf").getAbsolutePath();
        String file1Path = new File("C:\\Users\\SOURAV SINGH\\OneDrive\\Desktop\\Wipro Assignments\\1778330467761-Assignment APRIL SDET - Day 15.pdf").getAbsolutePath();
        String file2Path = new File("C:\\Users\\SOURAV SINGH\\OneDrive\\Pictures\\images.jpg").getAbsolutePath();

        // Single File Upload
        WebElement singleInput = driver.findElement(By.id("singleFileInput"));
        singleInput.sendKeys(singleFilePath);
        System.out.println("Single file uploaded: " + singleFilePath);

        WebElement singleSubmitBtn = driver.findElement(By.xpath("//form[@id='singleFileForm']/button"));
        singleSubmitBtn.click();
        System.out.println("Single file upload form submitted.");

        // Multiple Files Upload
        WebElement multipleInput = driver.findElement(By.id("multipleFilesInput"));
        String multipleFilesPaths = file1Path + "\n" + file2Path;
        multipleInput.sendKeys(multipleFilesPaths);
        System.out.println("Multiple files uploaded: \n  File1: " + file1Path + "\n  File2: " + file2Path);

        WebElement multipleSubmitBtn = driver.findElement(By.xpath("//form[@id='multipleFilesForm']/button"));
        multipleSubmitBtn.click();
        System.out.println("Multiple files upload form submitted.");

        // ── ACTIONS CLASS ─────────────────────────────────────────────

        Actions act = new Actions(driver);

        // Double Click
        WebElement copyBtn = driver.findElement(
                By.xpath("//button[text()='Copy Text']"));
        act.doubleClick(copyBtn).perform();
        System.out.println("Action performed: Double Click on 'Copy Text' button.");

        // Mouse Hover
        WebElement pointMe = driver.findElement(
                By.xpath("//button[text()='Point Me']"));
        act.moveToElement(pointMe).perform();
        Thread.sleep(2000);
        System.out.println("Action performed: Mouse Hover on 'Point Me' button.");

        // Drag and Drop
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        act.dragAndDrop(source, target).perform();
        Thread.sleep(2000);
        System.out.println("Action performed: Drag and Drop — source dropped onto target.");

        // Slider
        WebElement slider = driver.findElement(
                By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        act.dragAndDropBy(slider, 100, 0).perform();
        Thread.sleep(2000);
        System.out.println("Action performed: Slider moved 100px to the right.");

        // Dynamic Links Count
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Thread.sleep(2000);
        System.out.println("Total hyperlinks found on page: " + links.size());

        // Read copied text from name field
        String text = driver.findElement(By.id("name")).getAttribute("value");
        System.out.println("Value in 'name' field after double-click copy: " + text);
        
        // Find Wikipedia search input and type "Selenium" then press Enter
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium" + Keys.ENTER);
        System.out.println("Wikipedia search: typed 'Selenium' and pressed Enter.");
        
        // Dynamic Button - Click START then STOP

        // Click START button
        WebElement dynamicBtn = driver.findElement(By.xpath("//button[@name='start']"));
        System.out.println("Dynamic Button current text: " + dynamicBtn.getText());
        dynamicBtn.click();
        Thread.sleep(2000);
        System.out.println("Clicked START button → now changed to: " + dynamicBtn.getText());

        // Click STOP button (same element, text changed to STOP)
        dynamicBtn.click();
        Thread.sleep(2000);
        System.out.println("Clicked STOP button → now changed to: " + dynamicBtn.getText());


        // ── ALERTS ───────────────────────────────────────────────────

        // Simple Alert
        driver.findElement(By.id("alertBtn")).click();
        Alert a = driver.switchTo().alert();
        System.out.println("Simple Alert text: " + a.getText());
        Thread.sleep(3000);
        a.accept();
        System.out.println("Simple Alert accepted.");
        Thread.sleep(2000);

        // Confirm Alert
        driver.findElement(By.id("confirmBtn")).click();
        Alert b = driver.switchTo().alert();
        System.out.println("Confirm Alert text: " + b.getText());
        Thread.sleep(3000);
        b.dismiss();
        System.out.println("Confirm Alert dismissed.");
        Thread.sleep(3000);

        // Prompt Alert
        driver.findElement(By.id("promptBtn")).click();
        Alert c = driver.switchTo().alert();
        System.out.println("Prompt Alert text: " + c.getText());
        c.sendKeys("Sourav Singh");
        System.out.println("Prompt Alert input entered: Sourav Singh");
        Thread.sleep(2000);
        c.accept();
        System.out.println("Prompt Alert accepted.");

        // ── JAVASCRIPT SCROLL ─────────────────────────────────────────

        Thread.sleep(3000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        // Scroll Down to bottom
        js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        System.out.println("JavaScript Scroll: Scrolled DOWN to bottom of the page.");
        Thread.sleep(3000);

        // Scroll Up to top
        js1.executeScript("window.scrollTo(0,0)");
        System.out.println("JavaScript Scroll: Scrolled UP to top of the page.");
        Thread.sleep(3000);

        // Close the browser
        driver.quit();
        System.out.println("Browser closed. Test execution completed successfully.");
    }
}