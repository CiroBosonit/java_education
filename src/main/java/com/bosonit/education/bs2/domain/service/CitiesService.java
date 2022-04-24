package com.bosonit.education.bs2.domain.service;

import com.bosonit.education.bs2.domain.entity.City;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitiesService {

  @Getter
  private List<City> cities = new ArrayList<>();

  public CitiesService() {

    City c1 = new City("Madrid", 3_400_000);
    City c2 = new City("Barcelona", 1_700_000);
    this.cities.add(c1);
    this.cities.add(c2);

  }

  public City addCity(String name, int population) {

    City newCity = new City(name, population);
    this.cities.add(newCity);

    return newCity;
  }

}
