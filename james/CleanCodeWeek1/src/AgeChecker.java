import java.time.LocalDate;

public class AgeChecker {
    private static final int YEAR_ERROR_CODE = -1;
    private static final int DATE_ERROR_CODE = -2;
    private static final String NEGATIVE_ERROR = "양수를 입력해주세요.";
    private static final String YEAR_ERROR_MESSAGE = "출생 연도을 기준일보다 이전으로 입력해주세요.";
    private static final String DATE_ERROR_MESSAGE = "출생일을 기준일보다 이전으로 입력해주세요.";
    private LocalDate now = LocalDate.now();
    private Date userBirthday;
    private int currentYear;
    private int currentDate;
    private int userYear;
    private int userDate;

    AgeChecker() {
    }

    AgeChecker(Date date) {
        userBirthday = date;
    }

    int getInternationalAge() {
        initCurrentYear();
        initCurrentDate();
        initUserYear();
        initUserDate();

        if (currentYear - userYear > 0) {
            if (userDate - currentDate > 0) {
                return currentYear - userYear - 1;
            } else {
                return currentYear - userYear;
            }
        } else if (currentYear - userYear < 0) {
            System.out.println(YEAR_ERROR_MESSAGE);
            return YEAR_ERROR_CODE;
        } else {
            if (userDate - currentDate > 0) {
                System.out.println(DATE_ERROR_MESSAGE);
                return DATE_ERROR_CODE;
            } else {
                return 0;
            }
        }
    }

    void setNegativeException(int num) {
        try {
            if (isNegativeNumber(num)) {
                throw new negativeNumberException(NEGATIVE_ERROR);
            }
        } catch (negativeNumberException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    void initCurrentYear() {
        currentYear = getCurrentYear();
    }

    void initCurrentDate() {
        currentDate = getCurrentDate();
    }

    void initUserYear() {
        userYear = getUserYear();
    }

    void initUserDate() {
        userDate = getUserDate();
    }

    int getCurrentYear() {
        int currentYear = now.getYear();
        if (isNegativeNumber(currentYear)) {
            setNegativeException(currentYear);
        }
        return currentYear;
    }

    int getCurrentMonth() {
        int currentMonth = now.getMonthValue();
        if (isNegativeNumber(currentMonth)) {
            setNegativeException(currentMonth);
        }
        return currentMonth;
    }

    int getCurrentDay() {
        return now.getDayOfMonth();
    }

    int getCurrentDate() {
        int currentDate = Integer.parseInt(addZeroPrefix(Integer.toString(getCurrentMonth())) + addZeroPrefix(Integer.toString(getCurrentDay())));
        setNegativeException(currentDate);
        return currentDate;
    }

    int getUserYear() {
        int userYear = Integer.parseInt(userBirthday.year);
        setNegativeException(userYear);
        return userYear;
    }

    int getUserMonth() {
        int userMonth = Integer.parseInt(userBirthday.month);
        setNegativeException(userMonth);
        return userMonth;
    }

    int getUserDay() {
        int userDay = Integer.parseInt(userBirthday.day);
        setNegativeException(userDay);
        return userDay;
    }

    int getUserDate() {
        int userDate = Integer.parseInt(addZeroPrefix(Integer.toString(getUserMonth())) + addZeroPrefix(Integer.toString(getUserDay())));
        return userDate;
    }

    boolean isUnderAgeLimit(int ageLimit) {
        if ((getInternationalAge() - ageLimit) >= 0) {
            return false;
        } else {
            return true;
        }
    }

    String addZeroPrefix(String input) {
        if (Integer.parseInt(input) < 10) {
            input = "0" + input;
        }
        return input;
    }

    boolean isNegativeNumber(int num) {
        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }
}
