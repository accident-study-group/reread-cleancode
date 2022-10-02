import org.junit.jupiter.api.Test;

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
        int ageLimit = 19;
        date.year = "2022";
        date.month = "9";
        date.day = "30";
        AgeChecker ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.isUnderAgeLimit(ageLimit), true);
        date.year = "2003";
        date.month = "9";
        date.day = "30";
        ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.isUnderAgeLimit(ageLimit), false);
        date.year = "2003";
        date.month = "10";
        date.day = "1";
        ageChecker = new AgeChecker(date);
        assertEquals(ageChecker.isUnderAgeLimit(ageLimit), false);
        date.year = "2003";
        date.month = "10";
        date.day = "2";
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