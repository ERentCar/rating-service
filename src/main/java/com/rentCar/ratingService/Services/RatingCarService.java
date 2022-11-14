package com.rentCar.ratingService.Services;

import com.rentCar.ratingService.Entities.RatingCar;
import com.rentCar.ratingService.Resources.CreateRatingResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RatingCarService {
    List<RatingCar> getAll();
    Page<RatingCar> getAll(Pageable pageable);
    RatingCar getById(Long ratingCarId);
    RatingCar create(Long carId, Long clientId, RatingCar ratingCar);
    List<RatingCar> getRatingsCar(Long carId);
}
