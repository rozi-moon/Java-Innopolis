package ru.inno.java.dto;

import lombok.*;
import ru.inno.java.entity.Card;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationResponse {

    private Long id;
    private String operation;
    private Long transactionAmount;
    private CardResponse card;

}
