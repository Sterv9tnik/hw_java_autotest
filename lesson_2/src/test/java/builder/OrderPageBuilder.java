package builder;

import pages.OrderPage;

public class OrderPageBuilder {

    private String fio;
    private String phoneNumber;
    private String region;
    private String street;
    private String homeNumber;
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

    public OrderPageBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public OrderPageBuilder setTown(String town) {
        this.town = town;
        return this;
    }

    public OrderPageBuilder setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
        return this;
    }

    public OrderPageBuilder setHomeFlat(String homeFlat) {
        this.homeFlat = homeFlat;
        return this;
    }

    public OrderPage build(){
        return new OrderPage(fio, phoneNumber, region, street, town, homeNumber, homeFlat);
    }
}
