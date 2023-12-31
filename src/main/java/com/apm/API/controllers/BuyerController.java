package com.apm.API.controllers;

import com.apm.API.entities.Buyer;
import com.apm.API.services.BuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    public void createBuyer(@RequestBody Buyer buyer) {
        buyerService.createBuyer(buyer);

    }

    @PutMapping("/edit")
    public void editBuyer(@RequestBody Buyer buyer) throws Exception {
        buyerService.editBuyer(buyer);
    }

    @DeleteMapping("/delete")
    public void deleteBuyer(@RequestParam Integer id) throws Exception {
        buyerService.deleteBuyer(id);
    }
    
    @GetMapping("/getAll")
    public List<Buyer> getBuyer(){
    
     return  buyerService.getBuyer();
    }
    
    
    
}
