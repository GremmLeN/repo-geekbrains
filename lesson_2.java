package ru.geekbrains;

import java.util.Arrays;

public class lesson2 {

    public static void main(String[] args) {

        int arr1 [] = {1, 1, 1, 0, 0, 0, 1, 0};
        System.out.println(Arrays.toString(replace(arr1)));

        int arr2 [] = new int[8];
        System.out.println(Arrays.toString(fillIn(arr2)));

        int arr3 [] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(multipleArrMember(arr3)));

        int arr4 [] = {2, 5, 13, 9, 1};
        System.out.println("Максимальное значние в массиве: " + findMaxInArr(arr4));

        int arr5 [][] = new int[5][5];
        System.out.println(Arrays.deepToString(fillingArray(arr5)));

        int arr6 [] = {10, 1, 2, 3, 4};
        System.out.println("Сумма левой и правой части массива равны ? " + checkBalance(arr6));

        int arr7 [] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(moveArrElements(arr7, -2)));
    }

    private static int[] replace (int arr []) {
        for (int i =0; i < arr.length; i++) {
            if (arr[i] == 0 )  arr[i] = 1;
            else arr[i] = 0;
        }
        return arr;
    }

    private static int[] fillIn (int arr []) {
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cnt;
            cnt = cnt+=3;
        }
        return arr;
    }

    private static int[] multipleArrMember (int arr []) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i]  *= 2;
        }
        return arr;
    }

    private static int findMaxInArr (int arr []) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    private static int[][] fillingArray (int arr [][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i || j == arr[i].length - 1 - i) arr[i][j] = 1;
            }
        }
        return arr;
    }

    private static boolean checkBalance (int arr []) {
        int sumA = 0;
        int sumB = 0;
        for (int i =0; i < arr.length; i++) {
            sumA = sumA + arr[i];
        }

        for (int j = arr.length - 1; j >= 0; j--) {
            if (sumA == sumB) {
                return true;
            }
            else {
                sumB = sumB + arr[j];
                sumA = sumA - arr[j];
            }

        }
        return false;
    }

    private static int [] moveArrElements (int arr[], int n) {
        int temp;
        if (n > 0) {
            for (int i = 0; i < arr.length -n; i++) {
                temp = arr[i];
                arr[i] = arr[i + n];
                arr[i + n] = temp;
            }
        }
        else {
            n = n * -1;
            for (int i = arr.length - 1 - n; i >= 0; i--) {
                temp = arr[i];
                arr[i] = arr[i + n];
                arr[i + n] = temp;
            }
        }
        return arr;
    }

}