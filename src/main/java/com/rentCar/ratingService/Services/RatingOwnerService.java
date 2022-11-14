package com.rentCar.ratingService.Services;

import com.rentCar.ratingService.Entities.RatingOwner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingOwnerService {
    List<RatingOwner> getAll();
    Page<RatingOwner> getAll(Pageable pageable);
    RatingOwner getById(Long ratingOwnerId);
    RatingOwner create(Long ownerId,Long clientId,RatingOwner ratingOwner);
    List<RatingOwner> getRatingsByOwner(Long ownerId);
}
