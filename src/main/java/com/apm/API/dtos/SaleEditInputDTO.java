/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apm.API.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class SaleEditInputDTO {

    private Integer id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate saleDate;

}
