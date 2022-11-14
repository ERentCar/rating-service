package com.rentCar.ratingService.Controllers;

import com.rentCar.ratingService.Mapping.RatingCarMapper;
import com.rentCar.ratingService.Resources.CreateRatingResource;
import com.rentCar.ratingService.Resources.RatingCarResource;
import com.rentCar.ratingService.Services.RatingCarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/ratingCars")
public class RatingCarController {
    private final RatingCarService ratingCarService;
    private final RatingCarMapper mapper;

    public RatingCarController(RatingCarService ratingCarService, RatingCarMapper mapper) {
        this.ratingCarService = ratingCarService;
        this.mapper = mapper;
    }
    @GetMapping()
    public Page<RatingCarResource> getAll(Pageable pageable){
        return mapper.modelListToPage(ratingCarService.getAll(),pageable);
    }

    @GetMapping("{ratingCarId}")
    public RatingCarResource getRatingCarById(@PathVariable Long ratingCarId){
        return  mapper.toResource(ratingCarService.getById(ratingCarId));
    }

    @PostMapping("car/{carId}/client/{clientId}")
    public RatingCarResource createRatingCar(@PathVariable("carId")Long carId,
                                             @PathVariable("clientId")Long clientId,
                                             @Valid @RequestBody CreateRatingResource request){
        return mapper.toResource(ratingCarService.create(carId,clientId,mapper.toModel(request)));
    }

    @GetMapping("car/{carId}")
    public Page<RatingCarResource> getRatingsByCar(@PathVariable Long carId,Pageable pageable){
        return mapper.modelListToPage(ratingCarService.getRatingsCar(carId),pageable);
    }
}
