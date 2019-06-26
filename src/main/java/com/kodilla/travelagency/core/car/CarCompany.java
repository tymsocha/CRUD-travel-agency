package com.kodilla.travelagency.core.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "car_companies")
public class CarCompany {
}
