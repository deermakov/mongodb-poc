package poc.mongodb.adapter.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import poc.mongodb.domain.Party;

@Data
public class LegalEntityDto extends PartyDto {
    private String name;
}
