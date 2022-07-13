package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WearPage {

    private final String PAGE_URL = "https://homebrandofficial.ru/";

    private final SelenideElement CATALOG = $(By.xpath("//a[@data-tooltip-menu-id='349590657']"));
    private final SelenideElement WEAR = $(By.xpath("//div[@field='li_title__1607692272826']"));
    private final List<SelenideElement> CLOTHES_ON_PAGE = $$(By.xpath("//div[@class='js-store-prod-name js-product-name t-store__card__title t-name t-name_xs']"));
    private final SelenideElement BUY_BUTTON = $(By.cssSelector(".js-store-prod-popup-buy-btn-txt"));

    private final String TSHIRT_NAME = "ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)";

    public WearPage() {

    }

    public WearPage openPage(){
        open(this.PAGE_URL);
        return this;
    }

    public void clickOnCatalog(){
        CATALOG.shouldBe(Condition.visible).click();
    }

    public void clickOnWear(){
        WEAR.shouldBe(Condition.visible).click();
    }

    public void clickTshirt(){
        CLOTHES_ON_PAGE.stream().filter(x -> x.getText().equals(TSHIRT_NAME)).findAny().orElse(null).click();
    }

    public void clickBuy(){
        BUY_BUTTON.shouldBe(Condition.visible).click();
    }


}
