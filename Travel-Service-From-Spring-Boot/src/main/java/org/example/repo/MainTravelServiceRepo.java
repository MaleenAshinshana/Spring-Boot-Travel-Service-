package org.example.repo;

import org.example.entity.MainTravelServiceEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*@Repository*/
@Repository
public interface MainTravelServiceRepo extends CrudRepository<MainTravelServiceEntity,String> {
//    MainTravelServiceEntity save(MainTravelServiceEntity travelService);
//    MainTravelServiceEntity getMainTravelServiceEntitiesByiAndService_id(String service_id);
//    void deleteMainTravelServiceEntitiesByService_id(String service_id);
    List<MainTravelServiceEntity> findAll();
   /* MainTravelServiceEntity findByUse_Id(String userName);*/
    /*MainTravelServiceEntity  findByUser_id(String userId);*/
     /*MainTravelServiceEntity findByUserId(String userId);*/
    /*MainTravelServiceEntity findByUser_id(String userId);*/
    /*MainTravelServiceEntity findByUser(String user);*/



}
