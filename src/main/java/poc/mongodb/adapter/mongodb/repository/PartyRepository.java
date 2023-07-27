package poc.mongodb.adapter.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import poc.mongodb.domain.Party;

/**
 * todo Document type PartyRepository
 */
public interface PartyRepository extends MongoRepository<Party, Long> {
}
