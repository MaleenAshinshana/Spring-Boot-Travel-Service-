package org.example.util;

import org.example.dto.MainTravelServiceDTO;
import org.example.dto.TravelAreaDTO;
import org.example.dto.TravelAreaImageDTO;
import org.example.entity.MainTravelServiceEntity;
import org.example.entity.TravelArea;
import org.example.entity.TravelPackage;
import org.example.entity.Travel_area_image;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;

@Component
public class Converter {
    private final ModelMapper modelMapper;

    public Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public MainTravelServiceEntity toServiceEntity(MainTravelServiceDTO serviceDTO){
        return modelMapper.map(serviceDTO, MainTravelServiceEntity.class);
    }

    public MainTravelServiceDTO toServiceDto(MainTravelServiceEntity mainTravelServiceEntity){
        return modelMapper.map(mainTravelServiceEntity, MainTravelServiceDTO.class);
    }
    public TravelAreaDTO toAreaDto(TravelArea travelArea){
        List<Travel_area_image> areaImages = travelArea.getAreaImages();
        TravelAreaDTO map = modelMapper.map(travelArea, TravelAreaDTO.class);

        if (areaImages!=null){
            map.setAreaImages(
                    areaImages.stream().map(t->new TravelAreaImageDTO(t.getImage_id(),
                            Base64.getDecoder().decode(t.getArea_image()),
                            travelArea.getArea_id())).toList());


        }
        return map;
      /*  return modelMapper.map(travelArea, TravelAreaDTO.class);*/
    }
    public TravelArea toAreaEntity(TravelAreaDTO areaDTO){
        return modelMapper.map(areaDTO, TravelArea.class);
    }

    public TravelAreaImageDTO toImageDto(Travel_area_image travelAreaImage){
        return modelMapper.map(travelAreaImage, TravelAreaImageDTO.class);
    }
    public Travel_area_image toAreaImageEntity(TravelAreaImageDTO imageDTO){
        Travel_area_image map = modelMapper.map(imageDTO, Travel_area_image.class);
        map.setArea_image(Base64.getEncoder().encodeToString(imageDTO.getArea_image()));
        return map;
        /*return modelMapper.map(imageDTO, Travel_area_image.class);*/
    }

//    public TravelAreaEntity  toAreaEntity(TravelAreaDTO areaDTO){
//        return modelMapper.map(areaDTO, TravelAreaEntity.class);
//    }
//
//    public TravelAreaDTO toAreaDto(TravelAreaEntity travelAreaEntity){
//        return modelMapper.map(travelAreaEntity, TravelAreaDTO.class);
//    }
//
//    public TravelAreaImage toImageEntity(TravelImageDTO  imageDTO){
//        return modelMapper.map(imageDTO, TravelAreaImage.class);
//    }
//
//    public TravelImageDTO toImageDto(TravelAreaImage travelAreaImage){
//        return modelMapper.map(travelAreaImage, TravelImageDTO.class);
//    }

    public TravelPackage toPackageEntity(Package aPackage){
        return modelMapper.map(aPackage, TravelPackage.class);
    }

    public Package toPackageDto(TravelPackage packageEntity){
        return modelMapper.map(packageEntity, Package.class);
    }
}
