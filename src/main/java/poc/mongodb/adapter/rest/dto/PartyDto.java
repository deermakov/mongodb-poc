package poc.mongodb.adapter.rest.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import poc.mongodb.domain.*;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
@Data
public abstract class PartyDto {
    private String id;
    private String inn;
    private Address address;

    /*
    Если раскомментировать deals и перегенерить маппер (mvn clean compile),
    то в runtime это приведет к stack overflow в Jackson
     */
    //private List<Deal> deals;
}
