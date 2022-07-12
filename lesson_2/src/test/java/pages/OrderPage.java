package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrderPage  {

    private String fio;
    private String phoneNumber;
    private String region;
    private String adress;
    private String homeAdress;
    private String homeFlat;
    private String town;

    public OrderPage(String fio, String phoneNumber, String region, String adress, String homeAdress, String homeFlat, String town) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.adress = adress;
        this.homeAdress = homeAdress;
        this.homeFlat = homeFlat;
        this.town = town;
    }

    public void sendData(){
        $(By.xpath("(//input[@placeholder='Ваше имя'])[2]")).sendKeys(fio);
        $(By.xpath("(//input[@class='t-input t-input-phonemask'])[2]")).sendKeys(phoneNumber);
        $(By.xpath("//input[@placeholder='Название региона']")).sendKeys(region);
        $(By.xpath("//textarea[@name='Адрес для доставки']")).sendKeys(String.format("%s, %s, %s", adress, homeAdress, homeFlat));
        $(By.xpath("//input[@name='tildadelivery-userinitials']")).sendKeys(fio);
        $(By.xpath("//input[@name='tildadelivery-street']")).sendKeys(String.format("%s, %s, %s", adress, homeAdress, homeFlat));
        $(By.xpath("//input[@name='tildadelivery-house']")).sendKeys(homeAdress);
        $(By.xpath("//input[@name='tildadelivery-aptoffice']")).sendKeys(homeFlat);
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

    public String getHomeFlat() {
        return homeFlat;
    }

    public void setHomeFlat(String homeFlat) {
        this.homeFlat = homeFlat;
    }
}
