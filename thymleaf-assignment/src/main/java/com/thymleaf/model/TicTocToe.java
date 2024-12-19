package com.thymleaf.model;

import org.springframework.stereotype.Component;

@Component
public class TicTocToe {

    private char[][] board;
    private char currentPlayer;

    public TicTocToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    // Initialize the board with empty cells
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the board (for debugging)
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    // Check if the cell is empty
    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    // Place a mark on the board
    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (isCellEmpty(row, col)) {
                board[row][col] = currentPlayer;
                switchPlayer();
                return true;
            }
        }
        return false;
    }

    // Switch player turn
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check for a win
    public boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
