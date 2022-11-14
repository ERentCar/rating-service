package com.rentCar.ratingService.Services.impls;

import com.rentCar.ratingService.Entities.RatingClient;
import com.rentCar.ratingService.Repositories.RatingClientRepository;
import com.rentCar.ratingService.Services.RatingClientService;
import com.rentCar.ratingService.Shared.Exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class RatingClientServiceImpl implements RatingClientService {
    private final RatingClientRepository ratingClientRepository;
    private final ApiCall apiCall;
    private final Validator validator;

    public RatingClientServiceImpl(RatingClientRepository ratingClientRepository, ApiCall apiCall, Validator validator) {
        this.ratingClientRepository = ratingClientRepository;
        this.apiCall = apiCall;
        this.validator = validator;
    }

    @Override
    public List<RatingClient> getAll() {
        return this.ratingClientRepository.findAll();
    }

    @Override
    public Page<RatingClient> getAll(Pageable pageable) {
        return this.ratingClientRepository.findAll(pageable);
    }

    @Override
    public RatingClient getById(Long ratingClientId) {
        return this.ratingClientRepository.findById(ratingClientId)
                .orElseThrow(()->new ResourceNotFoundException("ratingClient",ratingClientId));
    }

    @Override
    public RatingClient create(Long clientId, Long ownerId, RatingClient ratingClient) {
        ratingClient.setClientId(clientId);
        ratingClient.setOwnerId(ownerId);
        RatingClient aux=this.ratingClientRepository.save(ratingClient);
        Double rating=this.ratingClientRepository.getNewRating(clientId);
        apiCall.setRatingClient(clientId,rating);
        return aux;
    }

    @Override
    public List<RatingClient> getRatingsByClient(Long clientId) {
        return this.ratingClientRepository.getRatingsByClient(clientId);
    }
}
