package com.theeagleeyeproject.eyelogger.service.mapper;

import com.theeagleeyeproject.eyelogger.entity.EyeLogEntity;
import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceRequest;
import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EyeLogMapper {

    @Mapping(target = "transactionId", expression = "java(java.util.UUID.randomUUID().toString())")
    EyeLogEntity eyeLogServiceRequestToEyeLogEntity(EyeLoggerServiceRequest eyeLoggerServiceRequest);

    EyeLoggerServiceResponse eyeLogEntityToEyeLoggerServiceResponse(EyeLogEntity eyeLogEntity);

}
