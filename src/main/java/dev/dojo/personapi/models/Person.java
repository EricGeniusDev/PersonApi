package dev.dojo.personapi.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {
    @Id
    private Long id;

    private String firstName;

    private String lastName;
    private String cpf;
    private LocalDate startDate;

}
