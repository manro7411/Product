package router;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmpericalAnalysis {

    public static void main(String[] args) {
        long N = 100, start, end;
        long answer = 0;
        System.out.println("This is the lab2 from Mr.Ratchanon Traitiprat 64130500244");
        Calendar now = new GregorianCalendar();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int ampm = now.get(Calendar.AM_PM);
        System.out.print(" at " + hour + ":" + minute + ":" + second + " " + (ampm > 0 ? "PM" : "AM"));
        System.out.println(
                " on " + now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR));
        for (int i = 1; i <= 5; i++) {
            start = System.currentTimeMillis();
            answer = sumOfSummationO_of_nSquared(N);
            end = System.currentTimeMillis();
            System.out.print("When N=" + N + " Summation of O(n^2) took " + (end - start + " "));
            start = System.currentTimeMillis();
            answer = sumOfSummationO_of_n(N);
            end = System.currentTimeMillis();
            System.out.print(", of O(n) took " + (end - start) + " milliseconds. ");
            start = System.currentTimeMillis();
            answer = sumOfSummationO_of_nCubed(N);
            end = System.currentTimeMillis();
            System.out.print(", of O(n^3) took " + (end - start) + " milliseconds. ");
            System.out.println(" Sum of summation from 1 to " + N + " is " + answer);
            N *= 10;
        }
        N = 5;
        answer = sumOfSummation_formular(N);
        System.out.println(answer);
    }

    public static long sumOfSummationO_of_n(long n) {
        long sumOfSum = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            sumOfSum += sum;
        }
        return sumOfSum;
    }

    public static long sumOfSummation_formular(long n) {
        long sumOfSum = 0;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = i * (i + 1) / 2;
            sumOfSum += sum;
        }
        return sumOfSum;
    }

    public static long sumOfSummationO_of_nSquared(long n) {
        long sumOfSum = 0;
        for (int s = 1; s <= n; s++) {
            long sum = 0;
            for (int i = 1; i <= s; i++) {
                sum += i;
            }
            sumOfSum += sum;
        }
        return sumOfSum;
    }

    public static long sumOfSummationO_of_nCubed(long n) {
        long sumOfSum = 0;
        for (int s = 1; s <= n; s++) {
            long sum = 0;
            for (int i = 1; i <= s; i++) {
                int k = 0;
                while (k < i) {
                    k = k + 1;
                    sum += 1;
                }
                // sum += k;
            }
            sumOfSum += sum;
        }
        return sumOfSum;
    }

}
