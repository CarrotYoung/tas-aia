package com.example.aia.dto;

import java.util.List;

public record FormValidationResultDTO(boolean valid, List<String> errors) {
}
