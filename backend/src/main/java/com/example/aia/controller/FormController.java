package com.example.aia.controller;

import com.example.aia.dto.ApiResponse;
import com.example.aia.dto.FormDataDTO;
import com.example.aia.dto.FormSaveResultDTO;
import com.example.aia.dto.FormValidationResultDTO;
import com.example.aia.service.FormService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/forms")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/validate")
    public ApiResponse<FormValidationResultDTO> validate(@Valid @RequestBody FormDataDTO request) {
        return ApiResponse.ok(formService.validate(request));
    }

    @PostMapping("/save")
    public ApiResponse<FormSaveResultDTO> save(@Valid @RequestBody FormDataDTO request) {
        return ApiResponse.ok(formService.save(request));
    }

    @GetMapping("/{id}")
    public ApiResponse<Map<String, Object>> detail(@PathVariable String id) {
        return ApiResponse.ok(formService.detail(id));
    }
}
