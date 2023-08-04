package poc.mongodb.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
public class IndividualEntrepreneur extends LegalEntity {

    @DocumentReference
    //@DBRef
    private Individual individual;// Individual is referenced entity !
    private Boolean selfEmployed;
}
