package com.tictactoe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TicTacToeTest {
    @Test
    public void testIsCellEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
        assertTrue(board.isCellEmpty(2, 2));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    public void testSwitchCurrentPlayer() {
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        Player currentPlayer = player1;
        assertEquals(player1, currentPlayer);
        currentPlayer = player2;
        assertEquals(player2, currentPlayer);
    }

    @Test
    public void testHasWinner_rowWin() {
        // Set up a winning condition in the first column
        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(0,1,'X');
        TicTacToe.board.place(0,2,'X');

        assertTrue(TicTacToe.hasWinner('X'));
    }

    @Test
    public void testhasWinner_columnWin(){
        // Set up winning condition in the first column
        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(1,0,'X');
        TicTacToe.board.place(2,0,'X');

        assertTrue(TicTacToe.hasWinner('X'));
    }

    @Test
    public void testhasWinner_diagonalWin(){
        // Set up a winning condition in the main diagonal
        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(1,1,'X');
        TicTacToe.board.place(2,2,'X');

        assertTrue(TicTacToe.hasWinner('X'));
    }

    @Test
    public void testhasWinner_antiDiagonalWin(){
        // Set up a winning condition in the anti-diagonal
        TicTacToe.board.place(0,2,'X');
        TicTacToe.board.place(1,1,'X');
        TicTacToe.board.place(2,0,'X');

        assertTrue(TicTacToe.hasWinner('X'));
    }

    @Test
    public void testHasWinner_noWin(){
        // Set up a condition with no winner
        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(0,1,'O');
        TicTacToe.board.place(0,2,'X');
        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(0,1,'O');
        TicTacToe.board.place(0,2,'O');
        TicTacToe.board.place(0,0,'O');
        TicTacToe.board.place(0,1,'X');
        TicTacToe.board.place(0,2,'O');

        assertFalse(TicTacToe.hasWinner('X') && TicTacToe.hasWinner('O'));
    }


    // #####################
    // #####PLAYER CLASS####
    // #####################

    @Test
    public void testPlayerConstructor() {
        Player player = new Player('O');

        assertEquals(
                player.getClass(),
                Player.class
        );
    }

    @Test
    public void testPlayerInitialization() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
        player = new Player('O');
        assertEquals('O', player.getMarker());
    }

    @Test
    public void testGetMarker() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
        player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    // #####################
    // #### BOARD CLASS ####
    // #####################


    // Board()
    @Test
    public void testBoardConstructorClass() {
        Board board = new Board();

        assertEquals(
                board.getClass(),
                Board.class
        );
    }

    @Test
    public void testBoardInitialization() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));    // All cells should be empty upon board initialization
            }
        }
    }

    // Board.isCellEmpty()
    @Test
    public void testIsCellEmptyTrue() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(1, 1));    // Cell (1, 1) should be empty initially
    }

    @Test
    public void testIsCellEmptyFalse() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));   // Cell (1, 1) should not be empty after placing a marker
    }

    // Board.place()
    @Test
    public void testPlaceMarker() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));   // Cell (0, 0) should not be empty after placing a marker
        assertEquals('X', board.cells[0][0]);   // Cell (0, 0) should contain marker 'X'
    }

    // Board.isFull()
    @Test
    public void testIsFullTrue() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());             // Board should be full after all cells are filled
    }

    @Test
    public void testIsFullFalse() {
        Board board = new Board();
        assertFalse(board.isFull());            // Board should not be full initially
        board.place(0, 0, 'X');
        assertFalse(board.isFull());            // Board should not be full if at least one cell is empty
    }

    // Board.clear()
    @Test
    public void testClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));    // All cells should be empty after clearing the board
            }
        }
    }




}