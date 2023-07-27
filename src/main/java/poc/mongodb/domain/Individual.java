package poc.mongodb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Полученная сущность
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Individual extends Party {
    private String fio;
}
