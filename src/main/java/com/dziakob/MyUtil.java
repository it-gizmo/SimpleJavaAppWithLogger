package com.dziakob;

public class MyUtil {
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
    public static boolean isBlank(String input) {
        return input.trim().isEmpty();
    }
}
