package com.netcracker.challenge.service.mapper;

import com.netcracker.challenge.db.entity.ChallengeRecordEntity;
import com.netcracker.challenge.service.model.ChallengeRecordCreateDto;
import com.netcracker.challenge.service.model.ChallengeRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChallengeRecordMapper {

    ChallengeRecordDto fromEntity(ChallengeRecordEntity entity);

    ChallengeRecordEntity toEntity(ChallengeRecordDto dto);

    ChallengeRecordEntity toEntity(ChallengeRecordCreateDto dto);

    void merge(ChallengeRecordDto dto, @MappingTarget ChallengeRecordEntity entity);

}
