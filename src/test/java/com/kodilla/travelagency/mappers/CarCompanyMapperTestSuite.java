package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.car.api.CarCompanyDTO;
import com.kodilla.travelagency.business.car.domain.CarCompany;
import com.kodilla.travelagency.business.car.mapper.CarCompanyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarCompanyMapperTestSuite {
    @Autowired
    private CarCompanyMapper mapper;

    @Test
    public void testMapCarCompanyToDTO() {
        //Given
        CarCompany carCompany = new CarCompany(1L, "Hertz", "Frankfurt", "123456789");
        //When
        CarCompanyDTO carCompanyDTO = mapper.mapCarCompanyToDTO(carCompany);
        //Then
        assertEquals(1L, carCompanyDTO.getId(), 0.001);
        assertEquals("Hertz", carCompanyDTO.getCarCompanyName());
        assertEquals("Frankfurt", carCompanyDTO.getAddress());
        assertEquals("123456789", carCompanyDTO.getPhoneNumber());
    }

    @Test
    public void testMapDTOToCarCompany() {
        //Given
        CarCompanyDTO carCompanyDTO = new CarCompanyDTO(1L, "Hertz", "Frankfurt", "123456789");
        //When
        CarCompany carCompany = mapper.mapDTOToCarCompany(carCompanyDTO);
        //Then
        assertEquals(1L, carCompany.getId(), 0.001);
        assertEquals("Hertz", carCompany.getCarCompanyName());
        assertEquals("Frankfurt", carCompany.getAddress());
        assertEquals("123456789", carCompany.getPhoneNumber());
    }

    @Test
    public void testMapCarCompanyListToDTOList() {
        //Given
        CarCompany hertz = new CarCompany(1L, "Hertz", "Frankfurt", "123456789");
        CarCompany avis = new CarCompany(2L, "Avis", "Frankfurt", "123456789");
        CarCompany europCar = new CarCompany(3L, "EuropCar", "Frankfurt", "123456789");
        List<CarCompany> carCompanies = new ArrayList<>();
        carCompanies.add(hertz);
        carCompanies.add(avis);
        carCompanies.add(europCar);
        //When
        List<CarCompanyDTO> carCompanyDTOS = mapper.mapCarCompanyListToDTOList(carCompanies);
        //Then
        assertEquals(3, carCompanyDTOS.size());
        assertEquals("Hertz", carCompanyDTOS.get(0).getCarCompanyName());
        assertEquals("Avis", carCompanyDTOS.get(1).getCarCompanyName());
        assertEquals("EuropCar", carCompanyDTOS.get(2).getCarCompanyName());
    }

    @Test
    public void testMapDTOListTOCarCompanyList() {
        //Given
        CarCompanyDTO hertz = new CarCompanyDTO(1L, "Hertz", "Frankfurt", "123456789");
        CarCompanyDTO avis = new CarCompanyDTO(2L, "Avis", "Frankfurt", "123456789");
        CarCompanyDTO europCar = new CarCompanyDTO(3L, "EuropCar", "Frankfurt", "123456789");
        List<CarCompanyDTO> carCompanyDTOS = new ArrayList<>();
        carCompanyDTOS.add(hertz);
        carCompanyDTOS.add(avis);
        carCompanyDTOS.add(europCar);
        //When
        List<CarCompany> carCompanies = mapper.mapDTOListToCarCompanyList(carCompanyDTOS);
        //Then
        assertEquals(3, carCompanies.size());
        assertEquals("Hertz", carCompanies.get(0).getCarCompanyName());
        assertEquals("Avis", carCompanies.get(1).getCarCompanyName());
        assertEquals("EuropCar", carCompanies.get(2).getCarCompanyName());
    }
}
