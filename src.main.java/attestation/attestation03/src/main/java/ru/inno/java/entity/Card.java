package ru.inno.java.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.inno.java.constants.CardType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
    @SequenceGenerator(name = "card_seq")
    private Long id;

    private String number;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    private Long balance = 0L;

    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "card")
    private List<Operation> operation;

}
