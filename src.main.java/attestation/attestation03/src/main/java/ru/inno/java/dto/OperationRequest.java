package ru.inno.java.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequest {

    private Long userId;
    private String operation;
    private Long cardId;
    private Long transactionAmount;

}
