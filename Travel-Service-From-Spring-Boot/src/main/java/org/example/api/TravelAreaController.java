package org.example.api;

import jakarta.validation.Valid;
import org.example.dto.TravelAreaDTO;
import org.example.service.TravelAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/area")
@CrossOrigin("*")
public class TravelAreaController {
    private final TravelAreaService travelAreaService;

    public TravelAreaController(TravelAreaService travelAreaService) {
        this.travelAreaService = travelAreaService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    TravelAreaDTO saveArea(@Valid @RequestBody TravelAreaDTO areaDTO){
        return travelAreaService.saveArea(areaDTO);
    }
    @GetMapping(value = "/{area_id}")
    ResponseEntity<TravelAreaDTO> getSelectedTravel(@Valid @PathVariable String area_id){
        TravelAreaDTO selectedTravel = travelAreaService.getSelectedTravel(area_id);
        return new ResponseEntity<>(selectedTravel,HttpStatus.OK);
    }
    @DeleteMapping(value = "/{area_id}")
    void deleteArea(@Valid @PathVariable String area_id){
        travelAreaService.deleteTravel(area_id);

    }
    @PatchMapping(value = "/{area_id}")
    void updateArea(@Valid @PathVariable String area_id,@RequestBody TravelAreaDTO areaDTO){
        travelAreaService.updateTravel(area_id,areaDTO);

    }
    @GetMapping
    public ResponseEntity<List<TravelAreaDTO>> getAllArea() {
        List<TravelAreaDTO> dto = travelAreaService.gelAllTravel();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
