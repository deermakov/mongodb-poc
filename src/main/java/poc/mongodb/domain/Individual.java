package poc.mongodb.domain;

import lombok.Data;

/**
 * Полученная сущность
 */
@Data
public class Individual extends Party {
    private String fio;
}
