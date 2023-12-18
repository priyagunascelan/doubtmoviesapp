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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @When("I Test in the Home Page click on any Movie and test all the UI elements present in it")
    public void uiElpresentInHome(){
        WebElement clickMovie = driver.findElement(By.xpath("//div[@class='home-bottom-container']/div[1]/div/div/div/div/div/div/a/div/img"));
        clickMovie.click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305"));
        List<WebElement> movieDetails =driver.findElements(By.xpath("//div[@class ='nav-content']/ul"));
        Assert.assertEquals(movieDetails.size(),1);
    }
    @Then("I Test in the Popular Page click on any Movie and test all the UI elements present in it")
    public void uiElpresentInPopular(){
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        WebElement clickMovie = driver.findElement(By.xpath("//div[@class = 'search-movies-container']/li[1]/a/img"));
        clickMovie.click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f"));
        List<WebElement> movieDetails =driver.findElements(By.xpath("//div[@class ='nav-content']/ul"));
        Assert.assertEquals(movieDetails.size(),1);
    }
}
