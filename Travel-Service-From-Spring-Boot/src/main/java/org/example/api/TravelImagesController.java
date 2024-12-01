package org.example.api;

import jakarta.validation.Valid;
import org.example.dto.TravelAreaImageDTO;
import org.example.service.TravelAreaImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/areaImage")
@CrossOrigin("*")
public class TravelImagesController {
    private final TravelAreaImageService  service;

    public TravelImagesController(TravelAreaImageService service) {
        this.service = service;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{area_id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
     public TravelAreaImageDTO imageDTO(
            @RequestPart List<MultipartFile> area_image,
            @PathVariable String area_id
            ){
        List<byte []> areaImageData=new ArrayList<>();
        for (MultipartFile  image:area_image) {
            TravelAreaImageDTO imageDTO=new TravelAreaImageDTO();
            try {
                imageDTO.setArea_image(image.getBytes());
            } catch (IOException e) {
               e.printStackTrace();
            }
            return service.saveImage(area_id,imageDTO);
        }
        return null;
    }
    @GetMapping(value = "/{image_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TravelAreaImageDTO> getSelectedTravel(@Valid @PathVariable String image_id){
        TravelAreaImageDTO imageDTO=service.getSelectedImage(image_id);
        return new ResponseEntity<>(imageDTO,HttpStatus.OK);
    }
    @DeleteMapping(value = "/{image_id}")
    void deleteAreaImage(@Valid @PathVariable String image_id){
        service.deleteImage(image_id);
    }
    @PatchMapping(value = "/{image_id}")
    public String updateHotelImage(
            @RequestPart List<MultipartFile> area_image,

            @PathVariable String image_id) {
        List<byte[]> AreaImagesData = new ArrayList<>();

        /*String VImag= Base64.getEncoder().encodeToString(vehicle_image);*/
        for (MultipartFile image : area_image) {
            TravelAreaImageDTO imageDTO = new TravelAreaImageDTO();
            try {
                imageDTO.setArea_image(image.getBytes());
               /* byte[] imageData = image.getBytes();
                vehicleImagesData.add(imageData);*/
            } catch (IOException e) {
                e.printStackTrace();
            }
            service.updateImage(image_id, imageDTO);

        }
        return "Updated";
    }
    @GetMapping
    public ResponseEntity<List<TravelAreaImageDTO>> getAllImages() {
        List<TravelAreaImageDTO> dto = service.gelAllImage();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
