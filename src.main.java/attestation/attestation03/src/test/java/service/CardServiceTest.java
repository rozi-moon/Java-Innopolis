package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.inno.java.dto.CardRequest;
import ru.inno.java.dto.CardResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.User;
import ru.inno.java.repository.CardRepository;
import ru.inno.java.repository.UserRepository;
import ru.inno.java.service.CardService;
import ru.inno.java.service.impl.CardServiceImpl;
import utils.CardBuilder;
import utils.UserBuilder;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = CardServiceImpl.class)
public class CardServiceTest {

    @Autowired
    private CardService cardService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CardRepository cardRepository;

    @Test
    void createCardTest() {
        CardRequest request = CardBuilder.getCardRequest();

        User user = UserBuilder.getUser();

        Card card = CardBuilder.getCard(user);

        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Mockito.when(cardRepository.saveAndFlush(any(Card.class))).thenReturn(card);

        CardResponse savedCard = cardService.createCard(request);

        Assertions.assertEquals(savedCard.getCardType(), request.getCardType());
        Assertions.assertNotNull(savedCard.getBalance());
        Assertions.assertNotNull(savedCard.getId());
    }

    @Test
    void createCardWithError() {
        CardRequest request = CardBuilder.getCardRequest();
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> cardService.createCard(request));
    }

    @Test
    void archiveCard() {
        Long cardId = 1L;

        Assertions.assertDoesNotThrow(() -> cardService.archiveCard(cardId));
    }
}
