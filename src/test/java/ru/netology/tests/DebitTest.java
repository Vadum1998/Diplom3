package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.pages.PageMain;
import static com.codeborne.selenide.Selenide.open;

public class DebitTest{


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
    @DisplayName("Тест загрузки раздела покупки")
    void shouldCheckLoading() {
        PageMain main = new PageMain();
        main.buyDebit();
    }

    @Test
    @DisplayName("Тест пустого номера карты")
    void shouldCheckTheEmptyNumber() {
        var invalidCardInformation = DataHelper.getEmptyCard();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест невалидного номера карты")
    void shouldCheckBigNumber() {
        var invalidCardInformation = DataHelper.getBigCard();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест карты 0000 0000 0000 0000")
    void shouldCheckTheZeroNumber() {
        var invalidCardInformation = DataHelper.getZeroCard();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест несуществующего номера")
    void shouldCheckTheInvalidNumber() {
        var invalidCardInformation = DataHelper.getInvalidCard();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.declined();
    }

    @Test
    @DisplayName("Тест символьного номера")
    void shouldCheckTheSymbolNumber() {
        var invalidCardInformation = DataHelper.getSymbolCard();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест текстового номера")
    void shouldCheckTheTextNumber() {
        var invalidCardInformation = DataHelper.getTextCard();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест короткого номера")
    void shouldCheckTheShortNumber() {
        var invalidCardInformation = DataHelper.getSmallCard();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест пустого месяца")
    void shouldCheckTheEmptyMonth() {
        var invalidCardInformation = DataHelper.getEmptyMonth();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест предыдущего месяца")
    void shouldCheckTheInvalidMonth() {
        var invalidCardInformation = DataHelper.getPreviousMonth();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.expiredDataMessage();
    }

    @Test
    @DisplayName("Тест 00 месяца")
    void shouldCheckTheZeroMonth() {
        var invalidCardInformation = DataHelper.getZeroMonth();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.declined();
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест 13 месяца")
    void shouldCheckTheImpossibleMonth() {
        var invalidCardInformation = DataHelper.getInvalidMonth();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест месяца из одной цифры")
    void shouldCheckTheOneNumberMonth() {
        var invalidCardInformation = DataHelper.getOneNumberMonth();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест текстового месяца")
    void shouldCheckTheTextMonth() {
        var invalidCardInformation = DataHelper.getTextMonth();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест символьного месяца")
    void shouldCheckTheSymbolMonth() {
        var invalidCardInformation = DataHelper.getSymbolMonth();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест прошлого года")
    void shouldCheckTheLastYear() {
        var invalidCardInformation = DataHelper.getInvalidYear();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.expiredDataMessage();
    }

    @Test
    @DisplayName("Тест года 00")
    void shouldCheckZeroYear() {
        var invalidCardInformation = DataHelper.getZeroYear();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.expiredDataMessage();
    }

    @Test
    @DisplayName("Тест пустого года")
    void shouldCheckEmptyYear() {
        var invalidCardInformation = DataHelper.getEmptyYear();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест текстового года")
    void shouldCheckTextYear() {
        var invalidCardInformation = DataHelper.getTextYear();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.invalidDataMessage();
    }

    @Test
    @DisplayName("Тест года из одной цифры")
    void shouldCheckOneNumberYear() {
        var invalidCardInformation = DataHelper.getOneNumberYear();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест символьного года")
    void shouldCheckSymbolYear() {
        var invalidCardInformation = DataHelper.getSymbolYear();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест символьного имени")
    void shouldCheckSymbolHolder() {
        var invalidCardInformation = DataHelper.getSymbolName();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест русского имени")
    void shouldCheckRussianHolder() {
        var invalidCardInformation = DataHelper.getRusName();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест цифрового имени")
    void shouldCheckNumberHolder() {
        var invalidCardInformation = DataHelper.getNumberName();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест фамилии")
    void shouldCheckSurnameHolder() {
        var invalidCardInformation = DataHelper.getLastName();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест пустого имени")
    void shouldCheckEmptyNameHolder() {
        var invalidCardInformation = DataHelper.getEmptyName();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldHolder();
    }

    @Test
    @DisplayName("Тест имени из одной буквы")
    void shouldCheckOneShortNameHolder() {
        var invalidCardInformation = DataHelper.getOneLetterName();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест длинного имени")
    void shouldCheckLongNameHolder() {
        var invalidCardInformation = DataHelper.getHugeName();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест пустого CVV")
    void shouldCheckEmptyCVV() {
        var invalidCardInformation = DataHelper.getEmptyCVV();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из одного числа")
    void shouldCheckOneNumberCVV() {
        var invalidCardInformation = DataHelper.getOneNumberCVV();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из двух чисел")
    void shouldCheckTwoNumberCVV() {
        var invalidCardInformation = DataHelper.getTwoNumberCVV();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV символами")
    void shouldCheckSymbolCVV() {
        var invalidCardInformation = DataHelper.getSymbolCVV();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест 00 CVV")
    void shouldCheckZeroNumberCVV() {
        var invalidCardInformation = DataHelper.getZeroCVV();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV тестом")
    void shouldCheckTextCVV() {
        var invalidCardInformation = DataHelper.getTextCVV();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из 4 цифр")
    void shouldCheckFourNumberCVV() {
        var invalidCardInformation = DataHelper.getLongCVV();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест пустой формы")
    void shouldSendAnEmptyForm() {
        var invalidCardInformation = DataHelper.getEmptyFields();
        var debitPage = new PageMain().buyDebit();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.emptyFieldMessage();
        debitPage.improperFormatMessage();
        debitPage.shouldValueFieldCVV();
        debitPage.shouldValueFieldYear();
        debitPage.shouldValueFieldMonth();
        debitPage.shouldValueFieldNumberCard();
        debitPage.shouldValueFieldHolder();
    }
}