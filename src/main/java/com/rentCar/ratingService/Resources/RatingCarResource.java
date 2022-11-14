package com.rentCar.ratingService.Resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingCarResource {
    private Long id;
    private Long carId;
    private Long clientId;
    private int stars;
    private String comment;
}
