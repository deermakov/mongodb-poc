package poc.mongodb.adapter.rest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import poc.mongodb.app.impl.GetAllPartiesUseCase;
import poc.mongodb.app.impl.SavePartyUseCase;
import poc.mongodb.domain.Party;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final SavePartyUseCase savePartyUseCase;
    private final GetAllPartiesUseCase getAllPartiesUseCase;

    @PostMapping("/save")
    @Operation
    public void saveParty(@RequestBody Party party) {
        log.info("saveParty(): {}", party);
        savePartyUseCase.execute(party);
    }

    @GetMapping("/list")
    public List<Party> getAllParties() {
        return getAllPartiesUseCase.execute();
    }
}
