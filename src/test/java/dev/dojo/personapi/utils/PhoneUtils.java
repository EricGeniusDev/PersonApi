package dev.dojo.personapi.utils;

import dev.dojo.personapi.dto.request.PhoneDto;
import dev.dojo.personapi.models.Phone;
import dev.dojo.personapi.models.enumerators.PhoneTypeEnum;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneTypeEnum PHONE_TYPE = PhoneTypeEnum.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDto createFakeDTO() {
        return PhoneDto.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
