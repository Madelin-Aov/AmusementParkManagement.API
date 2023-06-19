package com.apm.API.services;

import com.apm.API.entities.Buyer;
import com.apm.API.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public void createBuyer(Buyer buyer) {
        gameRepository.save(buyer);

    }

    public void editBuyer(Buyer buyer) throws Exception {
        if (gameRepository.findById(buyer.id).orElse(null) == null) {
            throw new Exception("Game not found");
        }
        gameRepository.save(buyer);

    }

    public void deleteBuyer(Integer id) throws Exception {
        if (gameRepository.findById(id).orElse(null) == null) {
            throw new Exception("Game not found");
        }
        gameRepository.deleteById(id);
    }
}
