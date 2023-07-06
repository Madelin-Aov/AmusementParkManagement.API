package com.apm.API.repositories;

import com.apm.API.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    //Cantidad de entradas vendidas en todos los juegos en una fecha determinada.        
    @Query(value = "SELECT count(t.sale_id) FROM sale s JOIN ticket t ON t.sale_id = s.id WHERE s.sale_date = :date",
             nativeQuery = true)
    public Integer getCountTicketsBySaleDate(@Param("date") String date);

    //Cantidad de entradas vendidas para un determinado juego, en una fecha particular
    @Query(value = "SELECT count(t.sale_id) FROM sale s JOIN ticket t ON t.sale_id = s.id WHERE s.sale_date = :date and t.game_id = :game_id",
            nativeQuery = true)
    public Integer getCountTicketsByGameAndSaleDate(@Param("date") String date, @Param("game_id") Integer gameId);

    //Sumatoria total de los montos de ventas en un determinado día
    @Query(value = "SELECT SUM(s.total_price) FROM sale s WHERE DAYOFWEEK(s.sale_date)= :day ",
             nativeQuery = true)
    public Integer getSaleTotalPriceByDay(@Param("day") Integer day);
}
