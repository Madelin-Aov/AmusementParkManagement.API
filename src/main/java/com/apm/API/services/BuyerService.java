package com.apm.API.services;

import com.apm.API.entities.Buyer;
import com.apm.API.repositories.BuyerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;
    
    /**
     * Método para crear objetos Buyer(comprador).
     *Para guardar se utiliza la interfaz de JPA Repository y su método .save luego de recibir 
     *el objeto en formato JSON.
     */
    public void createBuyer(Buyer buyer) {
        buyerRepository.save(buyer);

    }

    /**
     * Método para editar los atributos del objeto Buyer(comprador), recibido como parametro.
     * Antes de guardar el objeto se verifica que exista un objeto con el número de Id del parametro.
     * Para guardar se utiliza la interfaz de JPA Repository y su método .save().    
     */
    public void editBuyer(Buyer buyer) throws Exception {
        if (buyerRepository.findById(buyer.id).orElse(null) == null) {
            throw new Exception("Buyer not exist");
        }
        buyerRepository.save(buyer);

    }
     /**
     * Método para eliminar un objeto Buyer(comprador), usando el Id como parametro.
     * Para eliminar el objeto primero se comprueba que exista el comprador y lanza una excepcion
     * de no ser así. Finalmente con la interfaz de JPA .delete() elimina el objeto de dicho ID.   
     */
    public void deleteBuyer(Integer id) throws Exception {
        if (buyerRepository.findById(id).orElse(null) == null) {
            throw new Exception("Buyer not found");
        }
        buyerRepository.deleteById(id);

    }
     /**
     * Método para obtener los datos de todos los objetos Buyer(comprador) guardados en la DB.
     * Usando la interfaz de JPA .findAll().
     */
    public List<Buyer> getBuyer() {
        return buyerRepository.findAll();
    }
    
    /**
     * Método para obtener un objeto Buyer(comprador) en la DB usando su ID como parametro.
     * Para eliminarlo se utiliza la interfaz de JPA Repository y su método .findById().   
     */
    public Buyer getBuyerById(Integer id) {

        return buyerRepository.findById(id).orElse(null);
    }

}
