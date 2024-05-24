package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);


        String userDataDirectory = System.getProperty("user.dir") + "/data";

        options.addArguments("--user-data-dir=" + userDataDirectory);


        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        // driver.get("https://www.google.com");
        //TestCase01: Verify Calendar Home Page
        // Description: Verify the URL of the Google Calendar home page
        //Test Steps:
        // Navigate to Google Calendar ( https://calendar.google.com/ ).
        driver.get("https://calendar.google.com/ ");
        //Verify that the current URL contains "calendar."
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("calendar")) {
            System.out.println("The URL of Calender homepage contains calender");
        } else {
            System.out.println("The URL of Calender homepage does not contains calender");
        }
        // Expected Result: The URL of the Calendar homepage contains "calendar".
        System.out.println("end Test case: testCase01");
    }
//    public  void testCase02(){
//        System.out.println("Start Test case: testCase02");
//        //TestCase02: Verify Calendar Navigation and Add Task
//        //Description: Switch to the month view, and add a task for today.
//        //Test Steps:
//        driver.get("https://calendar.google.com/");
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        //Switch to the month view.
//
//
//        WebElement dropDwButton = driver.findElement(By.xpath("//button[contains(@class)]"));
//       dropDwButton.click();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement monthDropdwButton = driver.findElement(By.xpath("//*[@id=\"ucc-1\"]/ul/li[3]/span[2]"));
//        monthDropdwButton.click();
//
//        if(monthDropdwButton.isDisplayed()){
//            System.out.println("switched to month view");
//        }
//        else{
//            System.out.println(" Failed to switched to month view");
//        }
//
//        String actualDropdown_text = String.valueOf(driver.findElement(By.xpath("//span[text()='Month']")));
//        //actualDropdown_text.contains("Month");
//        if (actualDropdown_text.contains("Month")){
//            System.out.println("Month view is pass");
//
//        }
//        else{
//            System.out.println("Month view is not pass");
//        }
//        //Click on the calendar to add a task.
//        WebElement calendertoAddtask = driver.findElement(By.xpath("//*[@id="YPCqFe"]"));
//                 calendertoAddtask.click();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        //Navigate to the Tasks tab.
//        WebElement tasksTab = driver.findElement(By.xpath("//*[@id=\"tabTask\"]/div[2]"));
//        tasksTab.click();
//
////        WebElement addTasksTab = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div/button/span[2]"));
////        addTasksTab.click();
//
//       //Select a date and enter task details. Task Details:
//        WebElement dateField = driver.findElement(By.xpath("//*[@id=\"c3413\"]"));
//        //dateField.sendKeys("Dec 10,2023");
//
//        // Assuming 'driver' is your WebDriver instance and 'element' is the input field for an event title
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Clear the existing text in the event title input field
//        js.executeScript("arguments[0].value='';", dateField);
//
//        // Enter a new title for the event
//        dateField.sendKeys("Dec 10,2023");
//
//        // Perform other actions like setting the date, time, etc.
//        // ...
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//           throw new RuntimeException(e);
//        }
//
//      //Title: Crio INTV Task Automation
//        WebElement titleField = driver.findElement(By.xpath("//*[@id=\"c2904\"]"));
//        //titleField.sendKeys("Crio INTV Task Automation");
//       // JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='';", titleField);
//       titleField.sendKeys("Crio INTV Task Automation");
//
//       //Description: Crio INTV Calendar Task Automation
//        WebElement descriptionAdd = driver.findElement(By.xpath("//*[@id=\"c2993\"]"));
//        //JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='';", descriptionAdd);
//        descriptionAdd.sendKeys("Crio INTV Calendar Task Automation");
//
////        WebElement saveDetails = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div[2]/div[2]/div[4]/button/span"));
////        saveDetails.click();
//
//        WebElement result1 = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div[2]/div[2]/div[4]/button/span"));
//        String result1TextValue = result1.getText();
//
//       if(result1.isDisplayed()){
//           System.out.println("The Calendar switched to month view and a task was created.");
//       }
//       else{
//           System.out.println("The Calendar does not switched to month view and a task was created.");
//       }
//

    // Expected Result: The Calendar switched to month view and a task was created.
