package com.turkcell.filterservice.repository;

import com.turkcell.filterservice.entities.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface FilterRepository extends MongoRepository<Filter, String> {
    void deleteByCarId(UUID carId);

    void deleteAllByBrandId(UUID brandId);

    void deleteAllByModelId(UUID modelId);

    Filter findByCarId(UUID carId);
}
