package com.rentCar.ratingService.Services.impls;

import com.rentCar.ratingService.Entities.RatingOwner;
import com.rentCar.ratingService.Repositories.RatingOwnerRepository;
import com.rentCar.ratingService.Services.RatingOwnerService;
import com.rentCar.ratingService.Shared.Exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class RatingOwnerServiceImpl implements RatingOwnerService {
    private final RatingOwnerRepository ratingOwnerRepository;
    private final ApiCall apiCall;
    private final Validator validator;

    public RatingOwnerServiceImpl(RatingOwnerRepository ratingOwnerRepository, ApiCall apiCall, Validator validator) {
        this.ratingOwnerRepository = ratingOwnerRepository;
        this.apiCall = apiCall;
        this.validator = validator;
    }

    @Override
    public List<RatingOwner> getAll() {
        return this.ratingOwnerRepository.findAll();
    }

    @Override
    public Page<RatingOwner> getAll(Pageable pageable) {
        return this.ratingOwnerRepository.findAll(pageable);
    }

    @Override
    public RatingOwner getById(Long ratingOwnerId) {
        return this.ratingOwnerRepository.findById(ratingOwnerId)
                .orElseThrow(()->new ResourceNotFoundException("ratingOwner",ratingOwnerId));
    }

    @Override
    public RatingOwner create(Long ownerId, Long clientId, RatingOwner ratingOwner) {
        ratingOwner.setOwnerId(ownerId);
        ratingOwner.setClientId(clientId);
        RatingOwner aux=this.ratingOwnerRepository.save(ratingOwner);
        Double rating=this.ratingOwnerRepository.getNewRatingOwner(ownerId);
        this.apiCall.setRatingOwner(ownerId,rating);
        return aux;
    }

    @Override
    public List<RatingOwner> getRatingsByOwner(Long ownerId) {
        return this.ratingOwnerRepository.getRatingsByOwner(ownerId);
    }
}
