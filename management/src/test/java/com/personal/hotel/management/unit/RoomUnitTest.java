package com.personal.hotel.management.unit;

import com.personal.hotel.management.domain.hotel.room.PriceRatio;
import com.personal.hotel.management.domain.hotel.room.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RoomUnitTest {

    @Test
    public void test_givenDayHasPriceRatio_whenCalculateDailyPrice_thenReturnCalculatedPrice() {
        // setup
        BigDecimal expectedPrice = new BigDecimal("120.00");

        PriceRatio priceRatio = new PriceRatio();
        Date date = new Date(1705287600000L); // 2024/01/15
        Date finalDate = new Date(1705719600000L); // 2024/01/20
        Date initialDate = new Date(1705114800000L); // 2024/01/13

        priceRatio.setFinalDate(finalDate);
        priceRatio.setInitialDate(initialDate);
        priceRatio.setPercentageToConsider(new BigDecimal("0.20"));

        Room room = new Room();
        room.setPriceRatio(List.of(priceRatio));
        room.setDefaultPrice(new BigDecimal("100.00"));

        // act
        BigDecimal result = room.calculateDailyPrice(date);

        // assert
        Assertions.assertEquals(expectedPrice, result);
    }

    @Test
    public void test_givenDayHasNotPriceRatio_whenCalculateDailyPrice_thenReturnDefaultPrice() {
        // setup
        BigDecimal expectedPrice = new BigDecimal("100.00");
        Date date = new Date(1705287600000L); // 2024/01/15

        Room room = new Room();
        room.setPriceRatio(Collections.emptyList());
        room.setDefaultPrice(new BigDecimal("100.00"));

        // act
        BigDecimal result = room.calculateDailyPrice(date);

        // assert
        Assertions.assertEquals(expectedPrice, result);
    }
}
