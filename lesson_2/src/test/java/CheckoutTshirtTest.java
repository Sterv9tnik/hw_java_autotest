import builder.OrderPageBuilder;
import org.junit.Test;
import pages.OrderPage;
import pages.WearPage;

import static org.junit.Assert.assertEquals;

public class CheckoutTshirtTest {

    private WearPage wearPage = new WearPage();
    private final OrderPage orderPage = new OrderPageBuilder()
            .setFio("Biba Bubov Bubovich")
            .setPhoneNumber("0000000000")
            .setRegion("russia")
            .setTown("Moscow")
            .setStreet("Bubovniyu proezd")
            .setHomeNumber("666")
            .setHomeFlat("6")
            .build();

    @Test
    public void checkBascket(){

        String correctNumberError = "Укажите, пожалуйста, корректный номер телефона";

        wearPage.openPage();
        wearPage.clickOnCatalog();
        wearPage.clickOnWear();
        wearPage.clickTshirt();
        wearPage.clickBuy();

        orderPage.sendData();
        orderPage.clickCheckout();

        assertEquals(orderPage.getUnderFieldTelephoneError(), correctNumberError);
        assertEquals(orderPage.getOverButtonTelephoneError(), correctNumberError);

    }
}
