package com.tictactoe;
public class Board {
    char[][] cells;

    // constructor for Board
    public Board() {
        cells = new char[3][3];
        clear();
    }

    // check if cell is empty
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }


    // place marker on the board,  void place(int x, int y, char marker)
    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    // boolean isFull()
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    // void clear()
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }
    // void print()
    public void print() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }

}
