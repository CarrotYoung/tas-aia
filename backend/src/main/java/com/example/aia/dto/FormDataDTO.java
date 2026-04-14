package com.example.aia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Map;

public record FormDataDTO(
        @NotBlank String sessionId,
        @NotBlank String skillCode,
        @NotEmpty Map<String, Object> payload
) {
}
