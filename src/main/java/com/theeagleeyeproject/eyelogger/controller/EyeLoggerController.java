package com.theeagleeyeproject.eyelogger.controller;

import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceRequest;
import com.theeagleeyeproject.eyelogger.model.EyeLoggerServiceResponse;
import com.theeagleeyeproject.eyelogger.service.EyeLoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/eye/logs")
@RequiredArgsConstructor
public class EyeLoggerController {

    private final EyeLoggerService eyeLoggerService;

    @PostMapping
    public ResponseEntity<EyeLoggerServiceResponse> createLog(@RequestHeader HttpHeaders headers, @Valid @RequestBody EyeLoggerServiceRequest eyeLoggerServiceRequest) {
        return createResponseEntity(eyeLoggerService.saveLog(eyeLoggerServiceRequest));
    }

    // Creates the response entity object for all the controller methods in this class.
    private <O> ResponseEntity<O> createResponseEntity(O response) {
        return response != null ? ResponseEntity.ok(response) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
