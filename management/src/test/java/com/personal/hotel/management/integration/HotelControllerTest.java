package com.personal.hotel.management.integration;

import com.personal.hotel.management.controller.HotelController;
import com.personal.hotel.management.domain.hotel.Hotel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HotelControllerTest {

    @Autowired
    HotelController hotelController;

    @Test
    @SneakyThrows
    public void test_GivenHotelIsNotAlreadyAdded_ThenReturnCreated() {
        var hotel = new Hotel();
        var response = hotelController.create(hotel);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getHeaders().getLocation().getPath()).contains("/hotels/1");
    }

//    @Test
//    public void test_GivenHotelIsAlreadyAdded_ThenReturnUnprocessableEntity() {
//
//    }

    @Test
    public void test_GivenHotelDoesNotHasRoomAssociated_ThenReturnOk() {
        Long roomId = 1L;
        Long hotelId = 1L;

        var response = hotelController.addRoom(hotelId, roomId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    public void test_GivenHotelsHaveBeenCreated_WhenGetAll_ThenReturnOk() {
        var response = hotelController.getAll();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public void test_GivenHotelHasBeenAdded_WhenGet_ThenReturnOk() {
        Long hotelId = 1L;
        var response = hotelController.get(hotelId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }
}
