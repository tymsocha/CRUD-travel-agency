package com.kodilla.travelagency.business.hotel.dao;

import com.kodilla.travelagency.business.hotel.domain.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HotelDAO extends CrudRepository<Hotel, Long> {
    @Override
    List<Hotel> findAll();

    @Override
    Hotel save(Hotel hotel);

    Optional<Hotel> findById(Long id);

    @Override
    void delete(Long HotelId);

    @Override
    void deleteAll();

    @Override
    long count();

    Optional<Hotel> findByAddressOrHotelNameOrPhoneNumber(String address, String name, String phone);
}
