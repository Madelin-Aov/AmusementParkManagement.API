package com.apm.API.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
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
public class Schedule implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer initialTime;
    private Integer endTime;
    @ManyToOne()
    @JoinColumn(name="game_id")
    @JsonBackReference
    private Game game;

    public Schedule() {
    }

    public Schedule(Integer id, Integer initialTime, Integer endTime, Game game) {
        this.id = id;
        this.initialTime = initialTime;
        this.endTime = endTime;
        this.game = game;
    }
    
    
}
