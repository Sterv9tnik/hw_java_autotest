import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindProductTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://homebrandofficial.ru/wear");
    }

    @Test
    public void FindProduct() throws InterruptedException {
        String productName = "ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)";
        String productCount = "1";
        String productPrice = "2 800";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement poisk = driver.findElement(By.xpath("//input[@class='t-store__filter__input js-store-filter-search']"));
        poisk.click();
        poisk.sendKeys(productName);

        driver.findElement(By.cssSelector(".js-store-filter-search-btn")).click();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".js-store-filters-prodsnumber")));

        String actualProductName = driver.findElement(By.xpath("//div[@class='js-store-prod-name js-product-name t-store__card__title t-name t-name_xs']")).getText();
        String actualProductCount = driver.findElement(By.cssSelector(".js-store-filters-prodsnumber")).getText();
        String actualProductPrice = driver.findElement(By.xpath("//div[@class='js-product-price js-store-prod-price-val t-store__card__price-value notranslate']")).getText();

        Assert.assertEquals(productName, actualProductName);
        Assert.assertEquals(productCount, actualProductCount);
        Assert.assertEquals(productPrice, actualProductPrice);

    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
