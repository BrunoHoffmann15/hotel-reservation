package com.personal.hotel.management.domain.hotel;

import com.personal.hotel.management.domain.hotel.room.Room;

public class HotelDomainService {
    private final IHotelRepository hotelRepository;

    public HotelDomainService(IHotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
