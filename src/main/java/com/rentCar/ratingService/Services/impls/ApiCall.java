package com.rentCar.ratingService.Services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiCall {
    @Autowired
    RestTemplate restTemplate;
    /*public void setRatingCar(Long carId,Double rating)throws RestClientException {
        restTemplate.exchange("http://localhost:8115/api/v1/cars/"+carId+"/rating/"+rating,
                HttpMethod.PUT,null,void.class);
    }
    public void setRatingOwner(Long ownerId,Double rating)throws RestClientException {
        restTemplate.exchange("http://localhost:8105/api/v1/owners/"+ownerId+"/rating/"+rating,
                HttpMethod.PUT,null,void.class);
    }
    public void setRatingClient(Long clientId,Double rating)throws RestClientException {
        restTemplate.exchange("http://localhost:8105/api/v1/clients/"+clientId+"/rating/"+rating,
                HttpMethod.PUT,null,void.class);
    }*/
    public void setRatingCar(Long carId,Double rating)throws RestClientException {
        restTemplate.exchange("https://cars-erentcar.azurewebsites.net/api/v1/cars/"+carId+"/rating/"+rating,
                HttpMethod.PUT,null,void.class);
    }
    public void setRatingOwner(Long ownerId,Double rating)throws RestClientException {
        restTemplate.exchange("https://users-erentcar.azurewebsites.net/api/v1/owners/"+ownerId+"/rating/"+rating,
                HttpMethod.PUT,null,void.class);
    }
    public void setRatingClient(Long clientId,Double rating)throws RestClientException {
        restTemplate.exchange("https://users-erentcar.azurewebsites.net/api/v1/clients/"+clientId+"/rating/"+rating,
                HttpMethod.PUT,null,void.class);
    }
}