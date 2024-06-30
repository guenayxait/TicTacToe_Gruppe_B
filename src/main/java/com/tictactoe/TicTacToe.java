package com.tictactoe;

import java.util.Scanner; // Import the Scanner class

public class TicTacToe {
    // variables:
    static Player player1;
    static Player player2;
    static Player currentPlayer;
    static Board board;

    // Create Main Method
    public static void main(String[] args) {
        boolean gameOngoing = true;
        Scanner sc = new Scanner(System.in);
        String answer;

        while (gameOngoing) {
            start();
            System.out.println("Do you want to start a new game? (y/n)");
            answer = sc.nextLine();
            do {
                if (answer.equals("n")) {
                    gameOngoing = false;
                } else if (!answer.equals("y")) {
                    System.out.println("Invalid input");
                }
            } while (!answer.equals("n") && !answer.equals("y"));

        }


    }

    private static void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    static boolean hasWinner() {
        char check = currentPlayer.getMarker();

        //check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board.cells[i][0] == check && board.cells[i][1] == check && board.cells[i][2] == check) ||
                    (board.cells[0][i] == check && board.cells[1][i] == check && board.cells[2][i] == check)) {
                return true;
            }
        }

        //check diagonals
        return (board.cells[0][0] == check && board.cells[1][1] == check && board.cells[2][2] == check) ||
                (board.cells[0][2] == check && board.cells[1][1] == check && board.cells[2][0] == check);
    }

    public static void start() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();

        boolean gameOngoing = true;

        // print empty board
        board.print();

        Scanner scanner = new Scanner(System.in);
        int row;
        int col;

        // while loop
        while (gameOngoing) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            // get input from user
            System.out.print("row (0-2): ");
            row = scanner.nextInt();
            System.out.print("col (0-2): ");
            col = scanner.nextInt();
            // check if cell is empty
            if (board.isCellEmpty(row, col)) {
                // place marker on the board
                board.place(row, col, currentPlayer.getMarker());
                // print board
                board.print();
                // check if there is a winner
                if (hasWinner()) {
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    gameOngoing = false;
                }
                // check if board is full
                else if (board.isFull()) {
                    System.out.println("It's a tie!");
                    gameOngoing = false;
                }
                // switch current player
                switchCurrentPlayer();

            } else {
                System.out.println("Cell is not empty!");
            }
        }
    }



}