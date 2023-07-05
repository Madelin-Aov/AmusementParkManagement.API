package com.apm.API.controllers;

import com.apm.API.dtos.SaleDTO;
import com.apm.API.entities.Sale;
import com.apm.API.services.SaleService;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sale")

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/create")
    public void createSale(@RequestBody SaleDTO saleDto) {
        saleService.createSale(saleDto);
    }

    @DeleteMapping("/delete")
    public void deleteSale(@RequestParam Integer id) throws Exception {
        saleService.deleteSale(id);
    }

    @GetMapping("/getAll")
    public List<Sale> getGames() {

        return saleService.getSales();
    }

    @PutMapping("/editDate")
    public void editDate(@RequestBody LocalDate saleDate, @RequestBody Integer id) throws Exception {
        saleService.editDate(saleDate, id);
    }
}
