package com.rentCar.ratingService.Repositories;

import com.rentCar.ratingService.Entities.RatingClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingClientRepository extends JpaRepository<RatingClient,Long> {
    @Query(value="select*from rating_client where client_id=?1", nativeQuery = true)
    List<RatingClient>getRatingsByClient(Long clientId);

    @Query(value="select avg(stars) from rating_client where client_id=?1 group by client_id", nativeQuery = true)
    Double getNewRating(Long clientId);
}
