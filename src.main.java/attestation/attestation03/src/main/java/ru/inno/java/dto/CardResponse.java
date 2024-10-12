package ru.inno.java.dto;

import lombok.*;
import ru.inno.java.constants.CardType;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {

    private Long id;
    private String number;
    private CardType cardType;
    private LocalDate expiryDate;
    private Long balance;
    private Boolean deleted;

}
