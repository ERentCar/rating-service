package com.rentCar.ratingService.Mapping;

import com.rentCar.ratingService.Entities.RatingCar;
import com.rentCar.ratingService.Resources.CreateRatingResource;
import com.rentCar.ratingService.Resources.RatingCarResource;
import com.rentCar.ratingService.Shared.Mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class RatingCarMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RatingCarResource toResource(RatingCar model){return mapper.map(model,RatingCarResource.class);}
    public Page<RatingCarResource> modelListToPage(List<RatingCar> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,RatingCarResource.class),pageable,modelList.size());
    }
    public RatingCar toModel (CreateRatingResource resource){return mapper.map(resource,RatingCar.class);}
    public List<RatingCarResource> listToResource(List<RatingCar> modelList){
        return mapper.mapList(modelList,RatingCarResource.class);
    }
}
