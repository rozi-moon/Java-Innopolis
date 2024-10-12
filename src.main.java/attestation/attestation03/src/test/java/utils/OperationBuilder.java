package utils;

import ru.inno.java.dto.OperationRequest;
import ru.inno.java.entity.Operation;
import ru.inno.java.entity.User;

import java.time.LocalDateTime;

public class OperationBuilder {

    public static Operation getOperation() {
        User user = UserBuilder.getUser();

        return Operation.builder()
                .id(1L)
                .operationTime(LocalDateTime.now())
                .operation("operation")
                .transactionAmount(100L)
                .user(user)
                .card(CardBuilder.getCard(user))
                .build();
    }

    public static OperationRequest getOperationRequestWithAdding() {
        return OperationRequest.builder()
                .userId(1L)
                .cardId(1L)
                .operation("addMoney")
                .transactionAmount(100L)
                .build();
    }

}
