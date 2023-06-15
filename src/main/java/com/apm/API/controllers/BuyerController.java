
package com.apm.API.controllers;

import com.apm.API.entities.Buyer;
import com.apm.API.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/buyer")

@RestController
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @PostMapping("/create")
    public void createBuyer(@RequestBody Buyer buyer){
        buyerService.createBuyer(buyer);
    
    }
    
    @PutMapping("/edit")
    public void editBuyer (@RequestBody Buyer buyer) throws Exception {
           buyerService.editBuyer(buyer);
}
    
}
