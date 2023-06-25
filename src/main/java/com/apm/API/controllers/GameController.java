package com.apm.API.controllers;

import com.apm.API.entities.Game;
import com.apm.API.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void editGame(@RequestBody Game game) throws Exception{
        gameService.editGame(game);
        
    }
    
     @DeleteMapping("/delete")
    public void deleteGame (@RequestParam Integer id) throws Exception {
        gameService.deleteGame(id);
    }
    
    
    @GetMapping("/getAll")
    public List<Game> getGames(){
    
     return  gameService.getGames();
    }
}
