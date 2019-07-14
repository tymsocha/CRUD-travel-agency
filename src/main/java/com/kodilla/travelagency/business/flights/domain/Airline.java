package com.kodilla.travelagency.business.flights.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "airlines")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "airline_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phoneNumber;
}
