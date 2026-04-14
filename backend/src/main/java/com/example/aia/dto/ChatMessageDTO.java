package com.example.aia.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatMessageDTO(
        @NotBlank String sessionId,
        @NotBlank String skillCode,
        @NotBlank String message
) {
}
