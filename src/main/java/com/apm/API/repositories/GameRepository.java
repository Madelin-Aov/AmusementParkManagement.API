
package com.apm.API.repositories;

import com.apm.API.entities.Buyer;
import com.apm.API.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{
    
    
}
