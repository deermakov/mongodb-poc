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

@Component
@RequiredArgsConstructor
@Slf4j
public class IndividualEntrepreneurEventProcessor extends AbstractMongoEventListener<IndividualEntrepreneur> {
    private final PartyRepository partyRepository;

    /**
     * Spring Data MongoDB doesn't support cascade save,
     * so we have to perform it explicitly
     */
    @Override
    public void onBeforeConvert(BeforeConvertEvent<IndividualEntrepreneur> event) {
        IndividualEntrepreneur individualEntrepreneur = event.getSource();
        updateIndividual(individualEntrepreneur.getIndividual());
    }

    /**
     * Пример обновления существующего ФЛ с помощью BeanMerger
     */
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
