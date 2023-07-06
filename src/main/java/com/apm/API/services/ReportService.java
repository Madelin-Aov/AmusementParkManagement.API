package com.apm.API.services;

import com.apm.API.repositories.SaleRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private SaleRepository saleRepository;

    public Integer getCountTicketsBySaleDate(String date) {
        return saleRepository.getCountTicketsBySaleDate(date);
    }

    public Integer getCountTicketsByGameAndSaleDate(String date, Integer gameId) {
        return saleRepository.getCountTicketsByGameAndSaleDate(date, gameId);
    }

    public Integer getSaleTotalPriceByDay(Integer day) {
        return saleRepository.getSaleTotalPriceByDay(day);
    }

    public Integer getSaleTotalPriceByMonthAndYear(Integer day, Integer year) {
        return saleRepository.getSaleTotalPriceByMonthAndYear(day, year);
    }

}
