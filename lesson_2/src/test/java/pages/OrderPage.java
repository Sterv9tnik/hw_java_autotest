package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrderPage  {

    private final SelenideElement FIO_INPUT = $(By.xpath("(//input[@placeholder='Ваше имя'])[2]"));
    private final SelenideElement PHONE_INPUT = $(By.xpath("(//input[@class='t-input t-input-phonemask'])[2]"));
    private final SelenideElement REGION_INPUT= $(By.xpath("//input[@placeholder='Название региона']"));
    private final SelenideElement ADRESS_INPUT= $(By.xpath("//textarea[@name='Адрес для доставки']"));
    private final SelenideElement FIO_DELIVERY_INPUT = $(By.xpath("//input[@name='tildadelivery-userinitials']"));
    private final SelenideElement HOME_STREET_INPUT = $(By.xpath("//input[@name='tildadelivery-street']"));
    private final SelenideElement HOME_NUMBER_INPUT = $(By.xpath("//input[@name='tildadelivery-house']"));
    private final SelenideElement HOME_FLAT_INPUT = $(By.xpath("//input[@name='tildadelivery-aptoffice']"));
    private final SelenideElement OVER_BUTTON_TELEPHONE_ERROR = $(By.xpath("(//p[@class='t-form__errorbox-item js-rule-error js-rule-error-phone'])[3]"));
    private final SelenideElement UNDER_FIELD_TELEPHONE_ERROR = $(By.xpath("(//div[@class='t-input-error'])[4]"));

    private String fio;
    private String phoneNumber;
    private String region;
    private String street;
    private String homeNumber;
    private String homeFlat;
    private String town;

    public OrderPage(String fio, String phoneNumber, String region, String street, String homeNumber, String homeFlat, String town) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.street = street;
        this.homeNumber = homeNumber;
        this.homeFlat = homeFlat;
        this.town = town;
    }

    public void sendData(){
        FIO_INPUT.sendKeys(fio);
        PHONE_INPUT.sendKeys(phoneNumber);
        REGION_INPUT.sendKeys(region);
        ADRESS_INPUT.sendKeys(String.format("%s, %s, %s", street, homeNumber, homeFlat));
        FIO_DELIVERY_INPUT.sendKeys(fio);
        HOME_STREET_INPUT.sendKeys(street);
        HOME_NUMBER_INPUT.sendKeys(homeNumber);
        HOME_FLAT_INPUT.sendKeys(homeFlat);
    }

    public void clickCheckout(){
        $(By.xpath("(//button[@class='t-submit'])[2]")).click();
    }

    public String getOverButtonTelephoneError(){
        return OVER_BUTTON_TELEPHONE_ERROR.getText();
    }

    public String getUnderFieldTelephoneError(){
        return UNDER_FIELD_TELEPHONE_ERROR.getText();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getHomeFlat() {
        return homeFlat;
    }

    public void setHomeFlat(String homeFlat) {
        this.homeFlat = homeFlat;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
