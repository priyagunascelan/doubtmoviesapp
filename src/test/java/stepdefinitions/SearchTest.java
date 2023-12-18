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

public class SearchTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @When("I Test the Search functionality by searching with some movie names")
    public void searchFunctionality(){
        WebElement searchEl = driver.findElement(By.xpath("//button[@class='search-empty-button']"));
        searchEl.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='search-container']/input")));
        WebElement searchClickEl = driver.findElement(By.xpath("//div[@class ='search-container']/input"));
        searchClickEl.sendKeys("L");
        WebElement submitEl = driver.findElement(By.xpath("//div[@class ='search-container']/button"));
        submitEl.click();
    }
    @Then("I count of movies displayed")
    public void countMoviesDisplay(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class = 'search-movies-container']")));
        List<WebElement> getMovieCount = driver.findElements(By.xpath("//ul[@class = 'search-movies-container']/li"));
        Assert.assertEquals(getMovieCount.size(),29);
    }
}
