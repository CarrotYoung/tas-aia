package com.example.aia.service.impl;

import com.example.aia.dto.FormDataDTO;
import com.example.aia.dto.FormSaveResultDTO;
import com.example.aia.dto.FormValidationResultDTO;
import com.example.aia.service.FormService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryFormService implements FormService {

    private final Map<String, Map<String, Object>> db = new ConcurrentHashMap<>();

    @Override
    public FormValidationResultDTO validate(FormDataDTO request) {
        List<String> errors = new ArrayList<>();
        if (!request.payload().containsKey("title")) {
            errors.add("缺少 title 字段");
        }
        if (!request.payload().containsKey("amount")) {
            errors.add("缺少 amount 字段");
        }
        return new FormValidationResultDTO(errors.isEmpty(), errors);
    }

    @Override
    public FormSaveResultDTO save(FormDataDTO request) {
        String id = UUID.randomUUID().toString();
        Map<String, Object> row = new HashMap<>(request.payload());
        row.put("id", id);
        row.put("sessionId", request.sessionId());
        row.put("skillCode", request.skillCode());
        db.put(id, row);
        return new FormSaveResultDTO(id, "保存成功");
    }

    @Override
    public Map<String, Object> detail(String id) {
        return db.getOrDefault(id, Map.of());
    }
}
