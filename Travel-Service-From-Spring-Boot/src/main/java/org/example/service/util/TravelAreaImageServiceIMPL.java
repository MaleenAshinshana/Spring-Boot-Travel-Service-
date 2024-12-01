package org.example.service.util;

import lombok.RequiredArgsConstructor;
import org.example.dto.TravelAreaImageDTO;
import org.example.entity.TravelArea;
import org.example.entity.Travel_area_image;
import org.example.exception.NotFoundException;
import org.example.repo.TravelAreaImageRepo;
import org.example.repo.TravelAreaRepo;
import org.example.service.TravelAreaImageService;
import org.example.util.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TravelAreaImageServiceIMPL implements TravelAreaImageService {

    private final Converter converter;
    private final TravelAreaRepo areaRepo;
    private final TravelAreaImageRepo  imageRepo;
    @Override
    public TravelAreaImageDTO saveImage(String area_id,TravelAreaImageDTO imageDTO) {
        TravelArea travelArea = areaRepo.findById(area_id).orElseThrow();
        Travel_area_image areaImageEntity = converter.toAreaImageEntity(imageDTO);
        areaImageEntity.setTravelArea(travelArea);
        TravelAreaImageDTO imageDto = converter.toImageDto(imageRepo.save(areaImageEntity));


        return imageDto;
    }

    @Override
    public TravelAreaImageDTO getSelectedImage(String image_id) {
        Travel_area_image travelAreaImage = imageRepo.findById(image_id).orElseThrow(() -> new NotFoundException("Area ID Is Not Found :" + image_id));
        TravelAreaImageDTO imageDto = converter.toImageDto(travelAreaImage);
        imageDto.setTravelArea(travelAreaImage.getTravelArea().getArea_id());
        imageDto.setArea_image(travelAreaImage.getArea_image().getBytes());

        System.out.println(imageDto.getArea_image() + "Awa ");

        return imageDto;
        /*Travel_area_image travelAreaImage = imageRepo.findById(image_id).orElseThrow(() -> new NotFoundException("Area Image Id Bot Found :" + image_id));

        TravelAreaImageDTO imageDto = converter.toImageDto(travelAreaImage);
        imageDto.setTravelArea(travelAreaImage.getTravelArea().getArea_id());
        byte []image=travelAreaImage.getArea_image().getBytes();
        if (image!=null){
            imageDto.setArea_image(image);
        }



        return imageDto;*/
    }

    @Override
    public void updateImage(String image_id, TravelAreaImageDTO imageDTO) {
        Optional<Travel_area_image> byId = imageRepo.findById(image_id);
        if (byId.isEmpty()){
            throw new NotFoundException("Image Id Not Found :"+image_id);
        }
        Travel_area_image travelAreaImage = byId.get();
        travelAreaImage.setArea_image(Arrays.toString(imageDTO.getArea_image()));
        imageRepo.save(travelAreaImage);

    }

    @Override
    public void deleteImage(String image_id) {
        Optional<Travel_area_image> byId = imageRepo.findById(image_id);
        if (byId.isEmpty()){
            throw new NotFoundException("Image Id Not Found :"+image_id);
        }
        imageRepo.deleteById(image_id);
    }

    @Override
    public List<TravelAreaImageDTO> gelAllImage() {
        return imageRepo.findAll().stream().map(image->converter.toImageDto(image)).collect(Collectors.toList());
    }
}
