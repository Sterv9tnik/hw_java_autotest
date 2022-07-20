package tests;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import pages.BookingMainPage;
import pages.BookingSearchResultsPage;


import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class SearchTest {
    private BookingMainPage bookingMainPage = new BookingMainPage();
    private BookingSearchResultsPage bookingSearchResultsPage = new BookingSearchResultsPage();
    private String TOWN = "Париж";
    private LocalDate CHECK_IN_DATE = LocalDate.now().plusDays(1);
    private LocalDate CHECK_OUT_DATE = LocalDate.now().plusDays(2);
    @Test
    public void checkInfo(){

        bookingMainPage.openPage();
        bookingMainPage.cookieClick();
        bookingMainPage.sendSearch(TOWN);
        bookingMainPage.checkDateSearch();
        bookingMainPage.checkInSearch(CHECK_IN_DATE);
        bookingMainPage.checkOutSearch(CHECK_OUT_DATE);
        bookingMainPage.getPeopleCountClick();
        bookingMainPage.setPeopleCount();
        bookingMainPage.checkPriceClick();

        assertEquals(TOWN, bookingSearchResultsPage.getTown());
        assertEquals(CHECK_IN_DATE.toString(), bookingSearchResultsPage.getDateIn());
        assertEquals(CHECK_OUT_DATE.toString(), bookingSearchResultsPage.getDateOut());
        assertEquals(1, bookingSearchResultsPage.getAdult());
        assertEquals(0, bookingSearchResultsPage.getChild());
        assertEquals(1, bookingSearchResultsPage.getRoom());
        assert(bookingSearchResultsPage.getCountRooms() > 0);

    }


}
