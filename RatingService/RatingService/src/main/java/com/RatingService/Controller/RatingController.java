package com.RatingService.Controller;

import com.RatingService.Entities.Rating;
import com.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping("/addRating")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        Rating rating1 = ratingService.addRating(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllRating")
    public ResponseEntity<List<Rating>> getAllRating() {
        List<Rating> li = ratingService.getAllRating();
        return new ResponseEntity<>(li, HttpStatus.FOUND);
    }

    @GetMapping("/getAllByUserId/{id}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable("id") Long id) {
        List<Rating> li = ratingService.getAllRatingByUserId(id);
        return new ResponseEntity<>(li, HttpStatus.FOUND);
    }

    @GetMapping("/getAllByHotelId/{id}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable("id") Long id) {
        List<Rating> li = ratingService.getAllRatingByHotelId(id);
        return new ResponseEntity<>(li, HttpStatus.FOUND);
    }
}