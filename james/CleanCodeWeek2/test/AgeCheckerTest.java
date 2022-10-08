import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgeCheckerTest {
    Date date = new Date();

    @Test
    void getInternationalAge() {
        date.year = "2022";
        date.month = "9";
        date.day = "30";
        AgeChecker ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.getInternationalAge(), 0);
    }

    @Test
    void isUnderAgeLimit() {
        LocalDate now = LocalDate.now();
        int ageLimit = 19;
        date.year = "2022";
        date.month = "10";
        date.day = "5";
        AgeChecker ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.isUnderAgeLimit(ageLimit), true);
        date.year = "2003";
        date.month = "10";
        date.day = "6";
        ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.isUnderAgeLimit(ageLimit), false);
        date.year = "2003";
        date.month = "10";
        date.day = "7";
        ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.isUnderAgeLimit(ageLimit), false);
        date.year = Integer.toString(now.getYear());
        date.month = Integer.toString(now.getMonthValue());
        date.day = Integer.toString(now.getDayOfMonth());
        ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.isUnderAgeLimit(ageLimit), true);
    }

    @Test
    void addZeroPrefix() {
        AgeChecker ageChecker = new AgeChecker();
        assertEquals(ageChecker.addZeroPrefix("1"), "01");
        assertEquals(ageChecker.addZeroPrefix("9"), "09");
        assertEquals(ageChecker.addZeroPrefix("11"), "11");
    }
}