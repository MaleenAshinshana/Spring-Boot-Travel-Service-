package org.example.service;

import org.example.dto.TravelAreaDTO;
import org.example.dto.TravelAreaImageDTO;

import java.util.List;

public interface TravelAreaImageService {
    TravelAreaImageDTO saveImage(String area_id,TravelAreaImageDTO imageDTO);
    TravelAreaImageDTO getSelectedImage(String image_id);
    void updateImage(String image_id,TravelAreaImageDTO imageDTO);
    void deleteImage(String image_id);
    List<TravelAreaImageDTO> gelAllImage();
}
