package ru.gb.hw2;


import java.util.Arrays;

/**
 * 1. Написать метод, возвращающий количество чётных элементов массива.
 * 2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного
 * не пустого массива.
 */
public class Main {
    public static void main(String[] args) {
        int[] myArray = {3,5,6,7,8,9,2,3,5,6,12,56,84,110};

        int result = countEvens(myArray);
        int diff = difference(myArray);

        System.out.printf("Even count is %d of %d \n",result, myArray.length);
        System.out.printf("Difference between maximum and minimum %d", diff);
    }

    /**
     * Задача № 1
     * Метод, использующий Stream API для подсчета чётных элементов в массиве.
     *
     * @param input Массив целых чисел.
     * @return Количество чётных элементов в массиве.
     */
    public static int countEvens(int[] input){
        return (int) Arrays.stream(input).filter(element -> element % 2 == 0).count();
    }

    /**
     * Задача № 2
     * Функция для нахождения разницы между самым большим и самым маленьким элементами массива.
     *
     * @param input Массив целых чисел.
     * @return Разница между максимальным и минимальным элементами массива.
     * @throws IllegalArgumentException если массив содержит менее двух элементов.
     */
    public static int difference(int[] input) {
        if (input == null || input.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать как минимум два элемента.");
        }

        int max = Arrays.stream(input).max().orElseThrow();
        int min = Arrays.stream(input).min().orElseThrow();

        return max - min;
    }
}
