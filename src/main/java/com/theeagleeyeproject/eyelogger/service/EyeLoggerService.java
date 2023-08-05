package com.theeagleeyeproject.eyelogger.service;

import com.theeagleeyeproject.eyelogger.entity.EyeLogEntity;
import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceRequest;
import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceResponse;
import com.theeagleeyeproject.eyelogger.repository.EyeLogRepository;
import com.theeagleeyeproject.eyelogger.service.helper.EyeLogIntegrationValidator;
import com.theeagleeyeproject.eyelogger.service.mapper.EyeLogMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EyeLoggerService {

    // Mapper to do model conversion.
    private final EyeLogMapper eyeLogMapper = Mappers.getMapper(EyeLogMapper.class);

    private final EyeLogRepository eyeLogRepository;

    private final EyeLogIntegrationValidator eyeLogIntegrationValidator;

    public EyeLoggerServiceResponse saveLog(EyeLoggerServiceRequest eyeLoggerServiceRequest) {
        // Validate the request integration id
        eyeLogIntegrationValidator.validateIntegrationId(eyeLoggerServiceRequest.getIntegrationId());
        // Convert to entity and save into the index.
        EyeLogEntity eyeLogEntity = eyeLogMapper.eyeLogServiceRequestToEyeLogEntity(eyeLoggerServiceRequest);
        EyeLogEntity savedEyeLogEntity = eyeLogRepository.save(eyeLogEntity);
        // Return response back to the consumer.
        return eyeLogMapper.eyeLogEntityToEyeLoggerServiceResponse(savedEyeLogEntity);
    }
}
