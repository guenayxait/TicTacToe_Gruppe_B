package com.tictactoe;

import java.util.Scanner; // Import the Scanner class

public class TicTacToe {
    // variables:
    static Player player1 = new Player('X');
    static Player player2 = new Player('O');
    static Player currentPlayer = player1;
    static Board board = new Board();

    // Create Main Method
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        //game.start();

        System.out.println("Current Player: " + currentPlayer.getMarker());

        // print empty board
        board.print();
        // while loop
        while (true) {
            // get input from user
            System.out.println("row (0-2): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            System.out.println("col (0-2): ");
            int col = scanner.nextInt();
            // check if cell is empty
            if (board.isCellEmpty(row, col)) {
                // place marker on the board
                board.place(row, col, currentPlayer.getMarker());
                // print board
                board.print();
                // check if there is a winner
                if (hasWinner()) {
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }
                // check if board is full
                if (board.isFull()) {
                    System.out.println("It's a tie!");
                    break;
                }
                // switch current player
                switchCurrentPlayer();
                System.out.println("Current Player: " + currentPlayer.getMarker());
            } else {
                System.out.println("Cell is not empty!");
            }
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

    //private void start() {}



}