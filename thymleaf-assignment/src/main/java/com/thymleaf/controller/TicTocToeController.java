package com.thymleaf.controller;

import com.thymleaf.model.TicTocToe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class TicTocToeController {

    @Autowired
    private TicTocToe game;

    @GetMapping("/")
    public String showGame(Model model) {
        model.addAttribute("board", game.getBoard());
        model.addAttribute("currentPlayer", game.getCurrentPlayer());
        return "game";
    }

    @GetMapping("/move")
    public String makeMove(@RequestParam("row") int row, @RequestParam("col") int col, Model model) {
        if (game.placeMark(row, col)) {
            if (game.checkForWin()) {
                model.addAttribute("message", "Player " + (game.getCurrentPlayer() == 'X' ? 'O' : 'X') + " wins!");
                game.initializeBoard();
            }
        } else {
            model.addAttribute("message", "Invalid move, try again!");
        }
        return "redirect:/";
    }
}
