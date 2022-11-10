package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.pages.PageMain;
import static com.codeborne.selenide.Selenide.open;


public class CreditTest{


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
    @DisplayName("Тест Купить в кредит")
    void shouldCheckLoadingCredit() {
        PageMain main = new PageMain();
        main.buyCredit();
    }

    @Test
    @DisplayName("Тест пустого номера карты")
    void shouldCheckTheEmptyNumber() {
        var invalidCardInformation = DataHelper.getEmptyCard();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест невалидного номера карты")
    void shouldCheckTheHugeNumber() {
        var invalidCardInformation = DataHelper.getBigCard();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест с карты 0000 0000 0000 0000")
    void shouldCheckTheZeroNumber() {
        var invalidCardInformation = DataHelper.getZeroCard();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест несуществующего номера карты")
    void shouldCheckTheInvalidCard() {
        var invalidCardInformation = DataHelper.getInvalidCard();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.declined();
    }

    @Test
    @DisplayName("Тест символьного номера")
    void shouldCheckTheSymbolNumber() {
        var invalidCardInformation = DataHelper.getSymbolCard();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест текстового номера")
    void shouldCheckTheTextNumberCard() {
        var invalidCardInformation = DataHelper.getTextCard();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест короткого номера")
    void shouldCheckTheShortNumberCard() {
        var invalidCardInformation = DataHelper.getSmallCard();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест пустого месяца")
    void shouldCheckTheEmptyMonth() {
        var invalidCardInformation = DataHelper.getEmptyMonth();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест предыдущего месяца")
    void shouldCheckTheInvalidMonth() {
        var invalidCardInformation = DataHelper.getPreviousMonth();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldExpiredDataMessage();
    }

    @Test
    @DisplayName("Тест 00 месяца")
    void shouldCheckTheZeroMonth() {
        var invalidCardInformation = DataHelper.getZeroMonth();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.declined();
        creditPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест 13 месяца")
    void shouldCheckTheImpossibleMonth() {
        var invalidCardInformation = DataHelper.getInvalidMonth();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест месяца из одной цифры")
    void shouldCheckTheOneNumberMonth() {
        var invalidCardInformation = DataHelper.getOneNumberMonth();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест текстового месяца")
    void shouldCheckTheTextMonth() {
        var invalidCardInformation = DataHelper.getTextMonth();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест символьного месяца")
    void shouldCheckTheSymbolMonth() {
        var invalidCardInformation = DataHelper.getSymbolMonth();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест прошлого года")
    void shouldCheckLastYear() {
        var invalidCardInformation = DataHelper.getInvalidYear();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldExpiredDataMessage();
    }

    @Test
    @DisplayName("Тест 00 года")
    void shouldCheckZeroYear() {
        var invalidCardInformation = DataHelper.getZeroYear();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldExpiredDataMessage();
    }

    @Test
    @DisplayName("Тест пустого года")
    void shouldCheckEmptyYear() {
        var invalidCardInformation = DataHelper.getEmptyYear();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест текстового года")
    void shouldCheckTextYear() {
        var invalidCardInformation = DataHelper.getTextYear();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldInvalidDataMessage();
    }

    @Test
    @DisplayName("Тест года из одной цифрой")
    void shouldCheckOneNumberYear() {
        var invalidCardInformation = DataHelper.getOneNumberYear();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест символьного года")
    void shouldCheckSymbolYear() {
        var invalidCardInformation = DataHelper.getSymbolYear();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест символьного имени")
    void shouldCheckSymbolName() {
        var invalidCardInformation = DataHelper.getSymbolName();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест русского имени")
    void shouldCheckRussian() {
        var invalidCardInformation = DataHelper.getRusName();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест цифрового имени")
    void shouldCheckNumberName() {
        var invalidCardInformation = DataHelper.getNumberName();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест фамилии")
    void shouldCheckSurname() {
        var invalidCardInformation = DataHelper.getLastName();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест пустого имени")
    void shouldCheckEmptyName() {
        var invalidCardInformation = DataHelper.getEmptyName();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldHolder();
    }

    @Test
    @DisplayName("Тест имени из одной буквы")
    void shouldCheckOneShortNameHolder() {
        var invalidCardInformation = DataHelper.getOneLetterName();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест длинного имени")
    void shouldCheckLongNameHolder() {
        var invalidCardInformation = DataHelper.getHugeName();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест пустого CVV")
    void shouldCheckEmptyCVV() {
        var invalidCardInformation = DataHelper.getEmptyCVV();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из одного числа")
    void shouldCheckOneNumberCVV() {
        var invalidCardInformation = DataHelper.getOneNumberCVV();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из двух чисел")
    void shouldCheckTwoNumberCVV() {
        var invalidCardInformation = DataHelper.getTwoNumberCVV();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест символьного CVV")
    void shouldCheckSymbolCVV() {
        var invalidCardInformation = DataHelper.getSymbolCVV();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест 00 CVV")
    void shouldCheckZeroCVV() {
        var invalidCardInformation = DataHelper.getZeroCVV();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест текстового CVV")
    void shouldCheckTextCVV() {
        var invalidCardInformation = DataHelper.getTextCVV();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из 4 цифр")
    void shouldCheckFourNumberCVV() {
        var invalidCardInformation = DataHelper.getLongCVV();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест отправка пустой формы")
    void shouldSendAnEmptyForm() {
        var invalidCardInformation = DataHelper.getEmptyFields();
        var creditPage = new PageMain().buyCredit();
        creditPage.creditCardInformation(invalidCardInformation);
        creditPage.shouldEmptyFieldMessage();
        creditPage.shouldImproperFormatMessage();
        creditPage.shouldValueFieldCVV();
        creditPage.shouldValueFieldYear();
        creditPage.shouldValueFieldMonth();
        creditPage.shouldValueFieldNumberCard();
        creditPage.shouldValueFieldHolder();
    }
}