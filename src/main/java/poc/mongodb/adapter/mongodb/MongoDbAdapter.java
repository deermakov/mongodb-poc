package poc.mongodb.adapter.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.mongodb.adapter.mongodb.repository.PartyRepository;
import poc.mongodb.app.api.Storage;
import poc.mongodb.domain.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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
        List<Party> list = new ArrayList<>();
        partyRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Party> getParty(Long id) {
        return partyRepository.findById(id);
    }
}
