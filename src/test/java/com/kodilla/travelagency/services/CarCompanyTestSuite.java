package com.kodilla.travelagency.services;

import com.kodilla.travelagency.business.car.dao.CarCompanyDAO;
import com.kodilla.travelagency.business.car.domain.CarCompany;
import com.kodilla.travelagency.business.car.service.CarCompanyService;
import com.kodilla.travelagency.exceptions.CarCompanyNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarCompanyTestSuite {
    @Autowired
    private CarCompanyService service;

    @Autowired
    private CarCompanyDAO dao;

    @Test
    public void shouldGetAllCarCompanys() {
        //Given
        CarCompany carCompany = CarCompany.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        CarCompany carCompany1 = CarCompany.builder().carCompanyName("LO").address("WAW").phoneNumber("456").build();
        CarCompany carCompany2 = CarCompany.builder().carCompanyName("BA").address("LON").phoneNumber("789").build();
        dao.save(carCompany);
        dao.save(carCompany1);
        dao.save(carCompany2);
        //When
        List<CarCompany> carCompanys = service.getAllCarCompanies();
        //Then
        assertEquals(3, carCompanys.size());
        //CleanUp
        dao.delete(carCompany);
        dao.delete(carCompany1);
        dao.delete(carCompany2);
    }

    @Test
    public void shouldFindCarCompanyById() {
        //Given
        CarCompany carCompany = CarCompany.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        CarCompany savedCarCompany = dao.save(carCompany);
        //When and then
        try {
            CarCompany foundCarCompany = service.findCarCompanyById(savedCarCompany.getId());
            assertEquals("LH", foundCarCompany.getCarCompanyName());
            assertEquals("FRA", foundCarCompany.getAddress());
            assertEquals("123", foundCarCompany.getPhoneNumber());
        } catch (CarCompanyNotFoundException e) {
            e.printStackTrace();
        }
        //Clean Up
        dao.delete(savedCarCompany);
    }

    @Test
    public void shouldDeleteCarCompany() {
        //Given
        CarCompany carCompany = CarCompany.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        CarCompany savedCarCompany = dao.save(carCompany);
        //When
        service.delete(savedCarCompany.getId());
        List<CarCompany> carCompanies = service.getAllCarCompanies();
        //Then
        assertEquals(0, carCompanies.size());
    }
}
