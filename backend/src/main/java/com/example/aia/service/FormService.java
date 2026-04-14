package com.example.aia.service;

import com.example.aia.dto.FormDataDTO;
import com.example.aia.dto.FormSaveResultDTO;
import com.example.aia.dto.FormValidationResultDTO;

import java.util.Map;

public interface FormService {
    FormValidationResultDTO validate(FormDataDTO request);

    FormSaveResultDTO save(FormDataDTO request);

    Map<String, Object> detail(String id);
}
