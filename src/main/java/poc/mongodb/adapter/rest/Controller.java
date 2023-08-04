package poc.mongodb.adapter.rest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import poc.mongodb.app.impl.deal.GetAllDealsUseCase;
import poc.mongodb.app.impl.deal.SaveDealUseCase;
import poc.mongodb.app.impl.party.GetAllPartiesUseCase;
import poc.mongodb.app.impl.party.SavePartyUseCase;
import poc.mongodb.domain.Deal;
import poc.mongodb.domain.Party;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final SavePartyUseCase savePartyUseCase;
    private final GetAllPartiesUseCase getAllPartiesUseCase;
    private final SaveDealUseCase saveDealUseCase;
    private final GetAllDealsUseCase getAllDealsUseCase;

    @PostMapping("/party/save")
    @Operation
    public void saveParty(@RequestBody Party party) {
        log.info("saveParty(): {}", party);
        savePartyUseCase.execute(party);
    }

    @GetMapping("/party/list")
    public List<Party> getAllParties() {
        return getAllPartiesUseCase.execute();
    }

    @PostMapping("/deal/save")
    @Operation
    public void saveDeal(@RequestBody Deal deal) {
        log.info("saveDeal(): {}", deal);
        saveDealUseCase.execute(deal);
    }

    @GetMapping("/deal/list")
    public List<Deal> getAllDeals() {
        return getAllDealsUseCase.execute();
    }
}
