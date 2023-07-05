
package com.apm.API.repositories;

import com.apm.API.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository 
public interface SaleRepository extends JpaRepository<Sale, Integer>{

    //Cantidad de entradas vendidas en todos los juegos en una fecha determinada.        
    @Query(value = "SELECT count(t.sale_id) FROM sale s JOIN ticket t ON t.sale_id = s.id WHERE s.sale_date = '2023-07-06'"
            ,nativeQuery = true)
    public Integer getCountTicketsBySaleDate();
}
