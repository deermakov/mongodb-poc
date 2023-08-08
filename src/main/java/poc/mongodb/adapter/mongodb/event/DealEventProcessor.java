package poc.mongodb.adapter.mongodb.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import poc.mongodb.adapter.mongodb.repository.PartyRepository;
import poc.mongodb.domain.Deal;

/**
 * Spring Data MongoDB doesn't support cascade save, so we have to perform it explicitly
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DealEventProcessor extends AbstractMongoEventListener<Deal> {
    private final PartyRepository partyRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Deal> event) {
        Deal deal = event.getSource();
        partyRepository.saveAll(deal.getParticipants());
    }
}
