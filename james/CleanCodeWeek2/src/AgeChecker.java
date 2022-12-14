import java.time.LocalDate;

public class AgeChecker {
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
        setInitData();
    }

    private void setInitData() {
        initCurrentYear();
        initCurrentDate();
        initUserYear();
        initUserDate();
    }

    boolean isUnderAgeLimit(int ageLimit) {
        if ((getInternationalAge() - ageLimit) >= 0) {
            return false;
        } else {
            return true;
        }
    }

    int getInternationalAge() {
        return calculateInternationalAge();
    }

    private int calculateInternationalAge() {
        if (isCurrentYearBiggerThanUserYear()) {
            if (userDate - currentDate > 0) {
                return currentYear - userYear - 1;
            } else {
                return currentYear - userYear;
            }
        }
        if (isUserYearBiggerThanCurrentYear()) {
            System.out.println(Constants.YEAR_ERROR_MESSAGE);
            return Constants.YEAR_ERROR_CODE;
        }
        if (isUserDateBiggerThanCurrentDate()) {
            System.out.println(Constants.DATE_ERROR_MESSAGE);
            return Constants.DATE_ERROR_CODE;
        } else {
            return 0;
        }
    }

    private boolean isCurrentYearBiggerThanUserYear() {
        return userYear < currentYear;
    }

    private boolean isUserYearBiggerThanCurrentYear() {
        return currentYear < userYear;
    }

    private boolean isUserDateBiggerThanCurrentDate() {
        return currentDate < userDate;
    }

    private void initCurrentYear() {
        currentYear = getCurrentYear();
    }

    private int getCurrentYear() {
        int currentYear = now.getYear();
        if (isNegativeNumber(currentYear)) {
            setNegativeException(currentYear);
        }
        return currentYear;
    }

    private void initCurrentDate() {
        currentDate = getCurrentDate();
    }

    // ?????? ?????? ?????? ?????? ???????????? ????????? ?????? ???, ?????? ?????? ??? ????????? ????????????. ex) 10??? 1??? -> 1001
    private int getCurrentDate() {
        int currentDate = Integer.parseInt(addZeroPrefix(Integer.toString(getCurrentMonth())) + addZeroPrefix(Integer.toString(getCurrentDay())));
        setNegativeException(currentDate);
        return currentDate;
    }

    private int getCurrentMonth() {
        int currentMonth = now.getMonthValue();
        if (isNegativeNumber(currentMonth)) {
            setNegativeException(currentMonth);
        }
        return currentMonth;
    }

    private int getCurrentDay() {
        return now.getDayOfMonth();
    }

    private void initUserYear() {
        userYear = getUserYear();
    }

    private int getUserYear() {
        int userYear = Integer.parseInt(userBirthday.year);
        setNegativeException(userYear);
        return userYear;
    }

    private void initUserDate() {
        userDate = getUserDate();
    }

    // ????????? ?????? ?????? ?????? ???????????? ????????? ?????? ???, ?????? ?????? ??? ????????? ????????????. ex) 10??? 1??? -> 1001
    private int getUserDate() {
        int userDate = Integer.parseInt(addZeroPrefix(Integer.toString(getUserMonth())) + addZeroPrefix(Integer.toString(getUserDay())));
        return userDate;
    }

    private int getUserMonth() {
        int userMonth = Integer.parseInt(userBirthday.month);
        setNegativeException(userMonth);
        return userMonth;
    }

    private int getUserDay() {
        int userDay = Integer.parseInt(userBirthday.day);
        setNegativeException(userDay);
        return userDay;
    }

    // TODO : Utils??? ????????????.
    String addZeroPrefix(String input) {
        if (Integer.parseInt(input) < 10) {
            input = "0" + input;
        }
        return input;
    }

    private void setNegativeException(int num) {
        try {
            if (isNegativeNumber(num)) {
                throw new negativeNumberException(Constants.NEGATIVE_ERROR);
            }
        } catch (negativeNumberException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private boolean isNegativeNumber(int num) {
        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }
}