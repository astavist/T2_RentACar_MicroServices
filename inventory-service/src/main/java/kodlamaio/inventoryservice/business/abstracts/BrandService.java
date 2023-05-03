package kodlamaio.inventoryservice.business.abstracts;

import kodlamaio.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetBrandResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateBrandResponse;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetBrandResponse getById(UUID id);

    CreateBrandResponse add(CreateBrandRequest request);

    UpdateBrandResponse update(UUID id, UpdateBrandRequest request);

    void delete(UUID id);
}
