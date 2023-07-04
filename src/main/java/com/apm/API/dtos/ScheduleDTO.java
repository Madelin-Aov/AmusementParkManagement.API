/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apm.API.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sebastian
 */
@Setter @Getter
public class ScheduleDTO {
    
    private Integer id;
    private Integer initialTime;
    private Integer endTime;

    public ScheduleDTO() {
    }
    public ScheduleDTO(Integer id, Integer initialTime, Integer endTime) {
        this.id = id;
        this.initialTime = initialTime;
        this.endTime = endTime;
    }
    
    
}
