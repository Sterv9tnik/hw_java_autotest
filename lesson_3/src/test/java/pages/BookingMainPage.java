package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BookingMainPage {

    private final String PAGE_URL = "https://www.booking.com/";


    private final SelenideElement SEARCH = $(By.cssSelector(".c-autocomplete__input"));
    private final SelenideElement CHECK_DATE = $(By.xpath("//div[@data-mode='checkin']"));
    private final List<SelenideElement> PEOPLES = $$(By.cssSelector(".bui-stepper__display"));
    private final List<SelenideElement> BUTTONS = $$(By.xpath("//button[@data-bui-ref='input-stepper-subtract-button']"));
    private final SelenideElement PEOPLE_COUNT = $(By.cssSelector(".xp__input"));
    private final SelenideElement CHECK_PRICE = $(By.cssSelector(".sb-searchbox__button"));
    private final SelenideElement COOKIE = $(By.xpath("//button[@id='onetrust-accept-btn-handler']"));

    public BookingMainPage() {
    }

    public void openPage() {
        open(this.PAGE_URL);
    }

    public void cookieClick(){
        COOKIE.click();
    }

    public void sendSearch(String town){
        SEARCH.shouldBe(Condition.visible).sendKeys(town);

    }
    public void checkDateSearch(){
        CHECK_DATE.shouldBe(Condition.visible).click();
    }

    public void checkInSearch(LocalDate CheckInDate){
        $(By.xpath(String.format("//td[@data-date='%s']", CheckInDate))).shouldBe(Condition.visible).click();
    }

    public void checkOutSearch(LocalDate CheckOutDate){
        $(By.xpath(String.format("//td[@data-date='%s']", CheckOutDate))).shouldBe(Condition.visible).click();
    }

    public void getPeopleCountClick(){
        PEOPLE_COUNT.shouldBe(Condition.visible).click();
    }

    public void setPeopleCount(){
        for (int i = 0;i < PEOPLES.size(); i++){
            int clickCount = Integer.valueOf(PEOPLES.get(i).getText());
            for (int j = 0; clickCount - j > 1; j++){
                BUTTONS.get(i).click();
            }
        }

    }

    public void checkPriceClick(){
        CHECK_PRICE.shouldBe(Condition.visible).click();
    }
}
