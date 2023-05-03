package kodlamaio.inventoryservice.business.concretes;

import kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import kodlamaio.inventoryservice.business.abstracts.CarService;
import kodlamaio.inventoryservice.business.dto.requests.create.CreateCarRequest;
import kodlamaio.inventoryservice.business.dto.requests.update.UpdateCarRequest;
import kodlamaio.inventoryservice.business.dto.responses.create.CreateCarResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetAllCarsResponse;
import kodlamaio.inventoryservice.business.dto.responses.get.GetCarResponse;
import kodlamaio.inventoryservice.business.dto.responses.update.UpdateCarResponse;
import kodlamaio.inventoryservice.business.rules.CarRules;
import kodlamaio.inventoryservice.entities.Car;
import kodlamaio.inventoryservice.entities.enums.State;
import kodlamaio.inventoryservice.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final ModelMapperService mapper;
    private final CarRepository repository;
    private final CarRules rules;

    @Override
    public List<GetAllCarsResponse> getAll() {
        var cars = repository.findAll();
        var response = cars.stream().map(car -> mapper.forResponse().map(car, GetAllCarsResponse.class)).toList();
        return response;
    }

    @Override
    public GetCarResponse getById(UUID id) {
        rules.checkIfCarExists(id);
        var car = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(car, GetCarResponse.class);
        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        var car = mapper.forResponse().map(request, Car.class);

        car.setId(null);
        car.setState(State.Available);
        repository.save(car);

        var response = mapper.forResponse().map(car, CreateCarResponse.class);
        return response;
    }

    @Override
    public UpdateCarResponse update(UUID id, UpdateCarRequest request) {
        rules.checkIfCarExists(id);
        var car = mapper.forResponse().map(request, Car.class);

        car.setId(id);
        repository.save(car);

        var response = mapper.forResponse().map(car, UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfCarExists(id);
        repository.deleteById(id);
    }
}
