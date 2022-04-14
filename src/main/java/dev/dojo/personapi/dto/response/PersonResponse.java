package dev.dojo.personapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
public class PersonResponse {
    private String message;
}
