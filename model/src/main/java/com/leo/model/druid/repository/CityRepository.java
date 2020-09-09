package com.leo.model.druid.repository;

import com.leo.model.druid.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {

    void deleteByCityId(String id);

    City findByCityId(String id);
}