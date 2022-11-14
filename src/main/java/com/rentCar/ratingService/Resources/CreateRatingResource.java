package com.rentCar.ratingService.Resources;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateRatingResource {
    @NotNull
    private int stars;
    @NotNull
    private String comment;
}
