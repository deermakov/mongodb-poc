package poc.mongodb.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@ToString
public class IndividualEntrepreneur extends LegalEntity {

    @DocumentReference
    //@DBRef
    private Individual individual;// Individual is referenced entity !
    private Boolean selfEmployed;
}
