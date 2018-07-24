package euler;

import static util.PrettyPrint.*;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is
 * divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to
 * 31 Dec 2000)?
 * 
 * Link: https://projecteuler.net/problem=19
 * @author abijwe
 *
 */
public class Problem019 {

    private final static String[] days = {"M", "T", "W", "Th", "F", "Sa", "Su"};
    private final static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        int sum = 0, numSundays = 0;

        for (int year = 1900; year <=2000; year++) {
            int index = 0;
            boolean isLeapYear = isLeapYear(year);
            for (int month : months) {
                if (year == 2000 && index == 11) {
                    break; //we are done with decempebr, this loop will calculate first day for Jan 2001
                }

                sum += month + (index == 1 && isLeapYear ? 1 : 0);
                if (year != 1900 && "Su".equals(days[(sum)%7])) {
                    numSundays++;
                }
                index++;
            }
        }
        printResult(numSundays);
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year%100 == 0) {
                if (year%400 == 0) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
