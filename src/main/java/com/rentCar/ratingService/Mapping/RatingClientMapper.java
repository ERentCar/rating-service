package com.rentCar.ratingService.Mapping;

import com.rentCar.ratingService.Entities.RatingClient;
import com.rentCar.ratingService.Resources.CreateRatingResource;
import com.rentCar.ratingService.Resources.RatingClientResource;
import com.rentCar.ratingService.Shared.Mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class RatingClientMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RatingClientResource toResource (RatingClient model){return mapper.map(model,RatingClientResource.class);}
    public Page<RatingClientResource> modelListToPage(List<RatingClient> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,RatingClientResource.class),pageable,modelList.size());
    }
    public RatingClient toModel(CreateRatingResource resource){return mapper.map(resource,RatingClient.class);}
}
