package ru.inno.java.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq")
    private Long id;

    private String name;

    private LocalDate birthday;

    private String email;

    private String password;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    private Boolean deleted = false;

    @OneToMany(mappedBy = "user")
    private List<Card> cards;

    @OneToMany(mappedBy = "user")
    private List<Operation> operation;
}
