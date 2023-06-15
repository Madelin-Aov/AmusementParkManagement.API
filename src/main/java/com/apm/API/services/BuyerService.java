
package com.apm.API.services;

import com.apm.API.entities.Buyer;
import com.apm.API.repositories.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;
    public void createBuyer(Buyer buyer){
    buyerRepository.save(buyer);
    
    }
}
