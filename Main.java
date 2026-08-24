package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    while (true){
        System.out.println("===================================");
        System.out.println("1.single player");
        System.out.println("2.play with frind ");
        System.out.println("3.exit");
        System.out.println("===================================");
        System.out.print("please enter your choice :");
        try {
            int ch = scanner.nextInt();

            if (ch == 1) {
                singlePlayer(scanner);
            } else if (ch == 2) {
                playWithFrind(scanner);
            } else if (ch == 3) {
                break;
            }
        }catch (InputMismatchException e){
            System.out.println("wrong input type  ");
        }
    }

}
public static void playWithFrind(Scanner scanner){
    while (true){
        System.out.println("===========================");
        System.out.println("1.play 1 round");
        System.out.println("2.play best of 3");
        System.out.println("3.exit");
        System.out.println("===========================");
        System.out.print("enter your choice :");
        try {

            int choice = scanner.nextInt();
            if (choice == 1) {
                frind_tic_tak_1round(scanner);
            } else if (choice == 2) {
                Frind_tic_tak_bestOf3(scanner);
            } else if (choice == 3) {
                break;
            }
        }catch (InputMismatchException e){
            System.out.println("wrong input type");
        }
    }
}
public static void singlePlayer(Scanner scanner){
    while (true){
        System.out.println("===========================");
        System.out.println("1.play 1 round");
        System.out.println("2.play best of 3");
        System.out.println("3.exit");
        System.out.println("===========================");
        System.out.print("enter your choice :");
        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                tic_tak_1round(scanner);
            } else if (choice == 2) {
                tic_tak_bestOf3(scanner);
            } else if (choice == 3) {
                break;
            }
        }catch (InputMismatchException e){
            System.out.println("wrong input type ");
        }
    }
}

    public static boolean checkValidity (char[][] bord , int colum,int row ,char choice ){
        if(bord[row][colum]!=choice){
            return false;
        }
        return true;
    }

    public static boolean checkfull(char[][] bord ,char playerMark,char compMark){
        boolean isFull=true;
        try {
            for (int i = 0; i < bord.length; i++) {
                for (int y = 0; y < bord.length; y++) {
                    if (bord[i][y] == playerMark || bord[i][y] == compMark) {

                    } else {
                        isFull = false;
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return isFull;
    }

    public static String checkWinner(char[][] bord,char playerMark,char compMark){
        try {
            for (int i = 0; i < bord.length; i++) {
                if (bord[0][i] == playerMark && bord[1][i] == playerMark && bord[2][i] == playerMark) {
                    return "player";
                } else if (bord[0][i] == compMark && bord[1][i] == compMark && bord[2][i] == compMark) {
                    return "computer";
                }
            }

            for (int i = 0; i < bord.length; i++) {
                if (bord[i][0] == playerMark && bord[i][1] == playerMark && bord[i][2] == playerMark) {
                    return "player";
                } else if (bord[i][0] == compMark && bord[i][1] == compMark && bord[i][2] == compMark) {
                    return "computer";
                }
            }

            if (bord[0][0] == playerMark && bord[1][1] == playerMark && bord[2][2] == playerMark) {
                return "player";
            } else if (bord[0][0] == compMark && bord[1][1] == compMark && bord[2][2] == compMark) {
                return "computer ";
            }

            if (bord[0][2] == playerMark && bord[1][1] == playerMark && bord[2][0] == playerMark) {
                return "player";
            } else if (bord[0][2] == compMark && bord[1][1] == compMark && bord[2][0] == compMark) {
                return "computer";
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return " ";
    }

    public static String tic_tak_1round(Scanner scanner){
        char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        String win = "";
try {
    System.out.print("chose x/o :");
    scanner.nextLine();
    char playerMark = scanner.nextLine().charAt(0);
    char compMark;
    if (playerMark == 'x') {
        compMark = 'o';
    } else {
        compMark = 'x';
    }
    boolean gameEnd = false;

    while (!gameEnd) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

            if (i < 2) {
                System.out.println("--------");
            }
        }
//user selection =========================================================================
        while (true) {
            System.out.print("please enter you choice position  : ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                if (checkValidity(board, 0, 0, '1')) {
                    board[0][0] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 2) {
                if (checkValidity(board, 1, 0, '2')) {
                    board[0][1] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 3) {
                if (checkValidity(board, 2, 0, '3')) {
                    board[0][2] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 4) {
                if (checkValidity(board, 0, 1, '4')) {
                    board[1][0] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 5) {
                if (checkValidity(board, 1, 1, '5')) {
                    board[1][1] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 6) {
                if (checkValidity(board, 2, 1, '6')) {
                    board[1][2] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }

            } else if (choice == 7) {
                if (checkValidity(board, 0, 2, '7')) {
                    board[2][0] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 8) {
                if (checkValidity(board, 1, 2, '8')) {
                    board[2][1] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 9) {
                if (checkValidity(board, 2, 2, '9')) {
                    board[2][2] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else {
                if (checkfull(board, playerMark, compMark)) {
                    break;
                } else {
                    System.out.println("enter valid position");
                }
            }
        }
//check win first =====================================================
        win = checkWinner(board, playerMark, compMark);
        if (win.equalsIgnoreCase("player") || win.equalsIgnoreCase("computer")) {
            for (int i = 0; i < 3; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            System.out.println("the " + win + " won the Round ");
            gameEnd = true;
            break;
        } else if (checkfull(board, playerMark, compMark)) {
            for (int i = 0; i < 3; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            System.out.println("Draw");
            win = "Draw";
            gameEnd = true;
            break;
        }
//computer random select===============================================
        while (true) {
            int choiceCump = (int) (1 + Math.random() * 10);
            if (choiceCump == 1) {
                if (checkValidity(board, 0, 0, '1')) {
                    board[0][0] = compMark;
                    break;
                }
            } else if (choiceCump == 2) {
                if (checkValidity(board, 1, 0, '2')) {
                    board[0][1] = compMark;
                    break;
                }
            } else if (choiceCump == 3) {
                if (checkValidity(board, 2, 0, '3')) {
                    board[0][2] = compMark;
                    break;
                }
            } else if (choiceCump == 4) {
                if (checkValidity(board, 0, 1, '4')) {
                    board[1][0] = compMark;
                    break;
                }
            } else if (choiceCump == 5) {
                if (checkValidity(board, 1, 1, '5')) {
                    board[1][1] = compMark;
                    break;
                }
            } else if (choiceCump == 6) {
                if (checkValidity(board, 2, 1, '6')) {
                    board[1][2] = compMark;
                    break;
                }

            } else if (choiceCump == 7) {
                if (checkValidity(board, 0, 2, '7')) {
                    board[2][0] = compMark;
                    break;
                }
            } else if (choiceCump == 8) {
                if (checkValidity(board, 1, 2, '8')) {
                    board[2][1] = compMark;
                    break;
                }
            } else if (choiceCump == 9) {
                if (checkValidity(board, 2, 2, '9')) {
                    board[2][2] = compMark;
                    break;
                } else {
                    if (checkfull(board, playerMark, compMark)) {
                        break;
                    }
                }
            }
        }
// wining check second ================================================================================
        win = checkWinner(board, playerMark, compMark);
        if (win.equalsIgnoreCase("player") || win.equalsIgnoreCase("computer")) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            System.out.println("the " + win + " won the Round ");
            gameEnd = true;
        } else if (checkfull(board, playerMark, compMark)) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            System.out.println("Draw");
            win = "Draw";
            gameEnd = true;
        }

    }
}catch (InputMismatchException e){
    System.out.println("wrong input type ");
}catch (ArrayIndexOutOfBoundsException e){
    System.out.println(e.getMessage());
}catch (Exception e){
    System.out.println(e.getMessage());
}
        return win;
    }

    public static void tic_tak_bestOf3 (Scanner scanner){
        int counter_player_wins =0;
        int counter_cumpyoter_wins=0;

        for(int i=0;i<3;i++) {
            String roundWinner = tic_tak_1round(scanner);
            if (roundWinner.equalsIgnoreCase("player")) {
                counter_player_wins++;
            } else if (roundWinner.equalsIgnoreCase("computer")) {
                counter_cumpyoter_wins++;
            } else if (roundWinner.equalsIgnoreCase("draw")) {
                i--;
            }
        }
        if(counter_player_wins>counter_cumpyoter_wins){
            System.out.println("the player won the game ");
        }else {
            System.out.println("computer won the game tray again");
        }
    }

    public static void Frind_tic_tak_bestOf3 (Scanner scanner){
        int counter_player_wins =0;
        int counter_cumpyoter_wins=0;

        for(int i=0;i<3;i++) {
            String roundWinner = frind_tic_tak_1round(scanner);
            if (roundWinner.equalsIgnoreCase("player")) {
                counter_player_wins++;
            } else if (roundWinner.equalsIgnoreCase("computer")) {
                counter_cumpyoter_wins++;
            } else if (roundWinner.equalsIgnoreCase("draw")) {
                i--;
            }
        }
        if(counter_player_wins>counter_cumpyoter_wins){
            System.out.println("the player 1 won the game ");
        }else {
            System.out.println("player 2 won the game ");
        }
    }

    public static String frind_tic_tak_1round(Scanner scanner){
        char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        String win = "";
try {

    System.out.print("player 1 chose x/o :");
    scanner.nextLine();
    char playerMark = scanner.nextLine().charAt(0);
    char compMark;
    if (playerMark == 'x') {
        compMark = 'o';
    } else {
        compMark = 'x';
    }
    boolean gameEnd = false;

    while (!gameEnd) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

            if (i < 2) {
                System.out.println("--------");
            }
        }
//player 1 selection =========================================================================
        System.out.println("player 1 turn");
        while (true) {
            System.out.print("please enter you choice position  : ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                if (checkValidity(board, 0, 0, '1')) {
                    board[0][0] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 2) {
                if (checkValidity(board, 1, 0, '2')) {
                    board[0][1] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 3) {
                if (checkValidity(board, 2, 0, '3')) {
                    board[0][2] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 4) {
                if (checkValidity(board, 0, 1, '4')) {
                    board[1][0] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 5) {
                if (checkValidity(board, 1, 1, '5')) {
                    board[1][1] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 6) {
                if (checkValidity(board, 2, 1, '6')) {
                    board[1][2] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }

            } else if (choice == 7) {
                if (checkValidity(board, 0, 2, '7')) {
                    board[2][0] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 8) {
                if (checkValidity(board, 1, 2, '8')) {
                    board[2][1] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 9) {
                if (checkValidity(board, 2, 2, '9')) {
                    board[2][2] = playerMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else {
                if (checkfull(board, playerMark, compMark)) {
                    break;
                } else {
                    System.out.println("enter valid position");
                }
            }
        }
//check win first =====================================================
        win = checkWinner(board, playerMark, compMark);
        if (win.equalsIgnoreCase("player") || win.equalsIgnoreCase("computer")) {
            for (int i = 0; i < 3; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            if (win.equalsIgnoreCase("player")) {
                System.out.println("player 1 win the round");
            } else {
                System.out.println("player 2 win the round");
            }
            gameEnd = true;
            break;
        } else if (checkfull(board, playerMark, compMark)) {
            for (int i = 0; i < 3; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            System.out.println("Draw");
            win = "Draw";
            gameEnd = true;
            break;
        }
//player 2 select===============================================
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

            if (i < 2) {
                System.out.println("--------");
            }
        }
        System.out.println("player 2 turn");
        while (true) {
            System.out.print("please enter you choice position  : ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                if (checkValidity(board, 0, 0, '1')) {
                    board[0][0] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 2) {
                if (checkValidity(board, 1, 0, '2')) {
                    board[0][1] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 3) {
                if (checkValidity(board, 2, 0, '3')) {
                    board[0][2] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 4) {
                if (checkValidity(board, 0, 1, '4')) {
                    board[1][0] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 5) {
                if (checkValidity(board, 1, 1, '5')) {
                    board[1][1] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 6) {
                if (checkValidity(board, 2, 1, '6')) {
                    board[1][2] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }

            } else if (choice == 7) {
                if (checkValidity(board, 0, 2, '7')) {
                    board[2][0] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 8) {
                if (checkValidity(board, 1, 2, '8')) {
                    board[2][1] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else if (choice == 9) {
                if (checkValidity(board, 2, 2, '9')) {
                    board[2][2] = compMark;
                    break;
                } else {
                    System.out.println("the position is invalid enter again");
                }
            } else {
                if (checkfull(board, playerMark, compMark)) {
                    break;
                } else {
                    System.out.println("enter valid position");
                }
            }
        }
// wining check second ================================================================================
        win = checkWinner(board, playerMark, compMark);
        if (win.equalsIgnoreCase("player") || win.equalsIgnoreCase("computer")) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            if (win.equalsIgnoreCase("player")) {
                System.out.println("player 1 win the round");
            } else {
                System.out.println("player 2 win the round");
            }
            gameEnd = true;
        } else if (checkfull(board, playerMark, compMark)) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i][0] + " |" + board[i][1] + " |" + board[i][2] + " |");

                if (i < 2) {
                    System.out.println("--------");
                }
            }
            System.out.println("Draw");
            win = "Draw";
            gameEnd = true;
        }

    }
}catch (InputMismatchException e){
    System.out.println("wrong input type ");
}catch (ArrayIndexOutOfBoundsException e){
    System.out.println(e.getMessage());
}catch (Exception e){
    System.out.println(e.getMessage());
}
        return win;
    }
}