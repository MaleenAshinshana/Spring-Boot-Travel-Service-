package org.example.service;

import org.example.dto.TravelAreaDTO;

import java.util.List;

public interface TravelAreaService {
    TravelAreaDTO saveArea(TravelAreaDTO areaDTO);
    TravelAreaDTO getSelectedTravel(String area_id);
    void updateTravel(String area_id,TravelAreaDTO areaDTO);
    void deleteTravel(String area_id);
    List<TravelAreaDTO> gelAllTravel();
}
