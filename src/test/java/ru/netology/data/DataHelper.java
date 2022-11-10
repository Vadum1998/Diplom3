package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    public static String approvedStatus = "4444 4444 4444 4441";
    public static String declinedStatus = "4444 4444 4444 4442";

    public static Faker faker = new Faker(new Locale("en"));
    public static Faker fakerRUS = new Faker(new Locale("ru"));


    public DataHelper() {
    }

    @Value
    public static class CardInformation {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    public static String getZeroNumber() {
        return ("0000 0000 0000 0000");
    }

    public static String getInvalidNumber() {
        return "0000 0000 0000 0001";
    }

    public static String getBigNumber() {
        return ("5555 6666 7777 8888 9999");
    }

    public static String getSymbolNumber() {
        return ("!@#$ $#@! !@#$ %$#@");
    }

    public static String getSmallNumber() {
        return ("5555 6666");
    }

    public static String getTextNumber() {
        return ("qqqq wwww eeee rrrr");
    }

    public static String getMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getPrevMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM")); }

    public static String getMonthZero() {
        return "00";
    }

    public static String get13Month() {
        return "13";
    }

    public static String getShortMonth() {
        return "5";
    }

    public static String getMonthText() {
        return "ty";
    }

    private static String getMonthSymbol() {
        return "%$";
    }

    public static String getYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String getLastYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getYearZero() {
        return ("00");
    }

    public static String getYearText() {
        return "ab";
    }

    private static String getYearSymbol() {
        return "@!";
    }

    private static String getShortYear() {
        return "5";
    }

    public static String getName() {
        return faker.name().fullName();
    }

    public static String getNameRus() {
        return fakerRUS.name().lastName() + " " + fakerRUS.name().firstName();
    }

    public static String getSurname() {
        return faker.name().lastName();
    }

    public static String getNameSymbol() {
        return "!@##@@%%^^&^ %$#$@@@#!";
    }

    public static String getShortName() {
        return "q";
    }

    public static String getBigName() {
        return "gjgkjdsglkahgalkhgfalskfghsalkghas";
    }

    public static String getNameNumber() {
        return "3453553235 7463536363";
    }

    public static String getCVV() {
        return faker.numerify("###");
    }

    public static String getCVVSymbol() {
        return "@%!";
    }

    public static String getCVVZero() {
        return "000";
    }

    public static String getShortCVV() {
        return faker.numerify("##");
    }

    public static String getOneCVV() {
        return faker.numerify("#");
    }

    private static String getCVVText() {
        return "mnb";
    }

    private static String getCVVLong() {
        return "1234";
    }


    public static String getEmptyField() {
        return " ";
    }

    public static CardInformation getAPPROVED() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getDECLINED() {
        return new CardInformation(declinedStatus, getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getEmptyCard() {
        return new CardInformation(getEmptyField(), getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getBigCard() {
        return new CardInformation(getBigNumber(), getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getZeroCard() {
        return new CardInformation(getZeroNumber(), getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getInvalidCard() {
        return new CardInformation(getInvalidNumber(), getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getSymbolCard() {
        return new CardInformation(getSymbolNumber(), getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getTextCard() {
        return new CardInformation(getTextNumber(), getMonth(), getYear(), getName(), getCVV());
    }
    public static CardInformation getSmallCard() {
        return new CardInformation(getSmallNumber(), getMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getEmptyMonth() {
        return new CardInformation(approvedStatus, getEmptyField(), getYear(), getName(), getCVV());
    }

    public static CardInformation getPreviousMonth() {
        return new CardInformation(approvedStatus, getPrevMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getZeroMonth() {
        return new CardInformation(approvedStatus, getMonthZero(), getYear(), getName(), getCVV());
    }

    public static CardInformation getInvalidMonth() {
        return new CardInformation(approvedStatus, get13Month(), getYear(), getName(), getCVV());
    }

    public static CardInformation getOneNumberMonth() {
        return new CardInformation(approvedStatus, getShortMonth(), getYear(), getName(), getCVV());
    }

    public static CardInformation getTextMonth() {
        return new CardInformation(approvedStatus, getMonthText(), getYear(), getName(), getCVV());
    }

    public static CardInformation getSymbolMonth() {
        return new CardInformation(approvedStatus, getMonthSymbol(), getYear(), getName(), getCVV());
    }

    public static CardInformation getInvalidYear() {
        return new CardInformation(approvedStatus, getMonth(), getLastYear(), getName(), getCVV());
    }

    public static CardInformation getZeroYear() {
        return new CardInformation(approvedStatus, getMonth(), getYearZero(), getName(), getCVV());
    }

    public static CardInformation getEmptyYear() {
        return new CardInformation(approvedStatus, getMonth(), getEmptyField(), getName(), getCVV());
    }

    public static CardInformation getTextYear() {
        return new CardInformation(approvedStatus, getMonth(), getYearText(), getName(), getCVV());
    }

    public static CardInformation getOneNumberYear() {
        return new CardInformation(approvedStatus, getMonth(), getShortYear(), getName(), getCVV());
    }
    public static CardInformation getSymbolYear() {
        return new CardInformation(approvedStatus, getMonth(), getYearSymbol(), getName(), getCVV());
    }

    public static CardInformation getSymbolName() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getNameSymbol(), getCVV());
    }

    public static CardInformation getRusName() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getNameRus(), getCVV());
    }

    public static CardInformation getNumberName() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getNameNumber(), getCVV());
    }

    public static CardInformation getLastName() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getSurname(), getCVV());
    }

    public static CardInformation getEmptyName() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getEmptyField(), getCVV());
    }

    public static CardInformation getOneLetterName() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getShortName(), getCVV());
    }

    public static CardInformation getHugeName() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getBigName(), getCVV());
    }

    public static CardInformation getEmptyCVV() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getEmptyField());
    }

    public static CardInformation getOneNumberCVV() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getOneCVV());
    }

    public static CardInformation getTwoNumberCVV() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getShortCVV());
    }

    public static CardInformation getSymbolCVV() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getCVVSymbol());
    }

    public static CardInformation getZeroCVV() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getCVVZero());
    }

    public static CardInformation getTextCVV() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getCVVText());
    }

    public static CardInformation getLongCVV() {
        return new CardInformation(approvedStatus, getMonth(), getYear(), getName(), getCVVLong());
    }

    public static CardInformation getEmptyFields() {
        return new CardInformation(getEmptyField(), getEmptyField(), getEmptyField(), getEmptyField(), getEmptyField());
    }
}