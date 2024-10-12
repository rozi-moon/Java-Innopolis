package ru.inno.java.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.java.dto.CardRequest;
import ru.inno.java.dto.CardResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.User;
import ru.inno.java.repository.CardRepository;
import ru.inno.java.repository.UserRepository;
import ru.inno.java.service.CardService;
import ru.inno.java.utils.CardUtils;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final UserRepository userRepository;
    private final CardRepository cardRepository;

    @Override
    public CardResponse createCard(CardRequest cardRequest) {
        User user = userRepository.findById(cardRequest.getUserId()).orElseThrow(NoSuchElementException::new);
        Card card = CardUtils.convertCardRequestToCard(cardRequest, user);
        Card savedCard = cardRepository.saveAndFlush(card);
        return CardUtils.convertCardToCardResponse(savedCard);
    }

    @Override
    public void archiveCard(Long cardId) {
        cardRepository.softDelete(cardId);
    }
}
