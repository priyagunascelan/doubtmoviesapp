package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MovieDetailsPageTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @When("I click the movie in home page")
    public void uiElpresentInHome(){
        //wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class ='movies-list-heading']")));
        WebElement clickMovie = driver.findElement(By.xpath("(//div[@data-index = '5'])[1]"));
        clickMovie.click();

    }

}
