package poc.mongodb.app.api;

import poc.mongodb.domain.Party;

import java.util.List;
import java.util.Optional;

/**
 * todo Document type Storage
 */
public interface Storage {
    void saveParty(Party party);
    List<Party> getAllParties();
    Optional<Party> getParty(Long id);
}
