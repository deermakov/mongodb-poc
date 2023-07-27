package poc.mongodb.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import poc.mongodb.app.impl.GetAllPartiesUseCase;
import poc.mongodb.app.impl.SavePartyUseCase;
import poc.mongodb.domain.Party;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final SavePartyUseCase savePartyUseCase;
    private final GetAllPartiesUseCase getAllPartiesUseCase;

    @PostMapping("/save")
    public void saveParty(@RequestBody Party party) {
        savePartyUseCase.execute(party);
    }

    @GetMapping("/list")
    public List<Party> getAllParties(){
        return getAllPartiesUseCase.execute();
    }
}
