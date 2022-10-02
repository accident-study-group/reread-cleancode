package com.raymond.yoo.reread.cleancode.week01;

import java.util.ArrayList;
import java.util.List;

public class ChapterTwoMeaningfulNames {
    /**
     * 1. 의도를 분명히 밝혀라
     */
    class SectionOne {
        /**
         * 의미없는 변수 이름
         */
        List<int[]> badList;

        /**
         * 의미없는 함수 이름
         */
        public List<int[]> bad() {
            List<int[]> list1 = new ArrayList<>();
            for (int[] x : badList)
                if (x[0] == 4)
                    list1.add(x);
            return list1;
        }

        /**
         * 의미를 이해할 수 있는 변수
         */
        List<int[]> gameBoard;
        final int STATUS_ACTIVE = 1;
        int FLAGGED = 1;

        /**
         * 의미를 이해할 수 있는 함수 이름
         */
        public List<int[]> getFlaggedCells() {
            List<int[]> flaggedCells = new ArrayList<>();
            for (int[] cell : gameBoard)
                if (cell[STATUS_ACTIVE] == FLAGGED)
                    flaggedCells.add(cell);
            return flaggedCells;
        }

        /**
         * 훨씬 더 의미를 이해하기 편한 변수
         */
        List<Cell> gameBoardBetter;

        /**
         * 훯씬 더 이해하기 편한 함수
         */
        public List<Cell> getFlaggedCellsBetter() {
            List<Cell> flaggedCells = new ArrayList<>();
            for (Cell cell : gameBoardBetter)
                if (cell.isFlagged())
                    flaggedCells.add(cell);
            return flaggedCells;
        }

        class Cell {
            boolean isFlagged() {
                return true;
            }
        }
    }

    /**
     * 3. 의미있게 구분하라
     */
    class SectionThree {
        /**
         * 파라미터 a1, a2 가 어떤 역할을 하는지 명확하지 않다
         */
        public void copyChars(char[] a1, char[] a2) {
            for (int i = 0; i < a1.length; ++i) {
                a2[i] = a1[i];
            }
        }

        /**
         * source, destination 이라는 이름을 사용하므로서 의미가 보다 명확해졌다
         */
        public void copyChars2(char[] source, char[] destination) {
            for (int i = 0; i < source.length; ++i) {
                destination[i] = source[i];
            }
        }
    }

    /**
     * 5. 검색하기 쉬운 이름을 사용하라
     */
    class SectionFive {
        /**
         * 여기에서 사용하는 상수들이 변수로 선언되어 있지 않았다면
         * 나중에 realDaysPerIdealDay, WORK_DAYS_PER_WEEK 에 해당하는
         * 4, 5 를 일일이 검색해서 의미를 파악해가며 하나씩 바꿔야 한다.
         */
        private final int realDaysPerIdealDay = 4;
        private final int WORK_DAYS_PER_WEEK = 5;

        public int weeksSpentOnTasks(int numberOfTasks, int[] taskEstimate) {
            int sum = 0;
            for (int j = 0; j < numberOfTasks; ++j) {
                int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
                int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
                sum += realTaskWeeks;
            }
            return sum;
        }
    }

    /**
     * 16. 의미 있는 맥락을 추가하라
     */
    class SectionSixteen {
        /**
         * 문제점 1: 함수의 길이가 다소 길다.
         * 문제점 2: 서로 연관성이 높은 세 개의 변수를 따로 제어한다.
         */
        private String printGuessStatistics(char candidate, int count) {
            String number;
            String verb;
            String pluralModifier;
            if (count == 0) {
                number = "no";
                verb = "are";
                pluralModifier = "s";
            } else if (count == 1) {
                number = "1";
                verb = "is";
                pluralModifier = "";
            } else {
                number = Integer.toString(count);
                verb = "are";
                pluralModifier = "s";
            }
            return String.format(
                    "There %s %s %s%s", verb, number, candidate, pluralModifier
            );
        }

        /**
         * 개선점 1: 세 변수 number, verb, pluralModifier 의 맥락이 훨씬 분명해졌다.
         * 개선점 2: 함수를 쪼개기가 쉬워지므로 알고리즘도 좀 더 명확해진다.
         */
        public class GuessStatisticsMessage {
            private String number;
            private String verb;
            private String pluralModifier;

            public String make(char candidate, int count) {
                createPluralDependentMessageParts(count);
                return String.format(
                        "There %s %s %s%s", verb, number, candidate, pluralModifier
                );
            }

            private void createPluralDependentMessageParts(int count) {
                if (count == 0) {
                    thereAreNoLetters();
                } else if (count == 1) {
                    thereIsOneLetter();
                } else {
                    thereAreManyLetters(count);
                }
            }

            private void thereAreManyLetters(int count) {
                number = Integer.toString(count);
                verb = "are";
                pluralModifier = "s";
            }

            private void thereIsOneLetter() {
                number = "1";
                verb = "is";
                pluralModifier = "";
            }

            private void thereAreNoLetters() {
                number = "no";
                verb = "are";
                pluralModifier = "s";
            }
        }
    }
}
