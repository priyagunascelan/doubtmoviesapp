package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePageTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("I test the heading texts of each section")
    public void headingSection(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'Trending Now']")));
        WebElement moviesHead1 = driver.findElement(By.xpath("//h1[text() = 'Trending Now']"));
        Assert.assertEquals(moviesHead1.getText(),"Trending Now");
        WebElement moviesHead2 = driver.findElement(By.xpath("//h1[text() = 'Originals']"));
        Assert.assertEquals(moviesHead2.getText(),"Originals");
    }
    @When("I test whether the play button is displayed or not")
    public void playButton(){
        WebElement playButton = driver.findElement(By.xpath("//button[text() ='Play']"));
        boolean checkPlay = playButton.isDisplayed();
        Assert.assertTrue(checkPlay);
    }
    @And("I test whether the Movies are displayed, in the corresponding movies sections")
    public void moviesListSection(){
        List<WebElement> moviesList = driver.findElements(By.cssSelector("img.poster"));
        Assert.assertEquals(moviesList.size(),20);
    }
    @Then("I test the Contact Us Section")
    public void contactUs(){
        WebElement contact = driver.findElement(By.className("contact-us-paragraph"));
        boolean checkContact = contact.isDisplayed();
        Assert.assertTrue(checkContact);
    }
}
