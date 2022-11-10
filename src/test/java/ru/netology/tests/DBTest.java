package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DBHelper;
import ru.netology.data.DataHelper;
import ru.netology.pages.PageMain;
import ru.netology.pages.PageCredit;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class DBTest {


    @BeforeEach
    void openForTests() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Тест APPROVED карты")
    void shouldCheckAPPROVEDCard() {
        var validCardInformation = DataHelper.getAPPROVED();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(validCardInformation);
        debitPage.approved();
        assertEquals("APPROVED", new DBHelper().getPaymentStatus());
        assertEquals(45000, new DBHelper().getPaymentAmount());
        assertNull(new DBHelper().getCreditId());
    }

    @Test
    @DisplayName("Тест DECLINED карты")
    void shouldCheckDECLINEDCard() {
        var invalidCardInformation = DataHelper.getDECLINED();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        assertEquals("DECLINED", new  DBHelper().getPaymentStatus());
        assertNull(new  DBHelper().getCreditId());
        debitPage.declined();
    }

    @Test
    @DisplayName("Тест покупки в кредит картой APPROVED")
    void shouldCheckApprovedCard() {
        var validCardInformation = DataHelper.getAPPROVED();
        var paymentPage = new PageMain();
        paymentPage.buyCredit();
        var creditPage = new PageCredit();
        creditPage.creditCardInformation(validCardInformation);
        creditPage.approved();
        assertEquals("APPROVED", new DBHelper().getCreditRequestStatus());
        assertNull(new DBHelper().getCreditId());
    }

    @Test
    @DisplayName("Тест покупки в кредит картой DECLINED")
    void shouldCheckDeclinedCard() {
        var invalidCardInformation = DataHelper.getDECLINED();
        var paymentPage = new PageMain();
        paymentPage.buyCredit();
        var creditPage = new PageCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        assertEquals("DECLINED", new DBHelper().getCreditRequestStatus());
        assertNull(new DBHelper().getCreditId());
        creditPage.declined();
    }
}