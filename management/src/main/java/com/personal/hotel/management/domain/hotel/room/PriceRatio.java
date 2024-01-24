package com.personal.hotel.management.domain.hotel.room;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PriceRatio {
    private BigDecimal percentToConsider;
    private Date initialDate;
    private Date finalDate;

    public Boolean isOnRange(Date date) {
        return date.compareTo(initialDate) >= 0
                && date.compareTo(finalDate) <= 0;
    }
}
