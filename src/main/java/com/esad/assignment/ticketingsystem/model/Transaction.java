package com.esad.assignment.ticketingsystem.model;

import com.esad.assignment.ticketingsystem.model.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_transactions")
@Getter
@Setter
public class Transaction extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "amount", columnDefinition = "Decimal(8,2)")
    private Double amount;

    @CreationTimestamp
    private Timestamp createdAt;

}
