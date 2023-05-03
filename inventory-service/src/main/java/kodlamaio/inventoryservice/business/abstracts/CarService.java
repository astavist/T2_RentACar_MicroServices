package kodlamaio.inventoryservice.business.abstracts;

import kodlamaio.inventoryservice.business.dto.requests.create.CreateCarRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateCarRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateCarResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllCarsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetCarResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateCarResponse;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<GetAllCarsResponse> getAll();

    GetCarResponse getById(UUID id);

    CreateCarResponse add(CreateCarRequest request);

    UpdateCarResponse update(UUID id, UpdateCarRequest request);

    void delete(UUID id);
}
