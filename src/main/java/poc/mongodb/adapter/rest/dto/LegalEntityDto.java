package poc.mongodb.adapter.rest.dto;

import lombok.Data;

@Data
public class LegalEntityDto extends PartyDto {
    private String name;
}
