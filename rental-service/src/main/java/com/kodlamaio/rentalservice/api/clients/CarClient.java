package com.kodlamaio.rentalservice.api.clients;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import com.kodlamaio.commonpackage.utils.dto.GetCarResponse;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "inventory-service", fallback = CarClientFallback.class)
public interface CarClient {
    @Retry(name = "rentalToInventory")
    @GetMapping(value = "/api/cars/check-car-available/{id}")
    ClientResponse checkIfCarAvailable(@PathVariable UUID id);

    @GetMapping(value = "/api/cars/feign/{id}")
    GetCarResponse getById(@PathVariable UUID id);
}
