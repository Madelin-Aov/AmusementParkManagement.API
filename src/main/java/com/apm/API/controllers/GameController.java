package com.apm.API.controllers;

import com.apm.API.entities.Buyer;
import com.apm.API.services.BuyerService;
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
    private GameService gameService;

    @PostMapping("/create")
    public void createBuyer(@RequestBody Buyer buyer) {
        gameService.createBuyer(buyer);

    }

    @PutMapping("/edit")
    public void editBuyer(@RequestBody Buyer buyer) throws Exception {
        gameService.editBuyer(buyer);
    }

    @DeleteMapping("/delete")
    public void deleteBuyer(@RequestParam Integer id) throws Exception {
        gameService.deleteBuyer(id);
    }
    
    @GetMapping("/getAll")
    public List<Buyer> getGame(){
    
     return  gameService.getGame();
    }
}


