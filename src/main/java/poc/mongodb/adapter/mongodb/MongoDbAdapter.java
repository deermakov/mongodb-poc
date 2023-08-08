package poc.mongodb.adapter.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.mongodb.adapter.mongodb.repository.DealRepository;
import poc.mongodb.adapter.mongodb.repository.PartyRepository;
import poc.mongodb.app.api.Storage;
import poc.mongodb.domain.Deal;
import poc.mongodb.domain.Party;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MongoDbAdapter implements Storage {
    private final PartyRepository partyRepository;
    private final DealRepository dealRepository;

    @Override
    public void saveParty(Party party) {
        partyRepository.save(party);
    }

    @Override
    public List<Party> getAllParties() {
        List<Party> list = partyRepository.findAll();
        list.forEach(party -> party.getDeals().forEach(
                deal -> deal.setParticipants(null)
            )
        );
        return list;
    }

    @Override
    public Optional<Party> getParty(String id) {
        return partyRepository.findById(id);
    }

    @Override
    public void saveDeal(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public List<Deal> getAllDeals() {
        List<Deal> list = dealRepository.findAll();
        list.forEach(deal -> deal.getParticipants().forEach(
                party -> party.setDeals(null)
            )
        );
        return list;
    }
}
