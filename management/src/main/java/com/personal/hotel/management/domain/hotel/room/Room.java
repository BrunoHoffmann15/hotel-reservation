package com.personal.hotel.management.domain.hotel.room;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class Room {
    private String name;
    private String description;
    private BigDecimal defaultPrice;
    private List<PriceRatio> priceRatio;
    private List<Amenity> amenities;

    public BigDecimal calculateDailyPrice(Date day) {
        Optional<PriceRatio> priceRatioToConsider = priceRatio.stream().filter(p -> p.isOnRange(day)).findFirst();
        return priceRatioToConsider
                .map(ratio ->
                        defaultPrice
                                .multiply(BigDecimal.ONE.add(ratio.getPercentageToConsider()))
                                .setScale(2, BigDecimal.ROUND_DOWN)
                )
                .orElseGet(() -> defaultPrice);
    }

    public void addPriceRatio(PriceRatio priceRatioToAdd) throws Exception {
        Boolean canConsiderInitialDate = !priceRatio.stream().anyMatch(p -> p.isOnRange(priceRatioToAdd.getInitialDate()));
        Boolean canConsiderFinalDate = !priceRatio.stream().anyMatch(p -> p.isOnRange(priceRatioToAdd.getFinalDate()));

        if (canConsiderInitialDate && canConsiderFinalDate) {
             priceRatio.add(priceRatioToAdd);
             return;
        }

        throw new Exception(String.format("Price ratio is conflicting with some date, initial date: %b, final date: %b", canConsiderInitialDate, canConsiderFinalDate));
    }
}
