package org.example.repo;

import org.example.entity.TravelArea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelAreaRepo extends CrudRepository<TravelArea,String> {
    List<TravelArea> findAll();
}
