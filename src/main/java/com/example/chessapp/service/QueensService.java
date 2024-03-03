package com.example.chessapp.service;

import com.example.chessapp.dto.BoardManager;
import com.example.chessapp.dto.Position;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QueensService {

    private BoardManager boardManager = null;

    public List<Position> getQueens(int row, int col) {
        boardManager = new BoardManager(row);
        boardManager.placeQueen(col);
        boardManager.printBoard();

        return boardManager.getQueensPosition();
    }
}
