package ru.inno.java.utils;

import org.apache.commons.lang3.RandomStringUtils;
import ru.inno.java.constants.CardType;
import ru.inno.java.dto.CardRequest;
import ru.inno.java.dto.CardResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.User;

import java.time.LocalDate;
import java.util.Random;

public class CardUtils {

    public static CardResponse convertCardToCardResponse(Card card) {
        return CardResponse.builder()
                .id(card.getId())
                .number(card.getNumber())
                .expiryDate(card.getExpiryDate())
                .cardType(card.getCardType())
                .balance(card.getBalance())
                .build();
    }

    public static Card convertCardRequestToCard(CardRequest cardRequest, User user) {

        Long balance = cardRequest.getCardType().equals(CardType.CREDIT_CARD) ? (long) (Math.random() * 100000) : 0;
        String cardNumber = RandomStringUtils.randomNumeric(16);
        LocalDate expiryDate = cardRequest.getCardType().equals(CardType.CREDIT_CARD)
                ? LocalDate.now().plusYears(10)
                : LocalDate.now().plusYears(4);

        return Card.builder()
                .number(cardNumber)
                .cardType(cardRequest.getCardType())
                .expiryDate(expiryDate)
                .balance(balance)
                .user(user)
                .deleted(false)
                .build();
    }

}