//                System.out.println("end Test case: testCase02");
//    }

    //    public  void testCase03(){
    //        System.out.println("Start Test case: testCase03");
    //       // TestCase03: Verify the Task Updation
    //        //Description: Select an existing task, update its description, and verify the successful update.
    //        //Test Steps:
    //        driver.get("https://calendar.google.com/");
    //
    //        //Click on an existing task.
    //       WebElement existingTask = driver.findElement(By.xpath("//*[@id=\"rAECCd\"]"));
    //       existingTask.click();
    //
    //        try {
    //            Thread.sleep(5000);
    //        } catch (InterruptedException e) {
    //            throw new RuntimeException(e);
    //        }
    //
    //        //Open the task details.
    //        WebElement taskDetails = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div/div/div[2]/div[1]/span/button/span/svg/path"));
    //        taskDetails.click();
    //
    //        //Update the task description to "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application"
    //        WebElement taskDescription = driver.findElement(By.xpath("//*[@id=\"c3748\"]"));
    //        taskDescription.clear();
    //        taskDescription.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
    //
    //        //Verify that the updated description is displayed.
    //        WebElement updatedDescription = driver.findElement(By.id("///*[@id=\"c4418\"]"));
    //        String actualDescription = updatedDescription.getText();
    //        String expectedDescription = "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application";
    //
    //        //*[@id="yDmH0d"]/div/div/div[2]/span/div/div[9]/div/button/span
    //        if(expectedDescription.contains((CharSequence) updatedDescription)){
    //            System.out.println("The task description is successfully updated and displayed.");
    //        }
    //        else{
    //            System.out.println("The task description is not successfully updated and displayed.");
    //        }
    //
    //        //Expected Result: The task description is successfully updated and displayed.
    //         System.out.println("end Test case: testCase03");
    //    }
    //
    //    public  void testCase04(){
    //        System.out.println("Start Test case: testCase03");
    //        ///TestCase04: Verify the Task deletion
    //        //Description: Delete an existing task and confirm the deletion.
    //        //Test Steps:
    //        //Click on an existing task.
    //        //Open the task details.
    //        //Verify the title of the task.
    //        //Delete the task.
    //        //Confirm the task deletion, by verifying "Task deleted" is displayed.
    //
    //        //Expected Result: The task is successfully deleted, and the confirmation message indicates "Task deleted"
    //
    //
    //        System.out.println("end Test case: testCase04");
    //    }
    //}
    public void testCase02() throws InterruptedException {

        System.out.println("Start Test case: testCase02");

        WebElement month_view = driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div[5]/div/div[1]/div[1]/div/button"));

        month_view.click();

        Thread.sleep(1000);

        WebElement calendar_view_drop_down = driver.findElement(By.xpath("//ul[@jsname='rymPhb']"));

        Thread.sleep(1000);

        if (calendar_view_drop_down.isDisplayed()) {
            System.out.println("Calendar View Drop down is displayed");
        } else {
            System.out.println("Calendar View Drop down is not displayed");
        }

        Thread.sleep(1000);

        WebElement month_select = driver.findElement(By.xpath("//ul[@jsname='rymPhb']/li[3]"));
        month_select.click();

        Thread.sleep(1000);

        WebElement month_view_check = driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div[5]/div/div[1]/div[1]/div/button/span"));
        String month_check = month_view_check.getText();

        System.out.println(month_check);

        if (month_check.contains("Month")) {
            System.out.println("Month is Selected");
        } else {
            System.out.println("Month is not Selected");
        }

        Thread.sleep(2000);

        WebElement calendar_date_select = driver.findElement(By.xpath("//*[@id=\"YPCqFe\"]/div/div/div/div[2]/div[3]/div[1]/div[5]"));
        calendar_date_select.click();

        Thread.sleep(1000);

        WebElement Add_task_box = driver.findElement(By.xpath("//span[@class='JtukPc']/div"));

        if (Add_task_box.isDisplayed()) {
            System.out.println("Add Task Window is Displayed");
        } else {
            System.out.println("Add Task Window is not Displayed");
        }

        WebElement Task_view = driver.findElement(By.xpath("//*[@id='tabTask']"));

        Task_view.click();

        Thread.sleep(1000);

        WebElement check_date = driver.findElement(By.xpath("//*[@id='yDmH0d']/div/div/div[2]/span/div/div[1]/div[2]/div[1]/div[3]/div[3]/span/div/div[1]/div/div[1]/div/div/div[2]/div[1]/button"));
        check_date.click();

        Thread.sleep(1000);

        WebElement Add_Title = driver.findElement(By.xpath("//input[@jsname='YPqjbf' and @placeholder='Add title and time']"));
        Add_Title.click();

        Thread.sleep(1000);

        Add_Title.sendKeys("Crio INTV Task Automation");

        Thread.sleep(1000);

        WebElement add_Description = driver.findElement(By.xpath("//textarea[@rows='3' and @jsname='YPqjbf']"));

        add_Description.click();

        add_Description.sendKeys("Crio INTV Calendar Task Automation");

        Thread.sleep(1000);

        WebElement Save_Task = driver.findElement(By.xpath("//button[@jsname='x8hlje']"));
        Save_Task.click();

        Thread.sleep(1000);

        WebElement Task_Verification = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[3]/div[3]/div/div[5]/div/div/div"));

        if (Task_Verification.isDisplayed()) {
            System.out.println("The Calendar switched to month view and a task was created");
        } else {
            System.out.println("The Calendar is not switched to month view and a task was not created");
        }

        Thread.sleep(2000);

        System.out.println("End Test case: testCase02");

    }

    public void testCase03() throws InterruptedException {

        System.out.println("Start Test case: testCase03");

        WebElement open_existing_task = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[3]/div[3]/div/div[5]/div/div/div/span[1]/span"));

        open_existing_task.click();

        Thread.sleep(1000);

        WebElement edit_existing_task = driver.findElement(By.xpath("//button[@jscontroller=\"soHxf\" and @aria-label=\"Edit task\"]"));

        edit_existing_task.click();

        Thread.sleep(1000);

        WebElement edit_Description = driver.findElement(By.xpath("//textarea[@rows='3' and @jsname='YPqjbf']"));

        edit_Description.click();

        Thread.sleep(1000);

        edit_Description.clear();

        Thread.sleep(1000);

        edit_Description.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");

        Thread.sleep(1000);

        WebElement Save_Task = driver.findElement(By.xpath("//button[@jsname='x8hlje']"));
        Save_Task.click();

        Thread.sleep(1000);

        open_existing_task.click();

        Thread.sleep(1000);

        WebElement updated_Description_check = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[2]/div[3]/div[2]"));

        String updated_Description_validation = updated_Description_check.getText();

        if (updated_Description_validation.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")) {
            System.out.println("The task description is successfully updated and displayed");
        } else {
            System.out.println("The task description is not successfully updated and not displayed");
        }

        Thread.sleep(2000);

        WebElement close_button = driver.findElement(By.xpath("//*[@id='xDetDlgCloseBu']"));

        close_button.click();

        Thread.sleep(2000);

        System.out.println("End Test case: testCase03");

    }

    public void testCase04() throws InterruptedException {

        System.out.println("Start Test case: testCase04");

        WebElement open_existing_task = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[3]/div[3]/div/div[5]/div/div/div/span[1]/span"));

        open_existing_task.click();

        Thread.sleep(1000);

        WebElement existing_title_check = driver.findElement(By.xpath("//*[@id='rAECCd']"));

        String existing_title_verification = existing_title_check.getText();

        if (existing_title_verification.contains("Crio INTV Task Automation")) {
            System.out.println("Task title is verified successfully");
        } else {
            System.out.println("Task title is not verified successfully");
        }

        Thread.sleep(2000);

        WebElement delete_task = driver.findElement(By.xpath("//button[@jsname='VkLyEc' and @aria-label='Delete task']"));
        delete_task.click();

        Thread.sleep(2000);

        WebElement deleteTask_verification = driver.findElement(By.xpath("//div[@class='VYTiVb']"));

        String deleteTask_validation = deleteTask_verification.getText();

        if (deleteTask_verification.isDisplayed()) {
            System.out.println("\"Task Deleted\" is displayed");

            System.out.println("The task is successfully deleted, and the confirmation message indicates \"Task deleted\"");
        } else {
            System.out.println("\"Task Deleted\" is not displayed");

            System.out.println("The task is not successfully deleted, and the confirmation message indicates \"Task is not deleted\"");
        }

        if (deleteTask_validation.contains("Task deleted")) {
            System.out.println("\"Task Deleted\" is displayed");

            System.out.println("The task is successfully deleted, and the confirmation message indicates \"Task deleted\"");
        } else {
            System.out.println("\"Task Deleted\" is not displayed");

            System.out.println("The task is not successfully deleted, and the confirmation message indicates \"Task is not deleted\"");
        }

        System.out.println("End Test case: testCase04");


    }
}