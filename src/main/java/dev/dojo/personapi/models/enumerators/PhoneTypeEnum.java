package dev.dojo.personapi.models.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneTypeEnum {
    HOME(""),
    MOBILE(""),
    COMERCIAL("");

    private final String description;
}
