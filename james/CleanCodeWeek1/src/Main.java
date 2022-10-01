public class Main {
    public static void main(String[] args) {
        int ageLimit = 19;
        Date date = new Date();
        date.year = "2003";
        date.month = "10";
        date.day = "2";
        AgeChecker ageChecker = new AgeChecker(date);

        System.out.println("만 나이 " +  ageChecker.getInternationalAge());
        System.out.println(ageLimit + "세 미만인가? : " +  ageChecker.isUnderAgeLimit(ageLimit));
    }
}