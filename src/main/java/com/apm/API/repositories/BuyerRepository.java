
package com.apm.API.repositories;

import com.apm.API.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer>{
    
    
}
