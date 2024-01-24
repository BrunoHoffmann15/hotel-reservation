package com.personal.hotel.management.unit;

import com.personal.hotel.management.domain.hotel.room.PriceRatio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class PriceRatioUnitTest {

    @Test
    public void test_givenDateIsNotOnRange_WhenIsOnRange_ThenReturnFalse() {
        // setup
        PriceRatio priceRatio = new PriceRatio();
        Date date = new Date(1706929200000L); // 2024/02/03
        Date finalDate = new Date(1705719600000L); // 2024/01/20
        Date initialDate = new Date(1705114800000L); // 2024/01/13

        priceRatio.setFinalDate(finalDate);
        priceRatio.setInitialDate(initialDate);

        //act
        Boolean result = priceRatio.isOnRange(date);

        //assert
        Assertions.assertFalse(result);
    }

    @Test
    public void test_givenDateIsEqualToInitialDate_WhenIsOnRange_ThenReturnTrue() {
        // setup
        PriceRatio priceRatio = new PriceRatio();
        Date date = new Date(1705114800000L); // 2024/01/13
        Date finalDate = new Date(1705719600000L); // 2024/01/20
        Date initialDate = new Date(1705114800000L); // 2024/01/13

        priceRatio.setFinalDate(finalDate);
        priceRatio.setInitialDate(initialDate);

        //act
        Boolean result = priceRatio.isOnRange(date);

        //assert
        Assertions.assertTrue(result);
    }

    @Test
    public void test_givenDateIsEqualToFinalDate_WhenIsOnRange_ThenReturnTrue() {
        // setup
        PriceRatio priceRatio = new PriceRatio();
        Date date = new Date(1705719600000L); // 2024/01/20
        Date finalDate = new Date(1705719600000L); // 2024/01/20
        Date initialDate = new Date(1705114800000L); // 2024/01/13

        priceRatio.setFinalDate(finalDate);
        priceRatio.setInitialDate(initialDate);

        //act
        Boolean result = priceRatio.isOnRange(date);

        //assert
        Assertions.assertTrue(result);
    }

    @Test
    public void test_givenDateIsOnRange_WhenIsOnRange_ThenReturnTrue() {
        // setup
        PriceRatio priceRatio = new PriceRatio();
        Date date = new Date(1705719600000L); // 2024/01/20
        Date finalDate = new Date(1705719600000L); // 2024/01/20
        Date initialDate = new Date(1705114800000L); // 2024/01/13

        priceRatio.setFinalDate(finalDate);
        priceRatio.setInitialDate(initialDate);

        //act
        Boolean result = priceRatio.isOnRange(date);

        //assert
        Assertions.assertTrue(result);
    }
}
