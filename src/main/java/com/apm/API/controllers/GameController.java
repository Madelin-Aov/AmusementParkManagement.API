package com.apm.API.controllers;

import com.apm.API.entities.Game;
import com.apm.API.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/game")

@RestController
public class GameController {
    
    @Autowired
    GameService gameService;
    
    @PostMapping("/create")
    public void createGame(@RequestBody Game game) {
        gameService.createGame(game);

    }

    @PutMapping("/edit")
    public void editGame(@RequestBody Game game){
        
    }
}
