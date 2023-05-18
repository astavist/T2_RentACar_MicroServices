package com.turkcell.filterservice.business.abstracts;

import com.turkcell.filterservice.business.dto.responses.GetAllFiltersResponse;
import com.turkcell.filterservice.business.dto.responses.GetFilterResponse;
import com.turkcell.filterservice.entities.Filter;

import java.util.List;
import java.util.UUID;

public interface FilterService {
    List<GetAllFiltersResponse> getAll();

    GetFilterResponse getById(String id);

    void add(Filter filter);

    void delete(String id);

    void deleteByCarId(UUID carId);

    void deleteAllByBrandId(UUID brandId);

    void deleteAllByModelId(UUID modelId);

    Filter getByCarId(UUID carId);
}
