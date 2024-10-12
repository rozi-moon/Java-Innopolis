package ru.inno.java.service;

import ru.inno.java.dto.CardRequest;
import ru.inno.java.dto.CardResponse;

import java.util.List;

public interface CardService {

    CardResponse createCard(CardRequest cardRequest);

    void archiveCard(Long cardId);
}
