package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class PageMain {
    private SelenideElement buttonBuy = $$(".button__text").find(exactText("Купить"));
    private SelenideElement buttonCreditBuy = $$(".button__text").find(exactText("Купить в кредит"));
    private SelenideElement pay = $$(".heading").find(exactText("Путешествие дня"));

    public PageMain() {
        pay.shouldBe(Condition.visible);
    }

    public PageDebit buyDebit() {
        buttonBuy.click();
        return new PageDebit();
    }

    public PageCredit buyCredit() {
        buttonCreditBuy.click();
        return new PageCredit();
    }
}