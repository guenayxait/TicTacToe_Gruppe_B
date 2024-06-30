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

        assertTrue(TicTacToe.hasWinner());
    }

    @Test
    public void testhasWinner_columnWin(){
        // Set up winning condition in the first column
        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(1,0,'X');
        TicTacToe.board.place(2,0,'X');

        assertTrue(TicTacToe.hasWinner());
    }

    @Test
    public void testhasWinner_diagonalWin(){
        // Set up a winning condition in the main diagonal
        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(1,1,'X');
        TicTacToe.board.place(2,2,'X');

        assertTrue(TicTacToe.hasWinner());
    }

    @Test
    public void testhasWinner_antiDiagonalWin(){
        // Set up a winning condition in the anti-diagonal
        TicTacToe.board.place(0,2,'X');
        TicTacToe.board.place(1,1,'X');
        TicTacToe.board.place(2,0,'X');

        assertTrue(TicTacToe.hasWinner());
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

        assertFalse(TicTacToe.hasWinner());
    }

}