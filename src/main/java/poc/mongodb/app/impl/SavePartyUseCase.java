package poc.mongodb.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.mongodb.app.api.Storage;
import poc.mongodb.domain.Party;

/**
 * todo Document type SavePartyUseCase
 */
@Component
@RequiredArgsConstructor
public class SavePartyUseCase {
    private final Storage storage;
    public void execute(Party party) {
        storage.saveParty(party);
    }
}
