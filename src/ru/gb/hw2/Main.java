package ru.gb.hw2;


import java.util.Arrays;

/**
 * 1. Написать метод, возвращающий количество чётных элементов массива.
 * 2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного
 * не пустого массива.
 * 3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
 * 4. Требуется написать метод, принимающий на вход размеры двумерного массива и выводящий массив
 * в виде инкременированной цепочки чисел, идущих по спирали.
 */
public class Main {
    public static void main(String[] args) {
        int[] myArray = {3,5,6,7,8,9,2,3,5,6,12,56,84,110, 0, 0};
        int rows = 4;
        int cols = 4;
        int result = countEvens(myArray);
        int diff = difference(myArray);
        boolean doubleZero = zeroElements(myArray);
        int[][] matrix = generateSpiralArray(rows, cols);

        System.out.printf("Even count is %d of %d \n",result, myArray.length);
        System.out.printf("Разница между минимальным и максимальным элементом: %d \n", diff);
        System.out.printf("Два нулевых значения? %b \n", doubleZero);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < 10) {
                    System.out.print("0" + matrix[i][j] + " ");
                }
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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

    /**
     * Задача № 3
     * Функция для проверки наличия двух соседних элементов в массиве,
     * с нулевым значением.
     *
     * @param input Массив целых чисел.
     * @return true, если есть два соседних элемента, один из которых равен нулю, иначе false.
     * @throws IllegalArgumentException если массив содержит менее двух элементов.
     */
    public static boolean zeroElements(int[] input) {
        if (input == null || input.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать как минимум два элемента.");
        }

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == 0 && input[i + 1] == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param rows Кол-во строк матрицы.
     * @param cols Кол-во столбцов матрицы.
     * @return Матрица размером rows на cols закрученная по часовой стрелке.
     */
    public static int[][] generateSpiralArray(int rows, int cols) {
        int[][] result = new int[rows][cols];

        int num = 1;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }

        return result;
    }
}
