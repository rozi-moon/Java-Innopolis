package ru.inno.java.utils;

import ru.inno.java.dto.OperationRequest;
import ru.inno.java.dto.OperationResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.Operation;
import ru.inno.java.entity.User;
import ru.inno.java.exception.NotPossibleOperationException;

import java.time.LocalDateTime;

public class OperationUtils {

    public static OperationResponse convertToOperationResponse(Operation operation) {
        return OperationResponse.builder()
                .id(operation.getId())
                .transactionAmount(operation.getTransactionAmount())
                .operation(operation.getOperation())
                .card(CardUtils.convertCardToCardResponse(operation.getCard()))
                .build();
    }

    public static Operation convertToOperation(OperationRequest operationRequest, User user, Card card) {
        if (card.getBalance() + operationRequest.getTransactionAmount() < 0) {
            throw new NotPossibleOperationException("Не возможно выполнить данную операцию, баланс на карте не достаточный");
        }

        if (card.getDeleted()) {
            throw new NotPossibleOperationException("Не возможно выполнить данную операцию, карта деактивирована");
        }

        card.setBalance(card.getBalance() + operationRequest.getTransactionAmount());

        return Operation.builder()
                .operation(operationRequest.getOperation())
                .transactionAmount(operationRequest.getTransactionAmount())
                .operationTime(LocalDateTime.now())
                .card(card)
                .user(user)
                .build();
    }

}
