package com.esad.assignment.ticketingsystem.model;

import com.esad.assignment.ticketingsystem.model.enums.UserType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(unique = true)
    private String nic;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(columnDefinition = "decimal(8,2)")
    private Double currentBalance;

//    @ManyToOne
//    @JoinColumn(name = "")
//    private Vehicle vehicle
}
