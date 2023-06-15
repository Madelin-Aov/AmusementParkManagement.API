
package com.apm.API.controllers;

import com.apm.API.entities.Buyer;
import com.apm.API.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @PostMapping("/buyer")
    public void createBuyer(@RequestBody Buyer buyer){
        buyerService.createBuyer(buyer);
    
    }
}
