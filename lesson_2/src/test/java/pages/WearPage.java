package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class WearPage {

    public String page;

    public WearPage(String page) {
        this.page = page;
    }

    public WearPage openPage(){
        open(this.page);
        return this;
    }

    public void clickOnElementXpath(By by){
        $(by).shouldBe(Condition.visible);
        $(by).click();
    }
}
