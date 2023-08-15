package poc.mongodb.adapter.rest.mapper;

import org.mapstruct.Mapper;
import poc.mongodb.adapter.rest.dto.IndividualDto;
import poc.mongodb.adapter.rest.dto.LegalEntityDto;
import poc.mongodb.domain.Individual;
import poc.mongodb.domain.LegalEntity;

@Mapper(componentModel = "spring")
public interface PartyMapper {

    LegalEntityDto leToDto(LegalEntity legalEntity);

    IndividualDto indToDto(Individual individual);
}
