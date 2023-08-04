package poc.mongodb.app.impl.deal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.mongodb.app.api.Storage;
import poc.mongodb.domain.Deal;

@Component
@RequiredArgsConstructor
public class SaveDealUseCase {
    private final Storage storage;

    public void execute(Deal deal) {
        storage.saveDeal(deal);
    }
}
