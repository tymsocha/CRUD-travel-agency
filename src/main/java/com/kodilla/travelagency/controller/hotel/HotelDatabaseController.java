package com.kodilla.travelagency.controller.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@Transactional
@RequestMapping("v1/travel/hotelBase")
public class HotelDatabaseController {
}
