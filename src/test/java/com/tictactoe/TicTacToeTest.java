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


    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("com.tictactoe.TicTacToeTest");
    }
}