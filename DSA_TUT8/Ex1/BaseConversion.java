package DSAall.DSA_TUT8.Ex1;

import java.util.*;

public class BaseConversion {
    public static void main(String[] args) {
        int num = 1278;
        int base = 16;

        System.out.println("Base " + base + " representation of " + num + " is: " + convertToBase(num, base));
    }

    public static String convertToBase(int num, int base) {
        ArrayStack stack = new ArrayStack(100);
        StringBuilder res = new StringBuilder();

        while (num > 0) {
            stack.push(num % base);
            num /= base;
        }

        while (!stack.isEmpty()) {
            int digit = stack.pop();
            if (digit < 10) {
                res.append(digit);
            } else {
                // append A-Z for 10-35
                res.append((char) ('A' + digit - 10));
            }

        }

        return res.toString();
    }

    /**
     * @java.util.Stack
     *                  ultilize Stack implemented
     */

    @SuppressWarnings("unused")
    public static String converter(int K, int B) {
        Stack<Integer> S = new Stack<>();
        StringBuilder res = new StringBuilder();

        while (K > 0) {
            S.push(K % B);
            K /= B;
        }

        while (!S.isEmpty()) {
            int digit = S.pop();
            if (digit < 10) {
                // append 0-9
                res.append(digit);
            } else {
                // append A-Z for 10-35
                res.append((char) ('A' + digit - 10));
            }

        }

        return res.toString();
    }
}
