package poc.mongodb.domain;

import lombok.Data;

@Data
public class IndividualEntrepreneur extends LegalEntity {
    private Individual individual;

    private Boolean selfEmployed;
}
