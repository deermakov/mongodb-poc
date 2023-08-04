package poc.mongodb.adapter.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import poc.mongodb.domain.Deal;

public interface DealRepository extends MongoRepository<Deal, String> {
}
