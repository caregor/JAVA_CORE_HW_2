package ru.gb.hw2;


import java.util.Arrays;

/**
 * 1. Написать метод, возвращающий количество чётных элементов массива.
 */
public class Main {
    public static void main(String[] args) {
        int[] myArray = {3,5,6,7,8,9,2,3,5,6,12,56,84,110};
        int result = countEvens(myArray);
        System.out.printf("Even count is %d of %d",result, myArray.length);
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
}
