package kodlamaio.inventoryservice.business.rules;

import kodlamaio.inventoryservice.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class CarRules {
    private final CarRepository repository;

    public void checkIfCarExists(UUID id) {
        if (!repository.existsById(id)) {
            //TODO:BusinessException
            throw new RuntimeException("CAR_NOT_EXISTS");
        }
    }
}
