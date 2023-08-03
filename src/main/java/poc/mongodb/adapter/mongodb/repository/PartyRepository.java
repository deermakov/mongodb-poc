package poc.mongodb.adapter.mongodb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import poc.mongodb.domain.Party;

/**
 * todo Document type PartyRepository
 */
public interface PartyRepository extends MongoRepository<Party, ObjectId> {
}
