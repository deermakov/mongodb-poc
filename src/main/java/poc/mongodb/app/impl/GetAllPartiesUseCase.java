package poc.mongodb.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.mongodb.app.api.Storage;
import poc.mongodb.domain.Party;

import java.util.List;

/**
 * todo Document type SavePartyUseCase
 */
@Component
@RequiredArgsConstructor
public class GetAllPartiesUseCase {
    private final Storage storage;

    public List<Party> execute() {
        return storage.getAllParties();
    }
}
