package ru.inno.java.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.inno.java.dto.OperationRequest;
import ru.inno.java.dto.OperationResponse;
import ru.inno.java.service.OperationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operations")
public class OperationController {

    private final OperationService operationService;

    @Operation(description = "Получение данных об операции")
    @GetMapping("/{id}")
    public OperationResponse getById(@PathVariable("id") Long id) {
        return operationService.getById(id);
    }

    @Operation(description = "Получение списка операций пользователя")
    @GetMapping("/user/{userId}")
    public List<OperationResponse> getOperationByUserId(@PathVariable("userId") Long userId) {
        return operationService.getOperationByUserId(userId);
    }

    @Operation(description = "Добавление операции пользователя")
    @PostMapping
    public OperationResponse addOperation(OperationRequest operationRequest) {
        return operationService.addOperation(operationRequest);
    }

}
