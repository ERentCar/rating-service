package com.rentCar.ratingService.Services;

import com.rentCar.ratingService.Entities.RatingClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingClientService {
    List<RatingClient> getAll();
    Page<RatingClient> getAll(Pageable pageable);
    RatingClient getById(Long ratingClientId);
    RatingClient create(Long clientId, Long ownerId, RatingClient ratingClient);
    List<RatingClient> getRatingsByClient(Long clientId);
}
