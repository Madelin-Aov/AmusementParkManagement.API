package com.apm.API.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import java.time.LocalTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonFormat(pattern="HH")
    private LocalTime initialTime;
     @JsonFormat(pattern="HH")
    private LocalTime endTime;
    @ManyToOne()
    @JoinColumn(name="game_id")
    private Game game;

    public Schedule() {
    }

    public Schedule(Integer id, LocalTime initialTime, LocalTime endTime, Game game) {
        this.id = id;
        this.initialTime = initialTime;
        this.endTime = endTime;
        this.game = game;
    }
    
    
}
