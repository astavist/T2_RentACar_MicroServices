package kodlamaio.inventoryservice.business.concretes;

import kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import kodlamaio.inventoryservice.business.abstracts.BrandService;
import kodlamaio.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetBrandResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateBrandResponse;
import kodlamaio.inventoryservice.business.rules.BrandRules;
import kodlamaio.inventoryservice.entities.Brand;
import kodlamaio.inventoryservice.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository repository;
    private final ModelMapperService mapper;
    private final BrandRules rules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        var brands = repository.findAll();
        var response = brands.stream().map(brand -> mapper.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
        return response;
    }

    @Override
    public GetBrandResponse getById(UUID id) {
        rules.checkIfBrandExists(id);
        var brand = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(brand, GetBrandResponse.class);
        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        var brand = mapper.forResponse().map(request, Brand.class);
        brand.setId(null);
        repository.save(brand);
        var response = mapper.forResponse().map(brand, CreateBrandResponse.class);
        return response;
    }

    @Override
    public UpdateBrandResponse update(UUID id, UpdateBrandRequest request) {
        rules.checkIfBrandExists(id);
        var brand = mapper.forResponse().map(request, Brand.class);
        brand.setId(id);
        repository.save(brand);
        var response = mapper.forResponse().map(brand, UpdateBrandResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfBrandExists(id);
        repository.deleteById(id);
    }
}
