package builder;

import pages.OrderPage;

public class OrderPageBuilder {

    private String fio;
    private String phoneNumber;
    private String region;
    private String adress;
    private String homeAdress;
    private String homeFlat;
    private String town;

    public OrderPageBuilder(){
    }

    public OrderPageBuilder setFio(String fio) {
        this.fio = fio;
        return this;
    }

    public OrderPageBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public OrderPageBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public OrderPageBuilder setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public OrderPageBuilder setTown(String town) {
        this.town = town;
        return this;
    }

    public OrderPageBuilder setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
        return this;
    }

    public OrderPageBuilder setHomeFlat(String homeFlat) {
        this.homeFlat = homeFlat;
        return this;
    }

    public OrderPage build(){
        return new OrderPage(fio, phoneNumber, region, adress, town, homeAdress, homeFlat);
    }
}
