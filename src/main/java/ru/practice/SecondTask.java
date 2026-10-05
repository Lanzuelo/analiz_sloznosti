package ru.practice;

public class SecondTask {
    public static int gcd(int a, int b) {
        if (a <= 0 || b < 0) {
            throw new IllegalArgumentException("Требуется a > 0 и b >= 0");
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
