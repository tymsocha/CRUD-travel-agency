package com.kodilla.travelagency.core.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "car_companies")
public class CarCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company_name")
    private String carCompanyName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phoneNumber;
}
