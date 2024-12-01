package org.example.service.util;

import lombok.RequiredArgsConstructor;
import org.example.dto.MainTravelServiceDTO;
import org.example.dto.User;
import org.example.dto.UserDetails;
import org.example.entity.MainTravelServiceEntity;
import org.example.exception.NotFoundException;
import org.example.repo.MainTravelServiceRepo;
import org.example.repo.PackageRepo;
import org.example.service.MainTravelService;
import org.example.util.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MainTravelServiceIMPL implements MainTravelService {

    private final Converter converter;

    private final MainTravelServiceRepo mainTravelServiceRepo;
    private final PackageRepo packageRepo;


   /* private final WebClient webClient;*/
   private final WebClient.Builder webClientBuilder;



  /*  public User getFullProfile(UserDetails userDTO, String userName){
        WebClient userClient = webClientBuilder.baseUrl("http://localhost:9095/User/api/v1/user").build();
        Mono<User> userDetailsMono = userClient.get()
                .uri("/getUserByUsername?username=" + userName)
                .retrieve()
                .bodyToMono(User.class);

        User userDetails = userDetailsMono.block();
        System.out.println(userDetails + "*-**-*-*--*");
          return userDetails;
    }*/

    @Override
    public MainTravelServiceDTO saveService(MainTravelServiceDTO serviceDTO) {
     return converter.toServiceDto(mainTravelServiceRepo.save(converter.toServiceEntity(serviceDTO)));
    }

    @Override
    public MainTravelServiceDTO getSelectService(String service_id) {
        Optional<MainTravelServiceEntity> byId = mainTravelServiceRepo.findById(service_id);
        if (byId.isEmpty()){
            throw  new NotFoundException("Service ID Not Found :"+service_id);
        }
        return converter.toServiceDto(byId.get());
    }

    @Override
    public void updateService(String service_id,MainTravelServiceDTO serviceDTO) {
        Optional<MainTravelServiceEntity> byId = mainTravelServiceRepo.findById(service_id);
        if (byId.isEmpty()){
            throw  new NotFoundException("Service ID Not Found :"+service_id);
        }
        MainTravelServiceEntity  travelService=byId.get();
        travelService.setStart_date(serviceDTO.getStart_date());
        travelService.setEnd_date(serviceDTO.getEnd_date());
        travelService.setNo_of_adult(serviceDTO.getNo_of_adult());
        travelService.setNo_of_child(serviceDTO.getNo_of_child());
        /*travelService.setWithGuide(serviceDTO.isWith_guide_or_no());*/
        travelService.setTotal_hed_count((serviceDTO.getTotal_hed_count()));
        travelService.setUser_package_start_date(serviceDTO.getUser_package_start_date());
        travelService.setPackage_total(serviceDTO.getPackage_total());
        travelService.setUser(serviceDTO.getUser_id());
        travelService.setVehicle_id(serviceDTO.getVehicle_id());
        travelService.setHotel_id(serviceDTO.getHotel_id());
        travelService.setArea(serviceDTO.getArea());
        travelService.setTravelPackage(serviceDTO.getTravelPackage());

      mainTravelServiceRepo.save(travelService);
    }

    @Override
    public void deleteService(String service_id) {
        Optional<MainTravelServiceEntity> byId = mainTravelServiceRepo.findById(service_id);
        if (byId.isEmpty()){
            throw  new NotFoundException("Service ID Not Found :"+service_id);
        }
        mainTravelServiceRepo.deleteById(service_id);
    }

    @Override
    public List<MainTravelServiceDTO> getAllMainTravel() {
        return mainTravelServiceRepo.findAll().stream().map(service->converter.toServiceDto(service)).collect(Collectors.toList());
    }

    @Override
    public UserDetails getFulProfile(UserDetails userDetails) {
        return null;
    }

    /*@Override
    public UserDetails getFulProfile(UserDetails userDetails) {
        MainTravelServiceEntity service=mainTravelServiceRepo.findByUser_id(userDetails.getUser_id());

        userDetails.setTravelId(service.getService_id());
        *//*userDTO.se*//*
        System.out.println(userDetails.getUser_id() + "kikikk ");

        return userDetails;
    }*/
}
