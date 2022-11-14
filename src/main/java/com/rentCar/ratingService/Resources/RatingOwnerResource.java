package com.rentCar.ratingService.Resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingOwnerResource {
    private Long id;
    private Long ownerId;
    private Long clientId;
    private int stars;
    private String comment;
}
