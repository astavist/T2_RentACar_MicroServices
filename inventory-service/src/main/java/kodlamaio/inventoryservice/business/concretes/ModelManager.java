package kodlamaio.inventoryservice.business.concretes;

import kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import kodlamaio.inventoryservice.business.abstracts.ModelService;
import kodlamaio.inventoryservice.business.dto.requests.create.CreateModelRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateModelRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateModelResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllModelsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetModelResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateModelResponse;
import kodlamaio.inventoryservice.business.rules.ModelRules;
import kodlamaio.inventoryservice.entities.Model;
import kodlamaio.inventoryservice.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapperService mapper;
    private final ModelRules rules;

    @Override
    public List<GetAllModelsResponse> getAll() {
        var models = repository.findAll();
        var response = models.stream().map(Model -> mapper.forResponse().map(Model, GetAllModelsResponse.class)).toList();
        return response;
    }

    @Override
    public GetModelResponse getById(UUID id) {
        rules.checkIfModelExists(id);
        var model = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(model, GetModelResponse.class);
        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        var model = mapper.forResponse().map(request, Model.class);
        model.setId(null);
        repository.save(model);
        var response = mapper.forResponse().map(model, CreateModelResponse.class);
        return response;
    }

    @Override
    public UpdateModelResponse update(UUID id, UpdateModelRequest request) {
        rules.checkIfModelExists(id);
        var model = mapper.forResponse().map(request, Model.class);
        model.setId(id);
        repository.save(model);
        var response = mapper.forResponse().map(model, UpdateModelResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfModelExists(id);
        repository.deleteById(id);
    }
}
