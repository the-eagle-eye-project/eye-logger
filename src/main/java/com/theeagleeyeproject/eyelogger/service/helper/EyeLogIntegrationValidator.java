package com.theeagleeyeproject.eyelogger.service.helper;

import com.theeagleeyeproject.eyelogger.client.EyeMetaClientResponse;
import com.theeagleeyeproject.eyelogger.client.EyeRegisterClient;
import com.theeagleeyeproject.eyelogger.exception.ExceptionCategory;
import com.theeagleeyeproject.eyelogger.exception.GlobalApplicationException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EyeLogIntegrationValidator {

    private final EyeRegisterClient eyeRegisterClient;

    public void validateIntegrationId(String integrationId) {
        if (!StringUtils.isBlank(integrationId)) {
            EyeMetaClientResponse eyeMetaClientResponse = eyeRegisterClient.getMetadata(integrationId);
            if (eyeMetaClientResponse == null || !eyeMetaClientResponse.isActive()) {
                throw new GlobalApplicationException(ExceptionCategory.DATA_NOT_FOUND, "No integration id found or is not active.");
            }
        } else {
            throw new GlobalApplicationException(ExceptionCategory.VALIDATION_ERROR, "Integration Id not found in the request.");
        }
    }
}
