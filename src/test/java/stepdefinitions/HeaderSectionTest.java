package stepdefinitions;

import io.cucumber.java.en.And;
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

public class HeaderSectionTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @When("I test website logo is display")
    public void websiteLogodisplay(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement websiteLogo = driver.findElement(By.className("website-logo"));
        boolean checkWebsiteLogo = websiteLogo.isDisplayed();
        Assert.assertTrue(checkWebsiteLogo);
    }
    @Then("I test Navbar elements")
    public void checkNavbaeEl(){
        List<WebElement> navEl = driver.findElements(By.cssSelector(".nav-menu-list >li"));
        Assert.assertEquals(navEl.size(),2);
    }
    @When("I Test the navigation to Home")
    public void homaPagecheck(){
        WebElement homeEl = driver.findElement(By.xpath("//a[text() ='Home']"));
        homeEl.click();
    }
    @And("I Test Popular pages through elements in header section")
    public void popularPagecheck(){
        WebElement popularEl = driver.findElement(By.xpath("//a[text() ='Popular']"));
        popularEl.click();
    }
    @Then("I Test the navigation to account page through elements in header section")
    public void navigateAccountPage(){
        WebElement accountEl = driver.findElement(By.className("avatar-button"));
        accountEl.click();
    }
}
