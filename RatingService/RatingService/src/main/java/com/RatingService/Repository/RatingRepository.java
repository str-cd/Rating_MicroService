package com.RatingService.Repository;

import com.RatingService.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {

    List<Rating> findByUserId(Long userId);
    List<Rating> findByHotelId(Long hotelId);
}
