package com.RatingService.Service;

import com.RatingService.Entities.Rating;
import com.RatingService.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    //    Create
    public Rating addRating(Rating rating){
        return ratingRepository.save(rating);
    }

    //getAllRating
    public List<Rating> getAllRating(){
        return ratingRepository.findAll();
    }

    //getAllByUserId

    public List<Rating> getAllRatingByUserId(Long userId){
        return ratingRepository.findByUserId(userId);
    }

    //getAllByHotelId
    public List<Rating> getAllRatingByHotelId(Long hotelId){
        return  ratingRepository.findByHotelId(hotelId);
    }

}
