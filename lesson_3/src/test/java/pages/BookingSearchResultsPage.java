package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

public class BookingSearchResultsPage {

    private final SelenideElement TOWN = $(By.cssSelector(".ce45093752"));
    private final SelenideElement DATE_IN = $(By.xpath("//button[@data-testid='date-display-field-start']"));
    private final SelenideElement DATE_OUT = $(By.xpath("//button[@data-testid='date-display-field-end']"));
    private final SelenideElement PEOPLES = $(By.xpath("//button[@data-testid='occupancy-config']"));
    private final SelenideElement COUNT_HOTELS = $(By.xpath("//h1"));
    private final SelenideElement ADULTS = $(By.xpath("(//span[@class='e615eb5e43'])[1]"));
    private final SelenideElement CHILDS =$(By.xpath("(//span[@class='e615eb5e43'])[2]"));
    private final SelenideElement ROOMS = $(By.xpath("(//span[@class='e615eb5e43'])[3]"));

    public String getTown(){
        return TOWN.getValue();
    }

    public String getDateIn(){
        String date_in = DATE_IN.getText().split(", ")[1];
        DATE_IN.click();
        date_in = $(By.xpath(String.format("//span[@aria-label='%s']", date_in))).shouldBe(Condition.visible).getAttribute("data-date");
        DATE_IN.click();
        return date_in;
    }

    public String getDateOut(){
        String date_out = DATE_OUT.getText().split(", ")[1];
        DATE_OUT.click();
        date_out = $(By.xpath(String.format("//span[@aria-label='%s']", date_out))).shouldBe(Condition.visible).getAttribute("data-date");
        DATE_OUT.click();
        return date_out;
    }

    public int getAdult(){
        PEOPLES.click();
        return Integer.valueOf(ADULTS.getText());
    }

    public int getChild(){
        return Integer.valueOf(CHILDS.getText());
    }

    public int getRoom(){
        return Integer.valueOf(ROOMS.getText());
    }

    public int getCountRooms(){
        return Integer.valueOf(COUNT_HOTELS.getText().replaceAll("[^0-9]",""));
    }
}
