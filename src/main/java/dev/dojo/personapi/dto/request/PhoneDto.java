package dev.dojo.personapi.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import dev.dojo.personapi.models.enumerators.PhoneTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneDto {
    private Long id;
    private PhoneTypeEnum type;
    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
