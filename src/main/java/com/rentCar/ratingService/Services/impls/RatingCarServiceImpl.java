package com.rentCar.ratingService.Services.impls;

import com.rentCar.ratingService.Entities.RatingCar;
import com.rentCar.ratingService.Entities.RatingClient;
import com.rentCar.ratingService.Repositories.RatingCarRepository;
import com.rentCar.ratingService.Services.RatingCarService;
import com.rentCar.ratingService.Shared.Exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class RatingCarServiceImpl implements RatingCarService {
    private final RatingCarRepository ratingCarRepository;
    private final ApiCall apiCall;
    private final Validator validator;

    public RatingCarServiceImpl(RatingCarRepository ratingCarRepository, ApiCall apiCall, Validator validator) {
        this.ratingCarRepository = ratingCarRepository;
        this.apiCall = apiCall;
        this.validator = validator;
    }

    @Override
    public List<RatingCar> getAll() {
        return ratingCarRepository.findAll();
    }

    @Override
    public Page<RatingCar> getAll(Pageable pageable) {
        return ratingCarRepository.findAll(pageable);
    }

    @Override
    public RatingCar getById(Long ratingCarId) {
        return ratingCarRepository.findById(ratingCarId)
                .orElseThrow(()->new ResourceNotFoundException("ratingCar",ratingCarId));
    }

    @Override
    public RatingCar create(Long carId, Long clientId, RatingCar ratingCar) {
        /*Set<ConstraintViolation<RatingCar>> violations=validator.validate(ratingCar);
        if(!violations.isEmpty()){
            throw new ResourceValidationException("ratingCar",violations);
        }*/
        ratingCar.setCarId(carId);
        ratingCar.setClientId(clientId);
        RatingCar aux=new RatingCar();
        aux=ratingCarRepository.save(ratingCar);
        Double rating=ratingCarRepository.getNewRating(carId);
        apiCall.setRatingCar(carId,rating);
        return aux;
    }

    @Override
    public List<RatingCar> getRatingsCar(Long carId) {
        return this.ratingCarRepository.getRatingsByCar(carId);
    }
}
