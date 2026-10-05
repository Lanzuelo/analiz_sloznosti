package ru.practice;

public class FirstTask {

    public static void generateSubsets(int[] values, int index,
                                       int[] current, int currentSize) {
        if (values == null || current == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (index < 0 || index > values.length
                || currentSize < 0 || currentSize > current.length
                || current.length < values.length) {
            throw new IllegalArgumentException("Некорректные параметры");
        }

        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] == values[j]) {
                    throw new IllegalArgumentException("Элементы должны быть различными");
                }
            }
        }

        generate(values, index, current, currentSize);
    }

    private static void generate(int[] values, int index,
                                 int[] current, int currentSize) {
        if (index == values.length) {
            printSubset(current, currentSize);
            return;
        }

        generate(values, index + 1, current, currentSize);

        current[currentSize] = values[index];
        generate(values, index + 1, current, currentSize + 1);
    }

    private static void printSubset(int[] current, int currentSize) {
        System.out.print("{");
        for (int i = 0; i < currentSize; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(current[i]);
        }
        System.out.println("}");
    }
}
