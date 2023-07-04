package com.apm.API.dtos;

import com.apm.API.entities.Schedule;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameDTO implements Serializable{
    
    private Integer id;
    private String name;
   
    private List<ScheduleDTO> schedules;
    
    private Integer price;

    public GameDTO() {
    }

    public GameDTO(Integer id, String name, List<ScheduleDTO> schedules, Integer price) {
        this.id = id;
        this.name = name;
        this.schedules = schedules;
        this.price = price;
    }
    
    
}
