package org.example.service.util;

import lombok.RequiredArgsConstructor;
import org.example.dto.TravelAreaDTO;
import org.example.entity.TravelArea;
import org.example.exception.NotFoundException;
import org.example.repo.TravelAreaRepo;
import org.example.service.TravelAreaService;
import org.example.util.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TravelAreaServiceIMPL  implements TravelAreaService {
    private final Converter converter;
    private final TravelAreaRepo areaRepo;
    @Override
    public TravelAreaDTO saveArea(TravelAreaDTO areaDTO) {
        return converter.toAreaDto(areaRepo.save(converter.toAreaEntity(areaDTO)));
    }

    @Override
    public TravelAreaDTO getSelectedTravel(String area_id) {
        Optional<TravelArea> byId = areaRepo.findById(area_id);
        if (!byId.isPresent()){
            throw new NotFoundException("Area Id Is Not Found :" + area_id);

        }
        return converter.toAreaDto(byId.get());
    }

    @Override
    public void updateTravel(String area_id, TravelAreaDTO areaDTO) {
        Optional<TravelArea> byId = areaRepo.findById(area_id);
        if (!byId.isPresent()){
            throw new NotFoundException("Area Id Is Not Found :" + area_id);
        }
        TravelArea travelArea=byId.get();
        travelArea.setArea_location(areaDTO.getArea_location());
        /*travelArea.setAreaImages(areaDTO.getAreaImages());*/

        areaRepo.save(travelArea);

    }

    @Override
    public void deleteTravel(String area_id) {
        Optional<TravelArea> byId = areaRepo.findById(area_id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Area Id Is Not Found: " + area_id);
        }

        areaRepo.deleteById(area_id);

    }

    @Override
    public List<TravelAreaDTO> gelAllTravel() {
        return areaRepo.findAll().stream().map(area->converter.toAreaDto(area)).collect(Collectors.toList());
    }
}
