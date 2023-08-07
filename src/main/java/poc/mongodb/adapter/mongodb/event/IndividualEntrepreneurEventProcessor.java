package poc.mongodb.adapter.mongodb.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import poc.mongodb.adapter.mongodb.repository.PartyRepository;
import poc.mongodb.app.impl.BeanMerger;
import poc.mongodb.domain.Individual;
import poc.mongodb.domain.IndividualEntrepreneur;
import poc.mongodb.domain.Party;

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
        updateIndividual(individualEntrepreneur.getIndividual());
    }

    /** Обновление существующего ФЛ сделано чисто для примера, только в этом сценарии.
     * Реализовано на скорую руку с помощью BeanMerger, возможно в MongoDB
     * есть готовые механизмы... */
    private void updateIndividual(Individual individual) {
        if (individual.getId() != null) {
            Party updatedIndividual = partyRepository
                .findById(individual.getId())
                .map(party -> (Party) BeanMerger.deepMerge(individual, party))
                .orElse(individual);
            partyRepository.save(updatedIndividual);
        } else {
            partyRepository.save(individual);
        }
    }
}
