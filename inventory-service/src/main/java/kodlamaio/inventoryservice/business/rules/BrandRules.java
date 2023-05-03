package kodlamaio.inventoryservice.business.rules;

import kodlamaio.inventoryservice.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandRules {
    private final BrandRepository repository;

    public void checkIfBrandExists(UUID id) {
        if (!repository.existsById(id)) {
            //TODO:BusinessException
            throw new RuntimeException("BRAND_NOT_EXISTS");
        }
    }
}
