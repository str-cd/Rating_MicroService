package com.HotelService.Service;

import com.HotelService.Entities.Hotel;
import com.HotelService.Exceptions.ResourceNotFoundException;
import com.HotelService.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id){
        return  hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with id is not Found on server"+id));
    }
}
