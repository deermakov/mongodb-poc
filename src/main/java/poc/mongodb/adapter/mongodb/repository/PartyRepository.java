package poc.mongodb.adapter.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import poc.mongodb.domain.Party;

public interface PartyRepository extends MongoRepository<Party, String> {
}
