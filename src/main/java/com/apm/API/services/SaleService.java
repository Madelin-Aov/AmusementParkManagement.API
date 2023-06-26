
package com.apm.API.services;

import com.apm.API.entities.Sale;
import com.apm.API.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    public void createSale(Sale sale){
     saleRepository.save(sale);
    
    }
    
     public void deleteSale(Integer id) throws Exception {
        if (saleRepository.findById(id).orElse(null) == null) {
            throw new Exception("Sale not found");
        }
        saleRepository.deleteById(id);

    }
     
    
}
