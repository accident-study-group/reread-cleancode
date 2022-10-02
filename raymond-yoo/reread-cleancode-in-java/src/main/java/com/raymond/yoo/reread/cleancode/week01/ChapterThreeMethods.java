package com.raymond.yoo.reread.cleancode.week01;

import java.io.IOException;
import java.io.InputStream;

public class ChapterThreeMethods {
    /**
     * 5. Switch 문 대신에 다형성을 활용하자
     */
    class SectionFive {
        class Bad {
            /**
             * 문제점 1: 새 직원 유형을 추가할 때마다 함수의 길이가 계속해서 늘어난다
             * 문제점 2: 한 가지 작업만 수행하지 않는다
             * 문제점 3: SRP(Single Responsibility Principle)을 위반한다
             * 문제점 4: OCP(Open Closed Principle)을 위반한다
             */
            public MoneyBad calculatePay(EmployeeBad e) throws InvalidEmployeeType {
                switch (e.type) {
                    case COMMISSIONED:
                        return calculateCommissionedPay(e);
                    case HOURLY:
                        return calculateHourlyPay(e);
                    case SALARIED:
                        return calculateSalariedPay(e);
                    default:
                        throw new InvalidEmployeeType(e.type);
                }
            }

            class MoneyBad {
            }

            class EmployeeBad {
                int type;
            }

            private MoneyBad calculateCommissionedPay(EmployeeBad e) {
                return new MoneyBad();
            }

            private MoneyBad calculateHourlyPay(EmployeeBad e) {
                return new MoneyBad();
            }

            private MoneyBad calculateSalariedPay(EmployeeBad e) {
                return new MoneyBad();
            }
        }

        /**
         * 이런식으로 적절하게 추상화를 하면 내부적으로 복잡한 로직을 구현하고 있더라도
         * public 으로 공개하는 클래스와 메서드의 로직을 간소화할 수 있다.
         */
        class Good {
            public abstract class Employee {
                public abstract boolean isPayDay();

                public abstract Money calculatePay();

                public abstract void deliverPay(Money pay);
            }

            public abstract class EmployeeFactory {
                public abstract Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
            }

            /**
             * 여전히 Switch 문이 있다???
             */
            public class EmployeeFactoryImpl extends EmployeeFactory {
                @Override
                public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
                    switch (r.type) {
                        case COMMISSIONED:
                            return new CommissionedEmployee();
                        case HOURLY:
                            return new HourlyEmployee();
                        case SALARIED:
                            return new SalariedEmployee();
                        default:
                            throw new InvalidEmployeeType(r.type);
                    }
                }
            }

            class Money {
            }

            class EmployeeRecord {
                int type;
            }

            class CommissionedEmployee extends Employee {
                @Override
                public boolean isPayDay() {
                    return false;
                }

                @Override
                public Money calculatePay() {
                    return null;
                }

                @Override
                public void deliverPay(Money pay) {

                }
            }

            class HourlyEmployee extends Employee {
                @Override
                public boolean isPayDay() {
                    return false;
                }

                @Override
                public Money calculatePay() {
                    return null;
                }

                @Override
                public void deliverPay(Money pay) {

                }
            }

            class SalariedEmployee extends Employee {
                @Override
                public boolean isPayDay() {
                    return false;
                }

                @Override
                public Money calculatePay() {
                    return null;
                }

                @Override
                public void deliverPay(Money pay) {

                }
            }
        }
    }

    final int COMMISSIONED = 0;
    final int HOURLY = 1;
    final int SALARIED = 2;

    class InvalidEmployeeType extends Exception {
        public InvalidEmployeeType(int type) {
        }
    }

    /**
     * 7. 함수 인수 (함수의 이상적인 인수 개수는 0 ~ 2개)
     */
    class SectionSeven {
        /**
         * 인수 0개인 메서드
         * <p>
         * 일반적으로 파라미터가 0 개인 함수가 1 개인 함수보다 이해하기 쉽다
         */
        class ZeroParamMethods {
            /**
             * 비교 1-1(Not Good): 이 함수를 호출할 때마다 argument 로 무엇을 집어넣을지 고민한다
             * 테스트 작성이라는 관점에서 생각해도 인수가 적을수록 테스트 케이스는 간단해진다.
             */
            boolean includeSetupPageInto(PageContent pageContent) {
                return true;
            }

            class PageContent {
            }

            /**
             * 비교 1-2(Good): 사용하기도 편하고 이해하기도 편하다
             */
            boolean includeSetupPage() {
                return true;
            }
        }

        /**
         * 인수가 1개인 메서드
         */
        class UniParamMethods {
            /**
             * 뭔가를 확인하는 경우 이런식으로 파라미터가 1개인 함수를 만든다
             */
            boolean fileExists(String fileName) {
                return true;
            }

            /**
             * 파라미터를 활용해서 뭔가를 변환하는 역할이라면 결과값을 리턴하도록 구현하면 좋다
             */
            InputStream openFile(String fileName) {
                return new InputStream() {
                    @Override
                    public int read() throws IOException {
                        return 0;
                    }
                };
            }
        }

        class MultiParamMethods {
            /**
             * 이런식으로 두 개 이상의 변수가 밀접한 뎐관성이 있을 경우에는 하나의 클래스 또는 객체로 묶어서 생각하면 좋다
             */
            class Point {
                double x;
                double y;

                public Point(double x, double y) {
                    this.x = x;
                    this.y = y;
                }
            }
        }
    }
}
