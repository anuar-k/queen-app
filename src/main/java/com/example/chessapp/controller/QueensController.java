package com.example.chessapp.controller;

import com.example.chessapp.dto.Position;
import com.example.chessapp.service.QueensService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QueensController {

    private final QueensService queensService;

    @PostMapping("/queens")
    public ResponseEntity<List<Position>> solveQueensProblem(@RequestBody Position position) {
        return ResponseEntity.ok(queensService.getQueens(position.getRow(), position.getCol()));
    }
}