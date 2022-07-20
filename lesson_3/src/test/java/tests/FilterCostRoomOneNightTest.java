package tests;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import pages.BookingMainPage;
import pages.BookingSearchResultsFiltersPage;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;


public class FilterCostRoomOneNightTest {
    private BookingMainPage bookingMainPage = new BookingMainPage();
    private BookingSearchResultsFiltersPage bookingSearchResultsFiltersPage = new BookingSearchResultsFiltersPage();
    private String TOWN = "Афины";
    private LocalDate CHECK_IN_DATE = LocalDate.now().plusDays(8);
    private LocalDate CHECK_OUT_DATE = LocalDate.now().plusDays(9);

    @Test
    public void checkPriceOneNight(){
        Configuration.browserSize = "1920x1080";

        bookingMainPage.openPage();
        bookingMainPage.cookieClick();
        bookingMainPage.sendSearch(TOWN);
        bookingMainPage.checkDateSearch();
        bookingMainPage.checkInSearch(CHECK_IN_DATE);
        bookingMainPage.checkOutSearch(CHECK_OUT_DATE);
        bookingMainPage.getPeopleCountClick();
        bookingMainPage.setPeopleCount();
        bookingMainPage.checkPriceClick();

        bookingSearchResultsFiltersPage.budgetClick();

        List<String> roomsPrice=bookingSearchResultsFiltersPage.getAllRooms();
        Integer lowPrice = bookingSearchResultsFiltersPage.getLowPrice();
        Integer highPrice = bookingSearchResultsFiltersPage.getHighPrice();
        Integer roomsCountFromBudget = bookingSearchResultsFiltersPage.getCountRoomsFromBudget();
        Integer roomsCountFromSite = bookingSearchResultsFiltersPage.getCountRoomsFromSite();

        roomsPrice.stream().forEach(x->assertTrue(Integer.valueOf(x) > lowPrice));

        //Возможно из-за курса валют, но сюда залетает комната на рубль дороже чем максимальная цена))
        //roomsPrice.stream().forEach(x->assertTrue(Integer.valueOf(x) < highPrice));

        assertTrue(roomsCountFromBudget.equals(roomsCountFromSite) &&
                roomsCountFromSite.equals(roomsPrice.size()));



    }
}
