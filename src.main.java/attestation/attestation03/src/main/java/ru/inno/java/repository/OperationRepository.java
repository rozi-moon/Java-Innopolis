package ru.inno.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.java.entity.Operation;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findAllByUserId(Long userId);

}
