package com.rentCar.ratingService.Mapping;

import com.rentCar.ratingService.Entities.RatingOwner;
import com.rentCar.ratingService.Resources.CreateRatingResource;
import com.rentCar.ratingService.Resources.RatingOwnerResource;
import com.rentCar.ratingService.Shared.Mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class RatingOwnerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RatingOwnerResource toResource(RatingOwner model){return mapper.map(model,RatingOwnerResource.class);}
    public Page<RatingOwnerResource> modelListToPage(List<RatingOwner> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,RatingOwnerResource.class),pageable,modelList.size());
    }
    public RatingOwner toModel (CreateRatingResource resource){return mapper.map(resource,RatingOwner.class);}
}
