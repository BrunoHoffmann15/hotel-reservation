package com.personal.hotel.management.domain.hotel;

import com.personal.hotel.management.domain.hotel.room.Room;
import lombok.Data;

import java.util.List;

@Data
public class Hotel {
    private Long id;
    private String name;
    private Address address;
    private List<Room> rooms;
}
