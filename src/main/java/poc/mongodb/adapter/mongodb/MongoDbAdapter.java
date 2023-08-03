package poc.mongodb.adapter.mongodb;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import poc.mongodb.adapter.mongodb.repository.PartyRepository;
import poc.mongodb.app.api.Storage;
import poc.mongodb.domain.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * todo Document type MongoDbAdapter
 */
@Component
@RequiredArgsConstructor
public class MongoDbAdapter implements Storage {
    private final PartyRepository partyRepository;

    @Override
    public void saveParty(Party party) {
        partyRepository.save(party);
    }

    @Override
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public Optional<Party> getParty(ObjectId id) {
        return partyRepository.findById(id);
    }
}
