package ru.inno.java.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.inno.java.dto.CardRequest;
import ru.inno.java.dto.CardResponse;
import ru.inno.java.service.CardService;

//Этот код реализует контроллер для работы с картами в приложении на Java
// с использованием Spring Framework и Lombok. Рассмотрим каждую часть кода и добавим комментарии:

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @Operation(description = "Добавление карты для пользователя")
    @PostMapping
    public CardResponse addCardToUser(@RequestBody CardRequest cardRequest) {
        return cardService.createCard(cardRequest);
    }

    @Operation(description = "Архивирование карты пользователя")
    @DeleteMapping("/{id}")
    public void archiveCard(@PathVariable("id") Long cardId) {
        cardService.archiveCard(cardId);
    }
}
