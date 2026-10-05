package ru.practice;

public class FirstTask {
    public static int money(int first, int difference, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Номер дня должен быть неотрицательным");
        }
        if (n == 0) {
            return first;
        }
        return money(first, difference, n - 1) + difference;
    }
}
