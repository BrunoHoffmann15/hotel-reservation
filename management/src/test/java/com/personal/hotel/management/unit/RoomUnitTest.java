package com.personal.hotel.management.unit;

import com.personal.hotel.management.domain.hotel.room.PriceRatio;
import com.personal.hotel.management.domain.hotel.room.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Test
    public void test_givenPriceRatioHasConflictDates_whenAddPriceRatio_thenReturnException() throws Exception {
        // setup
        PriceRatio priceRatio = new PriceRatio();
        Date finalDate = new Date(1705719600000L); // 2024/01/20
        Date initialDate = new Date(1705114800000L); // 2024/01/13

        priceRatio.setFinalDate(finalDate);
        priceRatio.setInitialDate(initialDate);

        PriceRatio priceRatio2 = new PriceRatio();
        Date finalDate2 = new Date(1707966000000L); // 2024/02/15
        Date initialDate2 = new Date(1705719600000L); // 2024/01/20

        priceRatio2.setFinalDate(finalDate2);
        priceRatio2.setInitialDate(initialDate2);

        Room room = new Room();
        room.setPriceRatio(new ArrayList<>());
        room.addPriceRatio(priceRatio);

        // act
        Assertions.assertThrows(Exception.class, () -> room.addPriceRatio(priceRatio2));
    }

    @Test
    public void test_givenPriceRatioHasNoConflictDates_whenAddPriceRatio_thenReturnNoError() throws Exception {
        // setup
        PriceRatio priceRatio = new PriceRatio();
        Date finalDate = new Date(1705719600000L); // 2024/01/20
        Date initialDate = new Date(1705114800000L); // 2024/01/13

        priceRatio.setFinalDate(finalDate);
        priceRatio.setInitialDate(initialDate);

        PriceRatio priceRatio2 = new PriceRatio();
        Date finalDate2 = new Date(1707966000000L); // 2024/02/15
        Date initialDate2 = new Date(1707793200000L); // 2024/02/13

        priceRatio2.setFinalDate(finalDate2);
        priceRatio2.setInitialDate(initialDate2);

        Room room = new Room();
        room.setPriceRatio(new ArrayList<>());
        room.addPriceRatio(priceRatio);

        // act
        room.addPriceRatio(priceRatio2);

        // assert
        Assertions.assertEquals(2, room.getPriceRatio().size());
    }
}
