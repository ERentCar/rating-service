package com.rentCar.ratingService.Repositories;

import com.rentCar.ratingService.Entities.RatingOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingOwnerRepository extends JpaRepository<RatingOwner,Long> {
    @Query(value="select*from rating_owner where owner_id=?1", nativeQuery = true)
    List<RatingOwner> getRatingsByOwner(Long ownerId);

    @Query(value="select avg(stars) from rating_owner where owner_id=?1 group by owner_id", nativeQuery = true)
    Double getNewRatingOwner(Long ownerId);
}
