package org.example.repo;

import org.example.entity.Travel_area_image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelAreaImageRepo extends CrudRepository<Travel_area_image,String> {
    List<Travel_area_image> findAll();
}
