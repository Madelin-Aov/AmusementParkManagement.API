package com.apm.API.controllers;

import com.apm.API.services.ReportService;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportervice;

    @GetMapping("/getCountTicketsBySaleDate")
    public Integer getCountTicketsBySaleDate(@RequestParam("date") String date) {
        return reportervice.getCountTicketsBySaleDate(date);
    }

    @GetMapping("/getCountTicketsByGameAndSaleDate")
    public Integer getCountTicketsByGameAndSaleDate(@RequestParam("date") String date, @RequestParam("gameId") Integer gameId) {
        return reportervice.getCountTicketsByGameAndSaleDate(date, gameId);
    }

    @GetMapping("/getSaleTotalPriceByDay")
    public Integer getSaleTotalPriceByDay(@RequestParam("day") Integer day) {
        return reportervice.getSaleTotalPriceByDay(day);
    }

}
