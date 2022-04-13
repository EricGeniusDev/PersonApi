package dev.dojo.personapi.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import dev.dojo.personapi.models.enumerators.PhoneTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Phone")
public class Phone {
    private Long id;
    private PhoneTypeEnum phoneType;
    private String number;
}
