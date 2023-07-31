package poc.mongodb.domain;

import lombok.Data;

@Data
public class LegalEntity extends Party {
    private String name;
}
