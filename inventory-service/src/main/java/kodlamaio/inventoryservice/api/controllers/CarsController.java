package kodlamaio.inventoryservice.api.controllers;

import kodlamaio.inventoryservice.business.abstracts.CarService;
import kodlamaio.inventoryservice.business.dto.requests.create.CreateCarRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateCarRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateCarResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllCarsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetCarResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService service;

    @GetMapping
    public List<GetAllCarsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse add(CreateCarRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse update(UUID id, UpdateCarRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
