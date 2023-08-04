package poc.mongodb.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(Individual.class),
    @JsonSubTypes.Type(IndividualEntrepreneur.class),
    @JsonSubTypes.Type(LegalEntity.class)
})
@Document("party")
@Getter
public abstract class Party {
    @Id
    private String id;// автогенерация из коробки поддерживается для типов String, BigInteger, ObjectId
    private String inn;
    private Address address;
}
