package com.personal.hotel.management.domain.hotel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PriceRatio {
    private BigDecimal percentToConsider;
    private Date initialDate;
    private Date finalDate;
}
