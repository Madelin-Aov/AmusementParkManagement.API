package com.apm.API.services;

import com.apm.API.entities.Buyer;
import com.apm.API.entities.Game;
import com.apm.API.entities.Schedule;
import com.apm.API.repositories.GameRepository;
import com.apm.API.repositories.ScheduleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public void createGame(Game game) {
         
        gameRepository.save(game);
        
        for (Schedule schedule : game.getSchedules()) {
            schedule.setGame(game);
            scheduleRepository.save(schedule);
        }
        
      
        
    }

    public void editGame(Game game) throws Exception {
        if (gameRepository.findById(game.getId()).orElse(null) == null) {
            throw new Exception("Game not found");
        }
        gameRepository.save(game);

    }

    public void deleteGame(Integer id) throws Exception {
        if (gameRepository.findById(id).orElse(null) == null) {
            throw new Exception("Game not found");
        }
        gameRepository.deleteById(id);
    }
    
    @GetMapping
    public List<Game> getGames() {
        return gameRepository.findAll();
    }
}
