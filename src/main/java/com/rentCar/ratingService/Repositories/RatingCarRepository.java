package com.rentCar.ratingService.Repositories;

import com.rentCar.ratingService.Entities.RatingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingCarRepository extends JpaRepository<RatingCar,Long> {
    @Query(value="select*from rating_car where car_id=?1", nativeQuery = true)
    List<RatingCar>getRatingsByCar(Long carId);

    @Query(value="select avg(stars) from rating_car where car_id=?1 group by car_id", nativeQuery = true)
    Double getNewRating(Long carId);
}
