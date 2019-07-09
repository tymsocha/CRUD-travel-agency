package com.kodilla.travelagency.controller.hotel;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/hotelBase")
public class HotelDatabaseController {
}
