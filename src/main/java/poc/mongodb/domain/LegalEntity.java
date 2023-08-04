package poc.mongodb.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LegalEntity extends Party {
    private String name;
}
