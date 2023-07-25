package poc.mongodb.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.mongodb.app.impl.StoreDataUseCase;
import poc.mongodb.domain.Entity;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final StoreDataUseCase storeDataUseCase;

    @PutMapping("/put")
    public void putData(Entity entity){
        storeDataUseCase.execute(entity);
    }
}
