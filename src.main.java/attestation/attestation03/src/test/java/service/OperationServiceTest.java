package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.inno.java.dto.OperationRequest;
import ru.inno.java.dto.OperationResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.Operation;
import ru.inno.java.entity.User;
import ru.inno.java.repository.CardRepository;
import ru.inno.java.repository.OperationRepository;
import ru.inno.java.repository.UserRepository;
import ru.inno.java.service.OperationService;
import ru.inno.java.service.impl.OperationServiceImpl;
import utils.CardBuilder;
import utils.OperationBuilder;
import utils.UserBuilder;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = OperationServiceImpl.class)
public class OperationServiceTest {

    @Autowired
    private OperationService operationService;
    @MockBean
    private OperationRepository operationRepository;
    @MockBean
    private CardRepository cardRepository;
    @MockBean
    private UserRepository userRepository;

    @Test
    void getById() {
        Long operationId = 1L;
        Operation operation = OperationBuilder.getOperation();

        Mockito.when(operationRepository.findById(operationId)).thenReturn(Optional.of(operation));

        OperationResponse response = operationService.getById(operationId);
        Assertions.assertEquals(response.getId(), operationId);
    }

    @Test
    void getByIdWithError() {
        Long operationId = 1L;

        Mockito.when(operationRepository.findById(operationId)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> operationService.getById(operationId));
    }

    @Test
    void getOperationByUserId() {
        Long userId = 1L;
        List<Operation> operations = List.of(OperationBuilder.getOperation());

        Mockito.when(operationRepository.findAllByUserId(userId)).thenReturn(operations);

        List<OperationResponse> responses = operationService.getOperationByUserId(userId);
        Assertions.assertEquals(responses.size(), operations.size());
    }

    @Test
    void addOperation() {
        User user = UserBuilder.getUser();
        Card card = CardBuilder.getCard(user);
        Operation operation = OperationBuilder.getOperation();
        OperationRequest request = OperationBuilder.getOperationRequestWithAdding();

        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Mockito.when(cardRepository.findById(any())).thenReturn(Optional.of(card));
        Mockito.when(cardRepository.saveAndFlush(any())).thenReturn(card);
        Mockito.when(operationRepository.saveAndFlush(any())).thenReturn(operation);

        OperationResponse response = operationService.addOperation(request);
        Assertions.assertEquals(response.getId(), operation.getId());
    }

}
