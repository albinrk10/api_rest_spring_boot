package com.ahm.albin.apirest.model.dao;
import com.ahm.albin.apirest.model.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientDao extends CrudRepository<Client,Integer> {

}
