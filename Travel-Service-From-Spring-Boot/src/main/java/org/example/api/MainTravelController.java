package org.example.api;

import jakarta.validation.Valid;
import org.example.dto.*;
import org.example.service.MainTravelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
@CrossOrigin("*")
public class MainTravelController {
    private final WebClient.Builder  webClientBuilder;
    private final ExchangeStrategies exchangeStrategies;
    private  final MainTravelService travelService;

    /*public MainTravelController(MainTravelService travelService) {
        this.travelService = travelService;
    }*/

    /*@Value("http://localhost:9095/User/api/v1/user/")
        private String customerDAtaEndPoint;*/
    public MainTravelController(WebClient.Builder webClientBuilder,MainTravelService travelService) {
        this.webClientBuilder = webClientBuilder;
        this.exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                .build();
        this.travelService = travelService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    MainTravelServiceDTO saveTravel(@Valid @RequestBody MainTravelServiceDTO serviceDTO, Errors errors){
        System.out.println(serviceDTO);
        return travelService.saveService(serviceDTO);
    }
    @GetMapping(value = "/{travel_id}")
    ResponseEntity<MainTravelServiceDTO> getTravel(@Valid @PathVariable String travel_id){
        MainTravelServiceDTO serviceDTO=travelService.getSelectService(travel_id);

        return new ResponseEntity<>(serviceDTO,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{travel_id}")
    void deleteTravel(@Valid @PathVariable String travel_id){
    travelService.deleteService(travel_id);
    }
    @PatchMapping(value = "/{travel_id}")
    void updateTravel(@Valid @PathVariable String travel_id,@RequestBody MainTravelServiceDTO serviceDTO){
        travelService.updateService(travel_id,serviceDTO);

    }
    @GetMapping
    public ResponseEntity<List<MainTravelServiceDTO>> getAllGuide() {
        List<MainTravelServiceDTO> dto = travelService.getAllMainTravel();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    /*private <T> Mono<T> makeWebClientRequest(String baseUrl, String path, Class<T> responseClass, String id) {
        WebClient webClient = webClientBuilder.baseUrl(baseUrl + path + id)
                .exchangeStrategies(exchangeStrategies)
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(responseClass);
    }

    @GetMapping("/user")
    public UserDetails getUser(@RequestParam String userId) {
        return makeWebClientRequest("http://localhost:9095/User/api/v1/user/", "", UserDetails.class, userId).block();
    }

    @GetMapping("/guide")
    public GuideDetails getGuide(@RequestParam String guideId) {
        return makeWebClientRequest("http://localhost:9092/Guide/api/v1/guide/", "", GuideDetails.class, guideId).block();
    }

    @GetMapping("/vehicle")
    public VehicleDetails getVehicle(@RequestParam String vehicleId) {
        return makeWebClientRequest("http://localhost:8080/vehicle/api/v1/vehicle/", "", VehicleDetails.class, vehicleId).block();
    }

    @GetMapping("/vehicleImage")
    public VehicleImageDetails getVehicleImage(@RequestParam String vehicleImageId) {
        return makeWebClientRequest("http://localhost:8080/vehicle/api/v1/vehicleImage/", "", VehicleImageDetails.class, vehicleImageId).block();
    }

    @GetMapping("/hotel")
    public HotelDetails getHotel(@RequestParam String hotelId) {
        return makeWebClientRequest("http://localhost:8086/hotel/api/v1/hotel/", "", HotelDetails.class, hotelId).block();
    }

    @GetMapping("/hotelImage")
    public HotelImageDetails getHotelImage(@RequestParam String hotelImageId) {
        return makeWebClientRequest("http://localhost:8086/hotel/api/v1/hotelImage/", "", HotelImageDetails.class, hotelImageId).block();
    }*/


   /* @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    UserDetails getFulProfile(@RequestParam String userId){
        WebClient webClient=WebClient.create(customerDAtaEndPoint+userId);
        System.out.println(userId+ "msdlakcjjvcp");
        return (UserDetails) webClient;
        Mono<UserDetails> userDTOMono=webClient.get().retrieve().bodyToMono(UserDetails.class);
        return travelService.getFulProfile(userDTOMono.block());
    }*/
    @RequestMapping("/user")
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails getFullProfile(@RequestParam String userId) {
        WebClient webClient = WebClient.create("http://localhost:9095/User/api/v1/user/" + userId);
        System.out.println(userId );

        Mono<UserDetails> userDetailsMono = webClient.get().retrieve().bodyToMono(UserDetails.class);
        UserDetails user = userDetailsMono.block();
        return  user;
    }
  /*  @RequestMapping("/guide")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)*/
    /*@GetMapping("/guides")
    public Flux<GuideDetails> getAllGuides() {
        return makeWebClientRequest("http://localhost:9092/Guide/api/v1/guide/", "", GuideDetails.class);
    }*/
    /*public GuideDetails getGuideProfile(@RequestParam String guideId) {
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)) // Set the max buffer size to 10MB
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .baseUrl("http://localhost:9092/Guide/api/v1/guide/"+guideId)
                .build();


        Mono<GuideDetails>  guideDetailsMono = webClient.get().retrieve().bodyToMono(GuideDetails.class);
        GuideDetails guide = guideDetailsMono.block();
        return guide;

    }*/
    /*private <T> Flux<T> makeWebClientRequest(String baseUrl, String path, Class<T> responseClass) {
        WebClient webClient = webClientBuilder.baseUrl(baseUrl + path)
                .exchangeStrategies(exchangeStrategies)
                .build();

        return webClient.get()
                .retrieve()
                .bodyToFlux(responseClass);
    }*/

    /*All Guides*/
  private <T> Flux<T> makeWebClientRequest(String baseUrl, String path, Class<T> responseClass) {
      WebClient webClient = webClientBuilder.baseUrl(baseUrl + path)
              .exchangeStrategies(exchangeStrategies)
              .build();

      return webClient.get()
              .retrieve()
              .bodyToFlux(responseClass);
  }

    @GetMapping("/guides")
    public Flux<GuideDetails> getAllGuides() {
        return makeWebClientRequest("http://localhost:9092/Guide/api/v1/guide", "", GuideDetails.class);
    }

    @RequestMapping("/vehicle")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleDetails getVehicle(@RequestParam String vehicleId) {
        ExchangeStrategies build = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)) // Set the max buffer size to 10MB
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(build)
                .baseUrl("http://localhost:8080/vehicle/api/v1/vehicle/"+vehicleId)
                .build();


        Mono<VehicleDetails>  vehicleDetailsMono = webClient.get().retrieve().bodyToMono(VehicleDetails.class);
        VehicleDetails vehicleDetails = vehicleDetailsMono.block();
        return vehicleDetails;

    }
    @RequestMapping("/vehicleImage")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleImageDetails getVehicleImage(@RequestParam String vehicleImageId) {
        ExchangeStrategies build = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)) // Set the max buffer size to 10MB
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(build)
                .baseUrl("http://localhost:8080/vehicle/api/v1/vehicleImage/"+vehicleImageId)
                .build();


        Mono<VehicleImageDetails>  imageDetails = webClient.get().retrieve().bodyToMono(VehicleImageDetails.class);
        VehicleImageDetails vehicleDetails =imageDetails.block();
        return vehicleDetails;

    }
    @RequestMapping("/hotel")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelDetails getHotel(@RequestParam String hotelId) {
        ExchangeStrategies build = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)) // Set the max buffer size to 10MB
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(build)
                .baseUrl("http://localhost:8086/hotel/api/v1/hotel/"+hotelId)
                .build();


        Mono<HotelDetails>  hotelDetailsMono = webClient.get().retrieve().bodyToMono(HotelDetails.class);
        HotelDetails hotelDetails =hotelDetailsMono.block();
        return hotelDetails;

    }
    @RequestMapping("/hotelImage")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelImageDetails getHotelImage(@RequestParam String hotelImageId) {
        ExchangeStrategies build = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)) // Set the max buffer size to 10MB
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(build)
                .baseUrl("http://localhost:8086/hotel/api/v1/hotelImage/"+hotelImageId)
                .build();


        Mono<HotelImageDetails>  imageDetails = webClient.get().retrieve().bodyToMono(HotelImageDetails.class);
        HotelImageDetails imageDetails1 =imageDetails.block();
        return imageDetails1;

    }






}
