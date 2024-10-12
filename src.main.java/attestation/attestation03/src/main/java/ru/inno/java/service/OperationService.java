package ru.inno.java.service;

import ru.inno.java.dto.OperationRequest;
import ru.inno.java.dto.OperationResponse;

import java.util.List;

public interface OperationService {

    OperationResponse getById(Long id);

    List<OperationResponse> getOperationByUserId(Long userId);

    OperationResponse addOperation(OperationRequest operationRequest);
}
