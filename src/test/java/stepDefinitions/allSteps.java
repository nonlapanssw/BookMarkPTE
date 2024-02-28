package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.*;

public class allSteps {

    //Constant
    WebDriver driver = null;
    int waitShort = 60;
    String remoteAllowOrigin = "--remote-allow-origins=*";
    String expectedTitleName = "WorldTicket";
    String chromeDriver = "webdriver.chrome.driver";
    String path = "/src/test/resources/drivers/chromedriver";
    String userDir = System.getProperty("user.dir");
    String username = "nonlapan.ssw@gmail.com";
    String password = "Por0853173719";

    //xpath
    final String login = "//*[text()='Login']";
    final String usernameInput = "//input[@id='user_email']";
    final String passwordInput = "//input[@id='user_password']";

    final String agree_privacy = "//input[@id='agree_privacy']";

    final String signInButton = "//input[@id='sign-in-btn']";

    final String predic_tested = "//*[@data-tracking-event='practice_or_predic_click_tested']";



    @Given("User is on APEUni page")
    public void navigateToHomePage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(remoteAllowOrigin);
        System.setProperty(chromeDriver,
                userDir + path);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitShort));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waitShort));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.apeuni.com/");

    }
    @When("User login to APEUni website")
    public void loginWithCredential() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitShort));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login)));
        driver.findElement(By.xpath(login)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(usernameInput)));
        driver.findElement(By.xpath(usernameInput)).sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordInput)));
        driver.findElement(By.xpath(passwordInput)).sendKeys(password);

        driver.findElement(By.xpath(agree_privacy)).click();
        driver.findElement(By.xpath(signInButton)).click();
    }

    @When("User go to Reading & Writing：Fill in the blanks")
    public void goToReadingWritingFillInTheBlanks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitShort));
        driver.navigate().to("https://www.apeuni.com/en/practice/fib_wr/74");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(predic_tested)));

        System.out.println(driver.findElement(By.xpath(predic_tested)).getText());


    }
}
