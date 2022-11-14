package com.rentCar.ratingService.Controllers;

import com.rentCar.ratingService.Mapping.RatingClientMapper;
import com.rentCar.ratingService.Resources.CreateRatingResource;
import com.rentCar.ratingService.Resources.RatingClientResource;
import com.rentCar.ratingService.Services.RatingClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/ratingClients")
public class RatingClientController {
    private final RatingClientService ratingClientService;
    private final RatingClientMapper mapper;

    public RatingClientController(RatingClientService ratingClientService, RatingClientMapper mapper) {
        this.ratingClientService = ratingClientService;
        this.mapper = mapper;
    }
    @GetMapping()
    public Page<RatingClientResource> getAll(Pageable pageable){
        return mapper.modelListToPage(ratingClientService.getAll(),pageable);
    }

    @GetMapping("{ratingClientId}")
    public RatingClientResource getRatingClientById(@PathVariable Long ratingClientId){
        return  mapper.toResource(ratingClientService.getById(ratingClientId));
    }

    @PostMapping("client/{clientId}/owner/{ownerId}")
    public RatingClientResource createRatingClient(@PathVariable("clientId")Long clientId,
                                             @PathVariable("ownerId")Long ownerId,
                                             @Valid @RequestBody CreateRatingResource request){
        return mapper.toResource(ratingClientService.create(clientId,ownerId,mapper.toModel(request)));
    }

    @GetMapping("client/{clientId}")
    public Page<RatingClientResource> getRatingsByClient(@PathVariable("clientId")Long clientId,
                                                         Pageable pageable){
        return mapper.modelListToPage(ratingClientService.getRatingsByClient(clientId),pageable);
    }
}
