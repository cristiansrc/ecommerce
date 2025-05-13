package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.City;
import com.umb.laura.aviles.ecommerce.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    public List<City> findAllXDeparment(Integer deparmentId) {
        return cityRepository.findAllXDeparment(deparmentId);
    }
}
