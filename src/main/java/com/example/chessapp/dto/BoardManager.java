package com.example.chessapp.dto;

import java.util.*;

public class BoardManager {
    private int BOARD_SIZE = 12;

    private int[][] board;
    private int row;

    private List<Position> positions = new ArrayList<>();

    public BoardManager(int row) {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        this.row = row;
    }

    public boolean checkExist(int row, int col) {
        // проверяем, есть ли ферзь в том же ряду, что и
        // левый
        for (int x = 0; x < col; x++) {
            if (board[row][x] == 1) {
                return false;
            }
        }
        // проверяем, есть ли ферзь в левом верхнем углу
        // диагональ
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }

        // проверяем, есть ли ферзь слева внизу
        // диагональ
        for (int x = row, y = col; x < BOARD_SIZE && y >= 0; x++, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }

        // если ни в одном из вышеперечисленных нет ферзя
        // позиции, то можно смело ставить ферзя
        return true;
    }

    public boolean placeQueen(int col) {
        if (col == BOARD_SIZE) {
            return true;
        }

        // пробуем разместить ферзя в каждом ряду текущего
        // столбец
        for (int i = row; i < BOARD_SIZE; i++) {
            if (checkExist(i, col)) {
                board[i][col] = 1; // place the queen
                if (placeQueen(col + 1)) {
                    return true;
                }
                // возврат назад, если размещение ферзя не помогло
                // приводим к решению
                board[i][col] = 0;
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<Position> getQueensPosition() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    positions.add(new Position(i, j));
                }
            }
        }
        return positions;
    }
}