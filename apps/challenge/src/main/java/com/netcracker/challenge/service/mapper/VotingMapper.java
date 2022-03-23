package com.netcracker.challenge.service.mapper;

import com.netcracker.challenge.db.entity.VotingEntity;
import com.netcracker.challenge.service.model.VotingCreateDto;
import com.netcracker.challenge.service.model.VotingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VotingMapper {

    @Mapping(target = "challengeId", source = "challengeRecord.id")
    VotingDto fromEntity(VotingEntity entity);

    VotingEntity toEntity(VotingDto dto);

    @Mapping(target = "challengeRecord.id", source = "challengeId")
    VotingEntity toEntity(VotingCreateDto dto);

    void merge(VotingDto dto, @MappingTarget VotingEntity entity);

}
