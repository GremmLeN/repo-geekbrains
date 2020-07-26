package ru.geekbrains;

public class lesson1 {


    public static void main(String[] args) {

        calculate(5, 4, 10, 3);
        System.out.println(checkSum(9 ,6));
        checkNegative(-12);
        helloSomeone("Momo");
        checkYear(2020);

    }

    private static void calculate(int a , int b, int c, int d) {
         float res = a * (b + (c / d));
        System.out.println(res);
    }

    private static boolean checkSum(int a, int b) {
        if ( a + b > 10 && a + b < 20) return true;
         else return false;
    }

    private static void checkNegative(int a) {
        if ( a >= 0 ) {
            System.out.println("Число " + a + " положительное.");
        }
         else {
            System.out.println("Число " + a + " отрицитальное");
        }

    }

    private static void helloSomeone(String name) {
        String hello = "Привет, " + name + "!";
        System.out.println(hello);
    }

    private static void checkYear (int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            System.out.println(year + " Год високосный");
        else
            System.out.println(year + " Год не високосный");
    }
}
