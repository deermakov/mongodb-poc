package poc.mongodb.adapter.mongodb.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import poc.mongodb.adapter.mongodb.repository.PartyRepository;
import poc.mongodb.domain.Individual;
import poc.mongodb.domain.IndividualEntrepreneur;

/**
 * Spring Data MongoDB doesn't support cascade save, so we have to perform it explicitly
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class IndividualEntrepreneurEventProcessor extends AbstractMongoEventListener<IndividualEntrepreneur> {
    private final PartyRepository partyRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<IndividualEntrepreneur> event) {
        IndividualEntrepreneur individualEntrepreneur = event.getSource();
        Individual savedIndividual = partyRepository.save(individualEntrepreneur.getIndividual());
        log.info("savedIndividual: {}", savedIndividual.getId());
    }
}
