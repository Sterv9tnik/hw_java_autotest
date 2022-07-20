package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class BookingSearchResultsFiltersPage {

    private final SelenideElement LOW_BUDGET = $(By.xpath("//div[@data-filters-item='pri:pri=1']"));
    private final SelenideElement COUNT_HOTELS = $(By.xpath("//h1"));
    private final SelenideElement next_page = $(By.xpath("//button[@aria-label='Следующая страница']"));
    private final SelenideElement DOWNLOAD_ICON = $(By.cssSelector(".bed09ccad2.cf809624a5"));

    public void budgetClick(){
        LOW_BUDGET.shouldBe(Condition.visible).click();
    }

    public List<String> getDataFromBudget(){
        List<String> text = List.of(LOW_BUDGET.getText().split("[^0-9 ]"));
        text = text.stream().filter(x -> x.matches("\\s*[0-9]+\\s*[0-9]*\\s*")).map(x->x.replaceAll(" ","")).collect(Collectors.toList());
        return text;
    }

    public Integer getCountRoomsFromSite(){
        return Integer.valueOf(COUNT_HOTELS.getText().replaceAll("[^0-9]",""));
    }

    public Integer getLowPrice(){
        return Integer.valueOf(getDataFromBudget().get(0));
    }

    public Integer getHighPrice(){
        return Integer.valueOf(getDataFromBudget().get(1));
    }

    public Integer getCountRoomsFromBudget(){
        return Integer.valueOf(getDataFromBudget().get(2));
    }

    public List<String> getAllRooms(){


        List<String> rooms_cost =  new ArrayList<>();
        List<SelenideElement> ROOMS = $$(By.cssSelector(".fcab3ed991.bd73d13072"));
        DOWNLOAD_ICON.shouldNotBe(Condition.visible);
        if (next_page.exists()) {
            rooms_cost.addAll(ROOMS.stream().map(x->x.getText().replaceAll("[^0-9]","")).toList());
            while (next_page.isEnabled()) {
                next_page.click();
                DOWNLOAD_ICON.shouldNotBe(Condition.visible);
                rooms_cost.addAll(ROOMS.stream().map(x->x.getText().replaceAll("[^0-9]","")).toList());
            }
        }
        else{
            rooms_cost.addAll(ROOMS.stream().map(x -> x.getText().replaceAll("[^0-9]","")).toList());
        }
        return rooms_cost;
    }

}
