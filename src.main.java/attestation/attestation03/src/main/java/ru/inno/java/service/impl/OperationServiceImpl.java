package ru.inno.java.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.java.dto.OperationRequest;
import ru.inno.java.dto.OperationResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.Operation;
import ru.inno.java.entity.User;
import ru.inno.java.repository.CardRepository;
import ru.inno.java.repository.OperationRepository;
import ru.inno.java.repository.UserRepository;
import ru.inno.java.service.OperationService;
import ru.inno.java.utils.OperationUtils;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Override
    public OperationResponse getById(Long id) {
        Operation operation = operationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return OperationUtils.convertToOperationResponse(operation);
    }

    @Override
    public List<OperationResponse> getOperationByUserId(Long userId) {
        List<Operation> operations = operationRepository.findAllByUserId(userId);
        return operations.stream()
                .map(OperationUtils::convertToOperationResponse)
                .toList();
    }

    @Override
    public OperationResponse addOperation(OperationRequest operationRequest) {
        Card card = cardRepository.findById(operationRequest.getCardId()).orElseThrow();
        User user = userRepository.findById(operationRequest.getUserId()).orElseThrow();
        Operation operation = OperationUtils.convertToOperation(operationRequest, user, card);
        cardRepository.saveAndFlush(card);
        Operation savedOperation = operationRepository.saveAndFlush(operation);

        return OperationUtils.convertToOperationResponse(savedOperation);
    }
}
