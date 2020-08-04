package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class lesson3 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;
    private static int winCondition;
    private static int humanX;
    private static int humanY;

    private static void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }

        if (fieldSizeX == 5) winCondition = 4;
        else winCondition = fieldSizeX;
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            humanX = SCANNER.nextInt() - 1;
            humanY = SCANNER.nextInt() - 1;
        } while (!isValidCell(humanX, humanY) || !isEmptyCell(humanX, humanY));
        field[humanY][humanX] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn() {
        int x;
        int y;
        if (tryBlock()) return;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean tryBlock () {
        //hor
        int cnt = 0;
        for (int i = 0; i < winCondition; i++) {
            if (field[humanY][i] == DOT_HUMAN) cnt++;
            if (cnt == winCondition - 1) {
                for (int j = 0; j < winCondition; j++) {
                    if (field[humanY][j] == DOT_EMPTY) {
                    field[humanY][j] = DOT_AI;
                    return true;
                    };
                }
            }
        }

        //ver
        cnt = 0;
        for (int t = 0; t < winCondition; t++) {
            if (field[t][humanX] == DOT_HUMAN) cnt++;
            if (cnt == winCondition - 1) {
                for (int j = 0; j < winCondition; j++) {
                    if (field[j][humanX] == DOT_EMPTY) {
                        field[j][humanX] = DOT_AI;
                        return true;
                    }

                }
            }
        }
        //dia
        //middle
        if (humanY == (field.length - 1) / 2 && humanX == (field[humanX].length - 1) / 2) {
            cnt = 1;
            for (int i = humanY; i < winCondition - 1; i++) {
                if ((field[humanY - i][humanX - i] == DOT_HUMAN) || (field[humanY + i][humanX + i] == DOT_HUMAN)) cnt++;
                if (cnt == winCondition - 1) {
                    for(int j = 0; j < winCondition; j++) {
                        if (isEmptyCell(j, j)) {
                            field[j][j] = DOT_AI;
                            return true;
                        }
                    }
                }
                else if ((field[humanY + i][humanX - i] == DOT_HUMAN) || (field[humanY - i][humanX + i] == DOT_HUMAN)) cnt++;
                if (cnt == winCondition - 1) {
                    for (int j = 0; j < winCondition; j++) {
                        if(isEmptyCell(j, field[j].length - 1 - j)) {
                            field[field.length - 1 - j][j] = DOT_AI;
                            return true;
                        }
                    }
                }
            }
        }
//        //dia
//        if (humanY == humanY) {
//          cnt = 1;
//          for (int i = 0; i < winCondition -1; i++) {
//              if((field[humanY - i][humanX - i] == DOT_HUMAN) || (field[humanY + i][humanX + i] == DOT_HUMAN)) cnt++;
//              if (cnt == winCondition - 1) {
//                  for (int j = 0; j < winCondition; j++) {
//                      if(isEmptyCell(j, field[j].length - 1 - j)) {
//                          field[field.length - 1 - j][j] = DOT_AI;
//                          return true;
//                      }
//                  }
//              }
//          }
//        }
        return false;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        int cnt;
        int cnt1;
        //hor-ver
        for (int i = 0; i < winCondition; i++) {
            cnt  = 0;
            cnt1 = 0;
            for (int j = 0; j < winCondition; j++){
                if (field[i][j] == c) cnt++; //hor
                if (field[j][i] == c) cnt1++; //ver
                if (cnt == winCondition || cnt1 == winCondition) return true;
            }
        }
        //dia
        cnt  = 0;
        cnt1 = 0;
        for (int i = 0; i < winCondition; i++) {
            if (field[i][i] == c) cnt++; //dia1
            else if (field[i][i] != c && field[i][i] != DOT_EMPTY) cnt--;
            if (field[i][field.length - 1 - i] == c) cnt1++; //dia2
            else if (field[i][field.length - 1 - i] != c && field[i][field.length - 1 - i] != DOT_EMPTY) cnt--;
            if (cnt == winCondition || cnt1 == winCondition) return true;
        }
        // hor
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

    public static void main(String[] args) {
        String answer;
        do {
            initField();
            printField();
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

}
