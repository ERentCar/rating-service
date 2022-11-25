package com.rentCar.ratingService.Controllers;

import com.rentCar.ratingService.Mapping.RatingOwnerMapper;
import com.rentCar.ratingService.Resources.CreateRatingResource;
import com.rentCar.ratingService.Resources.RatingOwnerResource;
import com.rentCar.ratingService.Services.RatingOwnerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/ratingOwners")
public class RatingOwnerController {
    private final RatingOwnerService ratingOwnerService;
    private final RatingOwnerMapper mapper;

    public RatingOwnerController(RatingOwnerService ratingOwnerService, RatingOwnerMapper mapper) {
        this.ratingOwnerService = ratingOwnerService;
        this.mapper = mapper;
    }
    @GetMapping()
    public Page<RatingOwnerResource> getAll(Pageable pageable){
        return mapper.modelListToPage(ratingOwnerService.getAll(),pageable);
    }

    @GetMapping("{ratingOwnerId}")
    public RatingOwnerResource getRatingOwnerById(@PathVariable Long ratingOwnerId){
        return  mapper.toResource(ratingOwnerService.getById(ratingOwnerId));
    }

    @PostMapping("owner/{ownerId}/client/{clientId}")
    public RatingOwnerResource createRatingOwner(@PathVariable("ownerId")Long ownerId,
                                                   @PathVariable("clientId")Long clientId,
                                                   @Valid @RequestBody CreateRatingResource request){
        return mapper.toResource(ratingOwnerService.create(ownerId,clientId,mapper.toModel(request)));
    }

    @GetMapping("owner/{ownerId}")
    public Page<RatingOwnerResource> getRatingsByOwner(@PathVariable("ownerId")Long ownerId,
                                                       Pageable pageable){
        return mapper.modelListToPage(ratingOwnerService.getRatingsByOwner(ownerId),pageable);
    }
}
