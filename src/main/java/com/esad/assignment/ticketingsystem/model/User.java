package com.esad.assignment.ticketingsystem.model;

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

    private String nic;
    private String firstName;
    private String lastName;
}
