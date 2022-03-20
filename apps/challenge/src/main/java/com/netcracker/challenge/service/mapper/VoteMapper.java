package com.netcracker.challenge.service.mapper;

import com.netcracker.challenge.db.entity.VoteEntity;
import com.netcracker.challenge.service.model.VoteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    @Mapping(target = "votingId", source = "id.votingId")
    @Mapping(target = "userId", source = "id.userId")
    VoteDto fromEntity(VoteEntity entity);

    @Mapping(target = "id.votingId", source = "votingId")
    @Mapping(target = "id.userId", source = "userId")
    VoteEntity toEntity(VoteDto dto);

}
