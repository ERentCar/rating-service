package com.rentCar.ratingService.Resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingClientResource {
    private Long id;
    private Long clientId;
    private Long ownerId;
    private int stars;
    private String comment;
}
