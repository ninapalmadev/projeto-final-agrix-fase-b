package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.service.CropService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Crop Controller.
 */
@RestController
public class CropController {
  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * GET crop METHOD.
   *
   * @return all crops
   */
  @GetMapping("/crops")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getAllCrops() {
    List<Crop> crops = cropService.getAllCrops();
    return crops.stream()
       .map(crop -> new CropDto(
           crop.getId(),
           crop.getName(),
           crop.getPlantedArea(),
           crop.getFarm().getId()))
         .collect(Collectors.toList());
  }
}