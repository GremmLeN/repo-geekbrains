package ru.geekbrains;

public class lesson1 {


    public static void main(String[] args) {

        System.out.println(calculate(5, 4, 10, 3));
        System.out.println(checkSum(9 ,6));
        System.out.println(checkNegative(-12));
        System.out.println(helloSomeone("Momo"));
        System.out.println(checkYear(2020));

    }

    private static float calculate(int a , int b, int c, int d) {
        return a * (b + (c / d));

    }

    private static boolean checkSum(int a, int b) {
        return ( a + b > 10 && a + b < 20);
    }

    private static boolean checkNegative(int a) {
        return  ( a >= 0 );
    }

    private static String helloSomeone(String name) {
       return "Привет, " + name + "!";
    }

    private static boolean checkYear (int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

    }
}
