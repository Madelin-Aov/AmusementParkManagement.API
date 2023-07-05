package com.apm.API.services;

import com.apm.API.repositories.SaleRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private SaleRepository saleRepository;
    
    public Integer getCountTicketsBySaleDate(Date date){
        return saleRepository.getCountTicketsBySaleDate();
    }
}
