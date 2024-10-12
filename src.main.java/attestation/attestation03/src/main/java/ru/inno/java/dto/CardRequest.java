package ru.inno.java.dto;

import lombok.*;
import ru.inno.java.constants.CardType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {

    private Long userId;
    private CardType cardType;

}
