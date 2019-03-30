package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void drawField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; ++i) {
            System.out.print("|");

            for (int j = 0; j < 3; ++j) {
                System.out.print(" " + field[i][j]);
            }

            System.out.println(" |");
        }
        System.out.println("---------");
        System.out.println();
    }

    public static boolean checkField(char[][] field) {
        for (int i = 0; i < 3; ++i) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != ' ') {
                System.out.print(field[i][0] + " wins");
                return false;
            }

            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != ' ') {
                System.out.print(field[0][i] + " wins");
                return false;
            }

        }

        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != ' ') {
            System.out.println(field[0][0] + " wins");
            return false;
        } else if (field[0][2] == field[1][1] && (field[1][1] == field[2][0]) && (field[1][1] != ' ')) {
            System.out.println(field[0][2] + " wins");
            return false;
        }

        boolean moreMoves = false;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (field[i][j] == ' ') {
                    moreMoves = true;
                }
            }
        }

        if (!moreMoves) {
            System.out.println("Draw");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {


        char[][] field = new char[3][3];

        //initial filed state
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; ++j) {
                field[i][j] = ' ';
            }
        }

        final Scanner scanner = new Scanner(System.in);

        String _x = "";
        String _y = "";

        while (true) {
            drawField(field);

            do {
                System.out.print("Enter the coordinates: ");

                _x = scanner.next();
                _y = scanner.next();
            }
            while (!(checkValues(_x) && checkValues(_y) && ceilIsEmpty(field, _x, _y)));

            int x = Integer.parseInt(_x) - 1;
            int y = Integer.parseInt(_y) - 1;

            field[y][x] = 'X';

            drawField(field);

            if (!checkField(field))
                break;

            System.out.println("Making move level \"easy\"");

            boolean gone = false;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j)
                    if (field[i][j] == ' ') {
                        field[i][j] = 'O';
                        gone = true;
                        break;
                    }
                if (gone)
                    break;
            }

            if (!checkField(field))
                break;
        }
    }

    static boolean checkValues(String _y) {
        boolean correctInput = true;
        switch (_y) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                correctInput = false;
        }

        return correctInput;
    }


    static boolean ceilIsEmpty(char[][] field, String _x, String _y) {

        int x = Integer.parseInt(_x) - 1;
        int y = Integer.parseInt(_y) - 1;

        return (field[y][x] == ' ');
    }
}