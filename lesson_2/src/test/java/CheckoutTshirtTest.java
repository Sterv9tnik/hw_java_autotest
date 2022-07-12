import builder.OrderPageBuilder;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.OrderPage;
import pages.WearPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class CheckoutTshirtTest {

    private WearPage wearPage = new WearPage("https://homebrandofficial.ru/");

    @Test
    public void checkBascket(){

        String correctNumberError = "Укажите, пожалуйста, корректный номер телефона";

        wearPage.openPage();

        wearPage.clickOnElementXpath(By.xpath("//a[@data-tooltip-menu-id='349590657']"));
        wearPage.clickOnElementXpath(By.xpath("//div[@field='li_title__1607692272826']"));
        List<SelenideElement> wears = $$(By.xpath("//div[@class='js-store-prod-name js-product-name t-store__card__title t-name t-name_xs']"));
        wears.stream().filter(x -> x.getText().equals("ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)")).findAny().orElse(null).click();

        wearPage.clickOnElementXpath(By.cssSelector(".js-store-prod-popup-buy-btn-txt"));

        OrderPage orderPage = new OrderPageBuilder()
                .setFio("Biba Bubov Bubovich")
                .setPhoneNumber("0000000000")
                .setRegion("russia")
                .setTown("Moscow")
                .setAdress("Bubovniyu proezd")
                .setHomeAdress("666")
                .setHomeFlat("6")
                .build();

        orderPage.sendData();
        wearPage.clickOnElementXpath(By.xpath("(//button[@class='t-submit'])[2]"));

        assertEquals($(By.xpath("(//p[@class='t-form__errorbox-item js-rule-error js-rule-error-phone'])[3]")).getText(), correctNumberError);
        assertEquals($(By.xpath("(//div[@class='t-input-error'])[4]")).getText(), correctNumberError);

    }
}
