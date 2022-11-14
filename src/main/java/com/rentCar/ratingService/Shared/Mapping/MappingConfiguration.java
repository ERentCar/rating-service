package com.rentCar.ratingService.Shared.Mapping;

import com.rentCar.ratingService.Mapping.RatingCarMapper;
import com.rentCar.ratingService.Mapping.RatingClientMapper;
import com.rentCar.ratingService.Mapping.RatingOwnerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration("ratingServiceMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public RatingCarMapper ratingCarMapper(){return new RatingCarMapper();}
    @Bean
    public RatingClientMapper ratingClientMapper(){return new RatingClientMapper();}
    @Bean
    public RatingOwnerMapper ratingOwnerMapper(){return new RatingOwnerMapper();}
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
