package com.HotelService.Controller;

import com.HotelService.Entities.Hotel;
import com.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.saveHotel(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> li = hotelService.getAllHotels();
        return new ResponseEntity<>(li,HttpStatus.FOUND);
    }

        @GetMapping("/getHotelById/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        Hotel hotel = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.FOUND);
    }
}
