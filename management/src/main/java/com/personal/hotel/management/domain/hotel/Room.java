package com.personal.hotel.management.domain.hotel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Room {
    private String name;
    private String description;
    private BigDecimal defaultPrice;
    private List<PriceRatio> priceRatio;
    private List<Amenity> amenities;
}
