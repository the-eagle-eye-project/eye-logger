package com.theeagleeyeproject.eyelogger.service;

import com.theeagleeyeproject.eyelogger.entity.EyeLogEntity;
import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceRequest;
import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceResponse;
import com.theeagleeyeproject.eyelogger.repository.EyeLogRepository;
import com.theeagleeyeproject.eyelogger.service.mapper.EyeLogMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EyeLoggerService {

    private final EyeLogMapper eyeLogMapper = Mappers.getMapper(EyeLogMapper.class);

    private final EyeLogRepository eyeLogRepository;

    public EyeLoggerServiceResponse saveLog(EyeLoggerServiceRequest eyeLoggerServiceRequest) {
        EyeLogEntity eyeLogEntity = eyeLogMapper.eyeLogServiceRequestToEyeLogEntity(eyeLoggerServiceRequest);
        EyeLogEntity savedEyeLogEntity = eyeLogRepository.save(eyeLogEntity);
        return eyeLogMapper.eyeLogEntityToEyeLoggerServiceResponse(savedEyeLogEntity);
    }
}
