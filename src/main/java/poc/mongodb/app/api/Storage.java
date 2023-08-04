package poc.mongodb.app.api;

import poc.mongodb.domain.Deal;
import poc.mongodb.domain.Party;

import java.util.List;
import java.util.Optional;

public interface Storage {
    void saveParty(Party party);

    List<Party> getAllParties();

    Optional<Party> getParty(String id);

    void saveDeal(Deal deal);

    List<Deal> getAllDeals();
}
