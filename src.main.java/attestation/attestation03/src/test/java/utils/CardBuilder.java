package utils;

import ru.inno.java.constants.CardType;
import ru.inno.java.dto.CardRequest;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.User;

import java.time.LocalDate;

public class CardBuilder {

    public static CardRequest getCardRequest() {
        return CardRequest.builder()
                .userId(1L)
                .cardType(CardType.DEBIT_CARD)
                .build();
    }

    public static Card getCard(User user) {
        return Card.builder()
                .id(1L)
                .number("someNumber")
                .balance(0L)
                .user(user)
                .cardType(CardType.DEBIT_CARD)
                .expiryDate(LocalDate.now().plusYears(6))
                .deleted(false)
                .build();
    }

}
