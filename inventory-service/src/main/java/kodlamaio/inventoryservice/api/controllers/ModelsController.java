package kodlamaio.inventoryservice.api.controllers;

import kodlamaio.inventoryservice.business.abstracts.ModelService;
import kodlamaio.inventoryservice.business.dto.requests.create.CreateModelRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateModelRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateModelResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllModelsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetModelResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService service;

    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(CreateModelRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateModelResponse update(UUID id, UpdateModelRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
