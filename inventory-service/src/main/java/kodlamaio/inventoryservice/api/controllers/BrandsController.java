package kodlamaio.inventoryservice.api.controllers;

import kodlamaio.inventoryservice.business.abstracts.BrandService;
import kodlamaio.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetBrandResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService service;

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(CreateBrandRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse update(UUID id, UpdateBrandRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
