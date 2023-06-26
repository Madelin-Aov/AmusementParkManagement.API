package com.apm.API.services;

import com.apm.API.entities.Buyer;
import com.apm.API.repositories.BuyerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public void createBuyer(Buyer buyer) {
        buyerRepository.save(buyer);

    }

    public void editBuyer(Buyer buyer) throws Exception {
        if (buyerRepository.findById(buyer.id).orElse(null) == null) {
            throw new Exception("Buyer not exist");
        }
        buyerRepository.save(buyer);

    }

    public void deleteBuyer(Integer id) throws Exception {
        if (buyerRepository.findById(id).orElse(null) == null) {
            throw new Exception("Buyer not found");
        }
        buyerRepository.deleteById(id);

    }

  
    public List<Buyer> getBuyer() {
        return buyerRepository.findAll();
    }
    
    
    public Buyer getBuyerById(Integer id){
    
        return buyerRepository.findById(id).orElse(null);
    }

}
