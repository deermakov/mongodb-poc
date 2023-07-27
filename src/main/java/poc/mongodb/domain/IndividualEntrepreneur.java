package poc.mongodb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class IndividualEntrepreneur extends LegalEntity {
    private Individual individual;

    private Boolean selfEmployed;
}
