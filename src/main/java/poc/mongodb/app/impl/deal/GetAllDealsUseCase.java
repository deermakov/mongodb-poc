package poc.mongodb.app.impl.deal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.mongodb.app.api.Storage;
import poc.mongodb.domain.Deal;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllDealsUseCase {
    private final Storage storage;

    public List<Deal> execute() {
        return storage.getAllDeals();
    }
}
