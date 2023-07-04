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
import com.apm.API.dtos.GameDTO;
import com.apm.API.dtos.ScheduleDTO;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public void createGame(GameDTO game) {

        Game gameToCreate = new Game();
        gameToCreate.setName(game.getName());
        gameToCreate.setPrice(game.getPrice());
        gameRepository.save(gameToCreate);

        for (ScheduleDTO schedule : game.getSchedules()) {
            Schedule scheduleToCreate = new Schedule();
            scheduleToCreate.setInitialTime(schedule.getInitialTime());
            scheduleToCreate.setEndTime(schedule.getEndTime());
            scheduleToCreate.setGame(gameToCreate);
            scheduleRepository.save(scheduleToCreate);
        }

    }

    public void editGame(GameDTO gameDto) throws Exception {

        Game currentGame = gameRepository.findById(gameDto.getId()).orElse(null);

        if (currentGame == null) {
            throw new Exception("Game not found");
        }
        for (Schedule schedule : currentGame.getSchedules()) {
            scheduleRepository.deleteById(schedule.getId());
        }
        currentGame.getSchedules().clear();

        currentGame.setName(gameDto.getName());
        currentGame.setPrice(gameDto.getPrice());
        gameRepository.save(currentGame);

        
        for (ScheduleDTO schedule : gameDto.getSchedules()) {
            Schedule scheduleToCreate = new Schedule();
            scheduleToCreate.setInitialTime(schedule.getInitialTime());
            scheduleToCreate.setEndTime(schedule.getEndTime());
            scheduleToCreate.setGame(currentGame);
            scheduleRepository.save(scheduleToCreate);
        }

    }

    public void deleteGame(Integer id) throws Exception {
        if (gameRepository.findById(id).orElse(null) == null) {
            throw new Exception("Game not found");
        }
        gameRepository.deleteById(id);
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Game getById(Integer id) {
        return gameRepository.findById(id).orElse(null);
    }
}
